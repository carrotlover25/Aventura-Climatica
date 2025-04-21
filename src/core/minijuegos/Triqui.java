/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.minijuegos;

import aventuraclimatica.Minijuego;
import java.util.Random;
import java.util.Scanner;

public class Triqui implements Minijuego {
    @Override
    public void play() {
        System.out.println("🌎 Bienvenid@ a Triqui Ecológico 🌳 vs 🗑️");

        boolean gano = false;

        while (!gano) {
            System.out.println("================================");
            String[][] tablero = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
            };

            Scanner sc = new Scanner(System.in);
            Random rand = new Random();

            String JUGADOR = "🌳";
            String MAQUINA = "🗑️";
            boolean juegoActivo = true;

            while (juegoActivo) {
                mostrarTablero(tablero);
                turnoJugador(tablero, sc, JUGADOR);
                if (verificarGanador(tablero, JUGADOR)) {
                    mostrarTablero(tablero);
                    System.out.println("¡Ganaste, naturaleza triunfa! 🌳💪");
                    gano = true;
                    break;
                }
                if (tableroLleno(tablero)) {
                    mostrarTablero(tablero);
                    System.out.println("¡Empate!");
                    break;
                }

                turnoMaquina(tablero, rand, JUGADOR, MAQUINA);
                if (verificarGanador(tablero, MAQUINA)) {
                    mostrarTablero(tablero);
                    System.out.println("La máquina ganó... el planeta llora 😢");
                    break;
                }
                if (tableroLleno(tablero)) {
                    mostrarTablero(tablero);
                    System.out.println("¡Empate!");
                    break;
                }
            }
        }
    }

    private void mostrarTablero(String[][] tablero) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private void turnoJugador(String[][] tablero, Scanner sc, String jugador) {
        int fila, col;
        while (true) {
            System.out.print("Ingresa fila (0-2): ");
            fila = sc.nextInt();
            System.out.print("Ingresa columna (0-2): ");
            col = sc.nextInt();

            if (fila >= 0 && fila < 3 && col >= 0 && col < 3 && tablero[fila][col].equals(" ")) {
                tablero[fila][col] = jugador;
                break;
            } else {
                System.out.println("Movimiento inválido, intenta de nuevo.");
            }
        }
    }

    private void turnoMaquina(String[][] tablero, Random rand, String jugador, String maquina) {
        if (moverInteligente(tablero, maquina, maquina)) return;
        if (moverInteligente(tablero, jugador, maquina)) return;

        int fila, col;
        do {
            fila = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (!tablero[fila][col].equals(" "));

        tablero[fila][col] = maquina;
        System.out.println("La máquina ha hecho su jugada.");
    }

    private boolean moverInteligente(String[][] tablero, String simbolo, String ponerSimbolo) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals(" ")) {
                    tablero[i][j] = simbolo;
                    if (verificarGanador(tablero, simbolo)) {
                        tablero[i][j] = ponerSimbolo;
                        System.out.println("La máquina ha hecho su jugada.");
                        return true;
                    }
                    tablero[i][j] = " ";
                }
            }
        }
        return false;
    }

    private boolean verificarGanador(String[][] tablero, String simbolo) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].equals(simbolo) && tablero[i][1].equals(simbolo) && tablero[i][2].equals(simbolo)) return true;
            if (tablero[0][i].equals(simbolo) && tablero[1][i].equals(simbolo) && tablero[2][i].equals(simbolo)) return true;
        }
        if (tablero[0][0].equals(simbolo) && tablero[1][1].equals(simbolo) && tablero[2][2].equals(simbolo)) return true;
        if (tablero[0][2].equals(simbolo) && tablero[1][1].equals(simbolo) && tablero[2][0].equals(simbolo)) return true;
        return false;
    }

    private boolean tableroLleno(String[][] tablero) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j].equals(" "))
                    return false;
        return true;
    }
}

