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
public class TempSecreta implements Minijuego {

    @Override
    public void play() {
        System.out.println("🌿 Bienvenid@ a: Adivina el número ecológico (1 al 10)");
        System.out.println("Tienes 5 intentos. ¡Buena suerte!");

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        boolean gano = false;
        while (!gano) {
            System.out.println("================================");
            int numeroSecreto = rand.nextInt(10) + 1; // Número aleatorio entre 1 y 10
            int intentos = 5;
            boolean adivinaste = false;

            while (intentos > 0) {
                System.out.print("Elige un número del 1 al 10: ");
                int intento = sc.nextInt();

                if (intento == numeroSecreto) {
                    System.out.println("🎉 ¡Correcto! Adivinaste el número.");
                    mostrarDatoEcologico(intento);
                    adivinaste = true;
                    gano = true; // El jugador ha ganado
                    break;
                } else {
                    System.out.println("❌ Nope, intenta de nuevo.");
                    intentos--;
                    if (intento < numeroSecreto) {
                        System.out.println("El número es mayor.");
                    } else {
                        System.out.println("El número es menor.");
                    }
                    if (intentos > 0) System.out.println("Te quedan " + intentos + " intento(s). \n");
                }
            }

            if (!adivinaste) {
                System.out.println("💥 Se acabaron los intentos. El número era: " + numeroSecreto);
                mostrarDatoEcologico(numeroSecreto); 
            }
        }
    }

  
    private void mostrarDatoEcologico(int numero) {
        switch (numero) {
            case 2:
                System.out.println("♻️ Si reciclas una sola botella de plástico, ahorras suficiente energía para mantener encendida una bombilla durante 6 horas.");
                break;
            case 5:
                System.out.println("🚿 Cerrar el grifo mientras te cepillas los dientes puede ahorrar más de 20 litros de agua al día.");
                break;
            case 7:
                System.out.println("🌳 Plantar un árbol puede absorber hasta 22 kg de CO₂ al año. ¡Uno solo ya hace la diferencia!");
                break;
            case 9:
                System.out.println("🚶 Caminar o usar la bici en lugar del carro por trayectos cortos reduce tu huella de carbono drásticamente.");
                break;
            default:
                System.out.println("🌱 Dato ecológico: Apagar los aparatos electrónicos que no estés usando puede reducir mucho tu consumo de energía.");
                break;
        }
    }
}
