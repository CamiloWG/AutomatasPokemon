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
    
    public void crearPokemon(boolean welcome) {
        Scanner scanner = new Scanner(System.in);
        if(welcome) {
            System.out.println("Bienvenido al creador de autómatas Pokemon:");
            System.out.println("Para empezar, elija el tipo de autómata: \n1. Finito Determinista \n2. Finito no determinista \n3. Lambda");
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
        System.out.println(" | ------ 5. Volver al menú principal - |");
        try {
            int tipo = scanner.nextInt();
            switch(tipo) {
                case 1: {
                    
                    break;
                }
                case 2: {
                    
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
                    System.out.println("----------------------------------\n\n\n");
                    menuDeterminista();
                }
            }
        } catch(Exception e) {
            System.out.println("Por favor eliga una opción válida!");
            System.out.println("----------------------------------\n\n\n");
            menuDeterminista();
        }
        
    }
    
    private void menuNoDeterminista() {
        
    }
    
    private void menuLambda() {
        
    }
    
    
}
