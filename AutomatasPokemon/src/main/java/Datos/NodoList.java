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
public class NodoList {
    public int nodoInicial;
    private ArrayList<Nodo> Nodos;
    private int currentId;
    
    public NodoList() {
        this.currentId = 0;
        this.nodoInicial = 0;
        this.Nodos = new ArrayList<Nodo>();        
    }
    
    public int addNodo(boolean aceptacion) {
        Nodo nuevoNodo = new Nodo(currentId, aceptacion);
        this.Nodos.add(nuevoNodo);
        this.currentId++;
        return nuevoNodo.id;
    }
    
    public boolean deleteNodo(int id) {
        try{
            if(this.Nodos.removeIf(nodo -> nodo.id == id)) {
                for(Nodo nodo : Nodos) {
                    nodo.eliminarEnlace(id);
                }
            }
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    public Nodo getNodo(int id) {
        return this.Nodos.stream().filter(nodo -> nodo.id == id).findAny().get();
    }
    
    public void printList() {
        for(Nodo nodo : Nodos) {
            System.out.println(nodo);
        }
    }
}
