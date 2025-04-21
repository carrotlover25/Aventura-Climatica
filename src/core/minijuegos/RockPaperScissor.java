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
public class RockPaperScissor implements Minijuego {
     private String[] OPCIONES = {"Piedra (Montaña)", "Papel (Bosque)", "Tijera (Contaminación)"};

    @Override
    public void play(){
        System.out.println("Bienvenid@ a Piedra, Papel o Tijera");
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean gano = false;

        System.out.println("\n🌿 Bienvenido a Piedra, Papel o Tijera - Versión Ecológica 🌎");
        System.out.println("En la versión ecológico, los clásicos elementos toman nuevos significados:");

        while (!gano) {
            System.out.println("================================");
            System.out.println("1. Piedra (Montaña)");
            System.out.println("2. Papel (Árboles)");
            System.out.println("3. Tijera (Deforestación)");

            int eleccionJugador = 0;
            while (true) {
                
                System.out.print("Elige una opción: 1 (Piedra), 2 (Papel), 3 (Tijera): ");
                int input = sc.nextInt();

                if (input == 1 || input == 2 || input == 3) { // verifica que es un solo dígito
                    eleccionJugador = input;
                    break;
                    
                }
                System.out.println("❌ Entrada inválida. Ingresa 1, 2 o 3.");
            }

            int eleccionComputadora = rand.nextInt(3) + 1;

            System.out.println("Tu elección: " + OPCIONES[eleccionJugador - 1]);
            System.out.println("Computadora eligió: " + OPCIONES[eleccionComputadora - 1]);

            int resultado = determinarGanador(eleccionJugador, eleccionComputadora);
            switch (resultado) {
                case 0:
                    System.out.println("🤝 ¡Empate!");
                    break;
                case 1:
                    System.out.println("🎉 ¡Ganaste esta ronda!");
                    System.out.println(fraseAmbiental(eleccionJugador, eleccionComputadora));
                    gano = true;
                    break;
                case -1:
                    System.out.println("💥 Perdiste esta ronda.");
                    System.out.println(fraseAmbiental(eleccionComputadora, eleccionJugador));
                    break;
            }
        }
    }

     private int determinarGanador(int jugador, int computadora) {
        // 1: Piedra, 2: Papel, 3: Tijera
        if (jugador == computadora) return 0;

        if ((jugador == 1 && computadora == 3) || // Piedra vence a Tijera
            (jugador == 2 && computadora == 1) || // Papel vence a Piedra
            (jugador == 3 && computadora == 2)) { // Tijera vence a Papel
            return 1; // Gana jugador
        }

        return -1; // Pierde jugador
    }

    private String fraseAmbiental(int ganador, int perdedor) {
        if (ganador == 1 && perdedor == 3) {
            return "🌍 Piedra vence a Tijera: la tierra resiste la contaminación.";
        } else if (ganador == 3 && perdedor == 2) {
            return "✂️ Tijera vence a Papel: la deforestación acaba con los árboles.";
        } else if (ganador == 2 && perdedor == 1) {
            return "🌳 Papel vence a Piedra: los bosques cubren y protegen la tierra.\n";
        } else {
            return "";
        }
    }

}
