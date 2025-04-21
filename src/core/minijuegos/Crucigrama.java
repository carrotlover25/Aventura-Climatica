/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.minijuegos;

import aventuraclimatica.Minijuego;
import java.util.Scanner;

public class Crucigrama implements Minijuego {

    @Override
    public void play() {
        Scanner sc = new Scanner(System.in);

        String palabra1 = "reciclar";
        String pista1 = "Acción que ayuda a reducir residuos y reutilizar materiales.";
        jugarPalabra(sc, palabra1, pista1);

        
        String palabra2 = "agua";
        String pista2 = "Recurso natural esencial para la vida y el planeta";
        jugarPalabra(sc, palabra2, pista2);

       
        String palabra3 = "energía";
        String pista3 = "Puede ser renovable o no, pero la del sol y el viento son ecológicas.";
        jugarPalabra(sc, palabra3, pista3);

        System.out.println("🎉 ¡Terminaste el juego! ¡Gracias por cuidar el planeta! 🌱");
    }

    public void jugarPalabra(Scanner sc, String palabra, String pista) {
        int intentos = 2;

        System.out.println("🧩 Pista: " + pista);
        System.out.println("Primera letra: " + palabra.charAt(0));

       
        while (intentos > 0) {
            System.out.print("¿Cuál es la palabra? ");
            String intento = sc.nextLine().toLowerCase();

            if (intento.equals(palabra)) {
                System.out.println("✅ ¡Correcto!\n");
                return;
            } else {
                System.out.println("❌ Incorrecto.");
                intentos--;
            }
        }

        
        System.out.println("Letra extra: " + palabra.substring(0, 2));
        System.out.print("Último intento: ");
        String intentoFinal = sc.nextLine().toLowerCase();

        if (intentoFinal.equals(palabra)) {
            System.out.println("✅ ¡Correcto!\n");
        } else {
            System.out.println("❌ La palabra correcta era: " + palabra + "\n");
        }
    }
}
