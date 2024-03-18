/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.automataspokemon;

import java.util.Scanner;

/**
 *
 * @author Camilo & Paula
 */
public class Manager {
    
    
    public void crearPokemon() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al creador de autómatas Pokemon:");
        System.out.println("Para empezar, elija el tipo de autómata: \n1. Finito Determinista \n2. Finito no determinista \n3. Lambda");
        try {
            int tipo = scanner.nextInt();
            switch(tipo) {
                case 1: {
                    crearDeterminista();
                    break;
                }
                case 2: {
                    crearNoDeterminista();
                    break;
                }
                case 3: {
                    crearLambda();
                }
                default: {
                    System.out.println("Por favor eliga una opción válida!");
                    System.out.println("----------------------------------\n\n\n");
                    crearPokemon();
                }
            }
        } catch(Exception e) {
            System.out.println("Por favor eliga una opción válida!");
            System.out.println("----------------------------------\n\n\n");
            crearPokemon();
        }
        
    }
    
    
    
    private void crearDeterminista() {
        
    }
    
    private void crearNoDeterminista() {
        
    }
    
    private void crearLambda() {
        
    }
    
    
}
