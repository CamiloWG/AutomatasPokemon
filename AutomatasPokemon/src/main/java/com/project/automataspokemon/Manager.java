/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.automataspokemon;

import Automatas.AFD;
import Automatas.AFN;
import Automatas.Lambda;
import java.util.Scanner;

/**
 *
 * @author Camilo & Paula
 */
public class Manager {
    
    private AFD automataAFD;
    private AFN automataAFN;
    private Lambda automataLambda;
    private boolean editing;
    
    public Manager() {
        this.automataAFD = null;
        this.automataAFN = null;
        this.automataLambda = null;
        this.editing = false;
    }
    
    public void crearPokemon(boolean welcome) {
        Scanner scanner = new Scanner(System.in);
        if(welcome) {
            System.out.println("Bienvenido al creador de autómatas Pokemon:");
            
        }
        System.out.println("Elija el tipo de autómata: \n1. Finito Determinista \n2. Finito no determinista \n3. Lambda\n4. Salir");
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
                    boxMessage("Ejecución finalizada!");
                    break;
                }
                default: {
                    boxMessage("Por favor elija una opción válida!");
                    crearPokemon(false);
                }
            }
        } catch(Exception e) {
            boxMessage("Por favor elija una opción válida!");
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
        System.out.println(" | ------ 6. Volver al menú principal - |");
        try {
            int tipo = scanner.nextInt();
            if(tipo >= 2 && tipo <= 5 && this.automataAFD == null) {
                boxMessage("No hay un automata para esta opción! :(");
                menuDeterminista();
            }
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
                            boxMessage("Creado Automata Finito Determinista con el estado inicial Q0");
                        } else boxMessage("Cancelado!");
                    }
                    break;
                }
                case 2: { 
                    int opcion = 7;
                    do {
                        opcion = menuEdicion();
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
                    }while(opcion != 7);
                    
                    break;
                }
                case 3: {
                    this.automataAFD.printAutomata();
                    break;
                }
                case 4: {
                    boxMessage("¿Estás seguro que quieres eliminar el automata?");
                    System.out.println("Y = Aceptar | Otro caracter = Cancelar");
                    String opc = scanner.next().toUpperCase();
                    if("Y".equals(opc)) {
                        this.automataAFD = null;
                        boxMessage("El autómata determinista ha sido eliminado exitosamente!");
                    } else boxMessage("Cancelado!");
                    break;
                }
                case 5: {
                    this.automataAFD.validarCadenaConsola();
                    break;
                }
                case 6: {
                    crearPokemon(false);
                    return;
                }
                    
                default: {
                    boxMessage("Por favor elija una opción válida!");
                    menuDeterminista();
                    break;
                }
            }
        } catch(Exception e) {
            boxMessage("Por favor elija una opción válida!");
            menuDeterminista();
        }
        menuDeterminista();
        
    }
    
    private void menuNoDeterminista() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println(" | ---- Autómata finito no determinista : ---- |");
        System.out.println(" | ----------- 1. Crear Autómata ------------- |");
        System.out.println(" | ----------- 2. Editar Autómata ------------ |");
        System.out.println(" | ----------- 3. Ver Autómata --------------- |");
        System.out.println(" | ----------- 4. Borrar Autómata ------------ |");
        System.out.println(" | ----------- 5. Usar Autómata -------------- |");
        System.out.println(" | ----------- 6. Transformar a AFD ---------- |");
        System.out.println(" | ----------- 7. Volver al menú principal --- |");
        try {
            int tipo = scanner.nextInt();
            if(tipo >= 2 && tipo <= 6 && this.automataAFN == null) {
                boxMessage("No hay un automata para esta opción! :(");
                menuNoDeterminista();
            }
            switch(tipo) {
                case 1: {
                    if(this.automataAFN == null) {
                        this.automataAFN = new AFN();
                        System.out.println("Creado Automata Finito no Determinista con el estado inicial Q0");
                    } else {
                        System.out.println("Ya hay un automata creado, ¿deseas crear uno nuevo?");
                        System.out.println("ADVERTENCIA: Se eliminará el autómata anterior");
                        System.out.println("Y = Crear uno nuevo | Cualquier otro caracter para cancelar");
                        String keyboard = scanner.next().toUpperCase();
                        if("Y".equals(keyboard)) {
                            this.automataAFN = new AFN();
                            boxMessage("Creado Automata Finito no Determinista con el estado inicial Q0");
                        } else boxMessage("Cancelado!\n\n");
                    }
                    break;
                }
                case 2: { 
                    int opcion = 7;
                    do {
                        opcion = menuEdicion();
                        switch(opcion) {
                            case 1: {
                                this.automataAFN.crearEstadoConsola();
                                break;
                            }
                            case 2: {
                                this.automataAFN.eliminarEstadoConsola();
                                break;
                            }
                            case 3: {
                                this.automataAFN.crearEnlaceConsola();
                                break;
                            }
                            case 4: {
                                this.automataAFN.eliminarEnlaceConsola();
                                break;
                            }
                            case 5: {
                                this.automataAFN.cambiarAceptacionConsola();
                                break;
                            }
                            case 6: {
                                this.automataAFN.cambiarInicialConsola();
                                break;
                            }
                            default: break;
                        }    
                    }while(opcion != 7);
                    
                    break;
                }
                case 3: {
                    this.automataAFN.printAutomata();
                    break;
                }
                case 4: {
                    boxMessage("¿Estás seguro que quieres eliminar el automata?");
                    System.out.println("Y = Aceptar | Otro caracter = Cancelar");
                    String opc = scanner.next().toUpperCase();
                    if("Y".equals(opc)) {
                        this.automataAFN = null;
                        boxMessage("El autómata determinista ha sido eliminado exitosamente!");
                    } else boxMessage("Cancelado!");
                    break;
                }
                case 5: {
                    this.automataAFN.validarCadenaConsola();
                    break;
                }
                case 6: {
                    if(this.automataAFD == null) {
                        this.automataAFD = this.automataAFN.transformarAfdConsola();
                        boxMessage("Nuevo AFD creado exitosamente a partir del AFN");
                        System.out.println("(Para usarlo por favor vuelva al menú inicial)");
                    } else {
                        System.out.println("Ya hay un automata determinsita creado, ¿deseas reemplazarlo con la transformacion del AFN?");
                        System.out.println("ADVERTENCIA: Se eliminará el autómata determinista anterior");
                        System.out.println("Y = Continuar | Cualquier otro caracter para cancelar");
                        String keyboard = scanner.next().toUpperCase();
                        if("Y".equals(keyboard)) {
                            this.automataAFD = this.automataAFN.transformarAfdConsola();
                            boxMessage("Nuevo AFD creado exitosamente a partir del AFN");
                            System.out.println("(Para usarlo por favor vuelva al menú inicial)");
                        } else boxMessage("Cancelado!\n\n");
                    }
                    
                    break;
                }
                case 7: {
                    crearPokemon(false);
                    return;
                }
                    
                default: {
                    boxMessage("Por favor elija una opción válida!");
                    menuNoDeterminista();
                    break;
                }
            }
        } catch(Exception e) {
            boxMessage("Por favor elija una opción válida!");
            menuNoDeterminista();
        }
        menuNoDeterminista();
        
    }
    
    private void menuLambda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println(" | - Autómata finito no determinista Lambda: - |");
        System.out.println(" | ----------- 1. Crear Autómata ------------- |");
        System.out.println(" | ----------- 2. Editar Autómata ------------ |");
        System.out.println(" | ----------- 3. Ver Autómata --------------- |");
        System.out.println(" | ----------- 4. Borrar Autómata ------------ |");
        System.out.println(" | ----------- 5. Usar Autómata -------------- |");
        System.out.println(" | ----------- 6. Transformar a AFN ---------- |");
        System.out.println(" | ----------- 7. Volver al menú principal --- |");
        try {
            int tipo = scanner.nextInt();
            if(tipo >= 2 && tipo <= 6 && this.automataLambda == null) {
                boxMessage("No hay un automata para esta opción! :(");
                menuLambda();
            }
            switch(tipo) {
                case 1: {
                    if(this.automataLambda == null) {
                        this.automataLambda = new Lambda();
                        System.out.println("Creado Automata Finito no Determinista con transiciones Lambda con el estado inicial Q0");
                    } else {
                        System.out.println("Ya hay un automata creado, ¿deseas crear uno nuevo?");
                        System.out.println("ADVERTENCIA: Se eliminará el autómata anterior");
                        System.out.println("Y = Crear uno nuevo | Cualquier otro caracter para cancelar");
                        String keyboard = scanner.next().toUpperCase();
                        if("Y".equals(keyboard)) {
                            this.automataLambda = new Lambda();
                            boxMessage("Creado Automata Finito no Determinista con transiciones Lambda n con el estado inicial Q0");
                        } else boxMessage("Cancelado!\n\n");
                    }
                    break;
                }
                case 2: { 
                    int opcion = 7;
                    do {
                        opcion = menuEdicion();
                        switch(opcion) {
                            case 1: {
                                this.automataLambda.crearEstadoConsola();
                                break;
                            }
                            case 2: {
                                this.automataLambda.eliminarEstadoConsola();
                                break;
                            }
                            case 3: {
                                this.automataLambda.crearEnlaceConsola();
                                break;
                            }
                            case 4: {
                                this.automataLambda.eliminarEnlaceConsola();
                                break;
                            }
                            case 5: {
                                this.automataLambda.cambiarAceptacionConsola();
                                break;
                            }
                            case 6: {
                                this.automataLambda.cambiarInicialConsola();
                                break;
                            }
                            default: break;
                        }    
                    }while(opcion != 7);
                    
                    break;
                }
                case 3: {
                    this.automataLambda.printAutomata();
                    break;
                }
                case 4: {
                    boxMessage("¿Estás seguro que quieres eliminar el automata?");
                    System.out.println("Y = Aceptar | Otro caracter = Cancelar");
                    String opc = scanner.next().toUpperCase();
                    if("Y".equals(opc)) {
                        this.automataLambda = null;
                        boxMessage("El autómata determinista ha sido eliminado exitosamente!");
                    } else boxMessage("Cancelado!");
                    break;
                }
                case 5: {
                    this.automataLambda.validarCadenaConsola();
                    break;
                }
                case 6: {
                    this.automataLambda.transformarAfnConsola();
                    break;
                }
                case 7: {
                    crearPokemon(false);
                    return;
                }
                    
                default: {
                    boxMessage("Por favor elija una opción válida!");
                    menuLambda();
                    break;
                }
            }
        } catch(Exception e) {
            boxMessage("Por favor elija una opción válida!");
            menuLambda();
        }
        menuLambda();
        
    }
    
    private int menuEdicion() {
        Scanner scan = new Scanner(System.in);
        System.out.println("_______MENU EDICION AUTOMATA________");
        System.out.println("| 1. Crear estado                  |");
        System.out.println("| 2. Eliminar estado               |");
        System.out.println("| 3. Crear transicion              |");
        System.out.println("| 4. Eliminar transicion           |");
        System.out.println("| 5. Editar estados de aceptacion  |");
        System.out.println("| 6. Cambiar estado inicial        |");
        System.out.println("| 7. Volver                        |");
        System.out.println("|----------------------------------|");
        try {
            int opc = scan.nextInt();
            if(opc >= 1 && opc <= 7) return opc;
            else boxMessage("Ingrese una opción valida!");
        } catch(Exception ex) {
            boxMessage("Ingrese una opción valida!");
        }
        return menuEdicion();
    }
    
    
    
    private void boxMessage(String msg) {
        String msgComp = "_".repeat(msg.length()+4)+"\n";
        msgComp += "| " + msg + " |\n";
        msgComp += "|" + "-".repeat(msg.length()+2) + "|\n\n";
        System.out.println(msgComp);
    }
    
}
