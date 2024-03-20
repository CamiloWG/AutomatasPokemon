/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.automataspokemon;

import Automatas.AFD;
import java.util.Scanner;

/**
 *
 * @author Camilo & Paula
 */
public class Manager {
    
    private AFD automataAFD;

    public Manager() {
        this.automataAFD = null;
    }
    
    public void crearPokemon(boolean welcome) {
        Scanner scanner = new Scanner(System.in);
        if(welcome) {
            System.out.println("Bienvenido al creador de autómatas Pokemon:");
            System.out.println("Para empezar, elija el tipo de autómata: \n1. Finito Determinista \n2. Finito no determinista \n3. Lambda\n4. Salir");
        }
        try {
            int tipo = scanner.nextInt();
            switch(tipo) {
                case 1: {
                    menuDeterminista();
                    break;
                }
                case 2: {
                    menuNoDeterminista();
                    break;
                }
                case 3: {
                    menuLambda();
                    break;
                }
                case 4: {
                    System.out.println("Ejecución finalizada!");
                    break;
                }
                default: {
                    System.out.println("Por favor eliga una opción válida!");
                    System.out.println("----------------------------------\n\n\n");
                    crearPokemon(false);
                }
            }
        } catch(Exception e) {
            System.out.println("Por favor eliga una opción válida!");
            System.out.println("----------------------------------\n\n\n");
            crearPokemon(false);
        }
        
    }
    
    
    
    private void menuDeterminista() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println(" | ------ Autómata determinista: ------ |");
        System.out.println(" | ------ 1. Crear Autómata ----------- |");
        System.out.println(" | ------ 2. Editar Autómata ---------- |");
        System.out.println(" | ------ 3. Ver Autómata ------------- |");
        System.out.println(" | ------ 4. Borrar Autómata ---------- |");
        System.out.println(" | ------ 5. Usar Autómata ------------ |");
        System.out.println(" | ------ 5. Volver al menú principal - |");
        try {
            int tipo = scanner.nextInt();
            switch(tipo) {
                case 1: {
                    if(this.automataAFD == null) {
                        this.automataAFD = new AFD();
                        System.out.println("Creado Automata Finito Determinista con el estado inicial Q0");
                    } else {
                        System.out.println("Ya hay un automata creado, ¿deseas crear uno nuevo?");
                        System.out.println("ADVERTENCIA: Se eliminará el autómata anterior");
                        System.out.println("Y = Crear uno nuevo | Cualquier otro caracter para cancelar");
                        String keyboard = scanner.next().toUpperCase();
                        if("Y".equals(keyboard)) {
                            this.automataAFD = new AFD();
                            System.out.println("Creado Automata Finito Determinista con el estado inicial Q0");
                        } else System.out.println("Cancelado!\n\n");
                    }
                    break;
                }
                case 2: {
                    if(this.automataAFD == null) {
                        System.out.println("No hay un automata para editar! :(");
                        break;
                    }
                    int opcion = menuEdicion();
                    System.out.println("opcion : "+opcion);
                    switch(opcion) {
                        case 1: {
                            this.automataAFD.crearEstadoConsola();
                            break;
                        }
                        case 2: {
                            this.automataAFD.eliminarEstadoConsola();
                            break;
                        }
                        case 3: {
                            this.automataAFD.crearEnlaceConsola();
                            break;
                        }
                        case 4: {
                            this.automataAFD.eliminarEnlaceConsola();
                            break;
                        }
                        case 5: {
                            this.automataAFD.cambiarAceptacionConsola();
                            break;
                        }
                        case 6: {
                            this.automataAFD.cambiarInicialConsola();
                            break;
                        }
                        default: break;
                    }
                    break;
                }
                case 3: {
                    
                    break;
                }
                case 4: {
                    
                    break;
                }
                case 5: {
                    
                    break;
                }
                    
                default: {
                    System.out.println("Por favor eliga una opción válida!");
                    System.out.println("----------------------------------\n\n");
                    menuDeterminista();
                }
            }
        } catch(Exception e) {
            System.out.println("Por favor eliga una opción válida!");
            System.out.println("----------------------------------\n\n");
            menuDeterminista();
        }
        menuDeterminista();
        
    }
    
    private void menuNoDeterminista() {
        
    }
    
    private void menuLambda() {
        
    }
    
    private int menuEdicion() {
        Scanner scan = new Scanner(System.in);
        System.out.println("____________________________________");
        System.out.println("| 1. Crear estado                  |");
        System.out.println("| 2. Eliminar estado               |");
        System.out.println("| 3. Crear enlace                  |");
        System.out.println("| 4. Eliminar enlace               |");
        System.out.println("| 5. Editar estados de aceptacion  |");
        System.out.println("| 6. Cambiar estado inicial        |");
        System.out.println("| 7. Volver                        |");
        System.out.println("|----------------------------------|");
        try {
            int opc = scan.nextInt();
            if(opc >= 1 && opc <= 7) return opc;
            else System.out.println("\nIngrese una opción valida!\n\n");
        } catch(Exception ex) {
            System.out.println("\nIngrese una opción valida!\n\n");
        }
        return menuEdicion();
    }
    
    
}
