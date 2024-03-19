/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automatas;

import Datos.Conexion;
import Datos.Nodo;
import Datos.NodoList;

/**
 *
 * @author Camilo & Paula
 */
public class AFD {
   private NodoList automata;
   
   
   public AFD() {
       this.automata = new NodoList();
       this.crearEstado(false);
   }
   
   private void crearEstado(boolean aceptacion) {
      this.automata.addNodo(aceptacion);
   }
   
   private boolean crearEnlace(int from, int to, String key) {
       try {
           Nodo nodoFrom = this.automata.getNodo(from);
           Conexion enlace = new Conexion(key, to);
           nodoFrom.agregarEnlace(enlace);
           return true;
       } catch(Exception e) {
           return false;
       }
   }
   
   
   private boolean eliminarEnlace(int from, int to, String key) {
       try {
           Nodo nodoFrom = this.automata.getNodo(from);
           Conexion enlaceToDel = new Conexion(key, to);
           nodoFrom.eliminarEnlace(enlaceToDel);
           return true;
       } catch(Exception e) {
           return false;
       }
   }
   
    
    
}
