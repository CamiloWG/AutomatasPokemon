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
    
    public boolean esAceptacion() {
        return this.aceptacion;
    }
    
    public void cambiarAceptacion() {
        this.aceptacion = !this.aceptacion;
    }
}
