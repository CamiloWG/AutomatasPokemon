/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automatas;

import Datos.Conexion;
import Datos.Nodo;
import Datos.NodoList;
import java.util.Scanner;

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
   
   private int crearEstado(boolean aceptacion) {
      return this.automata.addNodo(aceptacion);
   }
   
   private boolean eliminarEstado(int idEstado) {
       return this.automata.deleteNodo(idEstado);
   }
   
   private boolean crearEnlace(int from, int to, String key) {
       try {
           Nodo nodoFrom = this.automata.getNodo(from);
           Nodo nodoTo = this.automata.getNodo(to);
           if(nodoFrom.tieneEnlace(key)) {
               System.out.println("ERROR: Ya hay una transición desde este estado con el caracter: "+ key);
               return false;
           }
           Conexion enlace = new Conexion(key, to);
           nodoFrom.agregarEnlace(enlace);
           return true;
       } catch(Exception e) {
           System.out.println(e);
           return false;
       }
   }
   
   
   private boolean eliminarEnlace(int from, int to, String key) {
       try {
           Nodo nodoFrom = this.automata.getNodo(from);
           Conexion enlaceToDel = new Conexion(key, to);
           return nodoFrom.eliminarEnlace(enlaceToDel);
       } catch(Exception e) {
           return false;
       }
   }
   
   
   private boolean cambiarAceptacion(int idEstado) {
       try {
           Nodo estado = this.automata.getNodo(idEstado);
           estado.cambiarAceptacion();
           return true;
       } catch(Exception e) {
           return false;
       }
   }
   
   private boolean cambiarInicial(int idEstado) {
       try {
           Nodo estado = this.automata.getNodo(idEstado);
           this.automata.nodoInicial = idEstado;
           return true;
       } catch(Exception e) {
           return false;
       }
   }
   
   
   public void crearEstadoConsola() {
       Scanner scan = new Scanner(System.in);
       System.out.println("\n\n");
       System.out.println("________________________________");
       System.out.println("| ---- Creacion de estado ---- |");
       System.out.println("| ¿El estado es de aceptacion? |");
       System.out.println("|  Y = Si | Otro caracter = No |");
       String opc = scan.next().toUpperCase();
       int estado = crearEstado("Y".equals(opc));
       System.out.println("El estado "+ ("Y".equals(opc) ? "de aceptacion" : "") +" Q"+ estado + " se creó exitosamente\n\n");
   }
   
   public void eliminarEstadoConsola() {
       Scanner scan = new Scanner(System.in);
       System.out.println("\n\n");
       System.out.println("_________________________________");
       System.out.println("| --- Eliminacion de estado --- |");
       System.out.println("| Ingrese el número del estado: |");
       try {
           int num = scan.nextInt();
           if(eliminarEstado(num)) {
               System.out.println("El estado Q"+num+" se eliminó exitosamente");
           } else System.out.println("Por favor ingrese un estado existente!");
       } catch(Exception e) {
           System.out.println("ERROR: Ingrese números válidos");
       }
       System.out.println("\n\n");
   }
   
   public void crearEnlaceConsola() {
       Scanner scan = new Scanner(System.in);
       System.out.println("\n\n");
       System.out.println("____________________________________________________________");
       System.out.println("| ---------------- Creacion de transición ---------------- |");
       System.out.println("| Ingrese la transición a crear con la siguiente sintaxis: |");
       System.out.println("|        <numEstadoDesde> <caracter> <numEstadoHasta>      |");
       System.out.println("|                     Ejemplo: 1 b 3                       |");
       try {
           int from = scan.nextInt();
           String key = scan.next();
           int to = scan.nextInt();
           if(crearEnlace(from, to, key)) {
               System.out.println("Transición creada exitosamente:");
               System.out.println("Q"+from + " --"+key+"--> Q"+ to);
           } else System.out.println("Error al crear la transición");
       } catch(Exception e) {
           System.out.println("Por favor ingrese el comando correctamente!");
       }
       System.out.println("\n\n");      
   }
   
   public void eliminarEnlaceConsola() {
       Scanner scan = new Scanner(System.in);
       System.out.println("\n\n");
       System.out.println("_______________________________________________________________");
       System.out.println("| ---------------- Eliminacion de transición ---------------- |");
       System.out.println("| Ingrese la transición a eliminar con la siguiente sintaxis: |");
       System.out.println("|        <numEstadoDesde> <caracter> <numEstadoHasta>      |");
       System.out.println("|                     Ejemplo: 1 b 3                       |");
       try {
           int from = scan.nextInt();
           String key = scan.next();
           int to = scan.nextInt();
           if(eliminarEnlace(from, to, key)) {
               System.out.println("Transición eliminada exitosamente:");
               System.out.println("Q"+from + " --"+key+"--> Q"+ to);
           } else System.out.println("ERROR: No se encontro la transición a eliminar");
       } catch(Exception e) {
           System.out.println("Por favor ingrese el comando correctamente!");
       }
       System.out.println("\n\n");
   }
    
   public void cambiarAceptacionConsola() {
       Scanner scan = new Scanner(System.in);
       System.out.println("\n\n");
       System.out.println("___________________________________________");
       System.out.println("| ------- Cambio estado aceptacion ------ |");
       System.out.println("| Ingrese el número del estado a cambiar: |");
       try {
           int num = scan.nextInt();
           if(cambiarAceptacion(num)) {
               boolean acept = this.automata.getNodo(num).esAceptacion();
               System.out.println("Cambio exitoso!");
               System.out.println("Ahora el estado Q"+num+ (acept ? " es de aceptacion" : " NO es de aceptacion"));
           } else System.out.println("Por favor ingrese un estado existente!");
       } catch(Exception e) {
           System.out.println("ERROR: Ingrese números válidos");
       }
       System.out.println("\n\n");
   }
   
   public void cambiarInicialConsola() {
       Scanner scan = new Scanner(System.in);
       System.out.println("\n\n");
       System.out.println("_______________________________________________");
       System.out.println("| ---------- Cambio estado inicial ---------- |");
       System.out.println("| Ingrese el número del nuevo estado inicial: |");
       try {
           int num = scan.nextInt();
           if(cambiarInicial(num)) {
               System.out.println("Cambio exitoso!");
               System.out.println("Ahora el estado inicial es: Q" + num);
           } else System.out.println("Por favor ingrese un estado existente!");
       } catch(Exception e) {
           System.out.println("ERROR: Ingrese números válidos");
       }
       System.out.println("\n\n");
   }
    
}
