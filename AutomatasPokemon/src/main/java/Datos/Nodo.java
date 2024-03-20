/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author Camilo & Paula
 */
public class Nodo {
    public final int id;
    private ArrayList<Conexion> enlaces;
    private boolean aceptacion;
    
    public Nodo(int id, boolean aceptacion) {
        this.id = id;
        this.aceptacion = aceptacion;
        this.enlaces = new ArrayList<Conexion>();
    }
    
    public void agregarEnlace(Conexion enlace) {
        this.enlaces.add(enlace);
    }
    
    public boolean eliminarEnlace(Conexion enlace) {
        return this.enlaces.remove(enlace);
    }
    
    public boolean eliminarEnlace(int toNodoId) {
        return this.enlaces.removeIf(enlace -> enlace.To == toNodoId);
    }
    
    public boolean esAceptacion() {
        return this.aceptacion;
    }
    
    public void cambiarAceptacion() {
        this.aceptacion = !this.aceptacion;
    }
    
    public int getNextEstado(String key) {
        Conexion n = this.enlaces.stream().filter(enlace -> enlace.key.equals(key)).findAny().get();
        return n.To;
    }
    
    public boolean tieneEnlace(String key) {
        try {
            Conexion n = this.enlaces.stream().filter(enlace -> enlace.key.equals(key)).findAny().get();
            if(n != null) return true;
        } catch(Exception e) {
            return false;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String str = "Estado: Q" + this.id + " | " + (this.enlaces.isEmpty() ? "Sin transiciones" : "Transiciones: ");
        for(Conexion enlace : enlaces) {
            str += "Q"+this.id+"--"+ enlace.key + "-->Q"+ enlace.To + "  ";
        }
        str += " | Aceptacion: " + (this.aceptacion ? "Si" : "No");
        return str;
    }
}
