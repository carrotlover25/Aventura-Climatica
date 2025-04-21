/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.minijuegos;

import aventuraclimatica.Minijuego;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mfrey
 */
public class Completar implements Minijuego {

    private String[] OBJETOS = {"Botella de plástico", "Cartón", "Batería", "Envase de vidrio", "Papel"};
    private boolean[] RECICLABLE = {true, true, false, true, true}; // True = reciclable, false = no reciclable

    @Override
    public void play(){
        System.out.println("Bienvenid@ a Adivina si es reciclable");
        boolean gano = false;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while (!gano) {
                // Selecciona un objeto
            int i = rand.nextInt(OBJETOS.length);
            String objeto = OBJETOS[i];
            boolean esReciclable = RECICLABLE[i];


            System.out.println("================================");
            System.out.println("Objeto: " + objeto);
            System.out.println("¿Es reciclable?");
            System.out.println("1. Sí");
            System.out.println("2. No");

            int respuestaJugador = 0;
            boolean respuestaValida = false;
            while (!respuestaValida) {
                System.out.print("Ingresa tu respuesta (1 para Sí, 2 para No): ");
                if (sc.hasNextInt()) {
                    respuestaJugador = sc.nextInt();
                    if (respuestaJugador == 1 || respuestaJugador == 2) {
                        respuestaValida = true;  // Respuesta válida
                    } else {
                        System.out.println("❌ Por favor, ingresa 1 o 2.");
                    }
                } else {
                    System.out.println("❌ Entrada no válida. Ingresa un número.");
                    sc.next();  // Limpiar el buffer
                }
            }

            if (respuestaJugador == 1 && esReciclable) {
                System.out.println("✅ ¡Correcto! El " + objeto + " es reciclable.");
                gano = true; // El jugador ha ganado
                
            } else if(respuestaJugador == 2 && !esReciclable) {
                System.out.println("✅ ¡Correcto! El " + objeto + " NO es reciclable.");
                gano = true; // El jugador ha ganado
            } else {
                System.out.println("❌ ¡Incorrecto! Vuelve a intentarlo la próxima.");
            }
           
        }
        
       
    }

}
