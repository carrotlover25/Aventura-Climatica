/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.minijuegos;

import aventuraclimatica.Minijuego;
import java.util.Random;
import java.util.Scanner;

public class Crucigrama implements Minijuego {

    @Override
    public void play() {
        boolean gano = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenid@ a Adivina la palabra con temática ecológica");
        String palabra = "";
        String pista = "";

        while (!gano) {
            int opcion = new Random().nextInt(5); 
            switch (opcion) {
            case 0 -> {
                palabra = "reciclar";
                pista = "Acción que ayuda a reducir residuos y reutilizar materiales.";
            }
            case 1 -> {
                palabra = "agua";
                pista = "Recurso natural esencial para la vida y el planeta.";
            }
            case 2 -> {
                palabra = "energia";
                pista = "Puede ser renovable o no, pero la del sol y el viento son ecológicas.";
            }
            case 3 -> {
                palabra = "bosque";
                pista = "Hogar de muchos seres vivos y fundamental para el equilibrio del planeta.";
            }
            case 4 -> {
                palabra = "compostar";
                pista = "Proceso natural que convierte residuos orgánicos en abono.";
            }
            default -> {
                System.out.println("Ocurrió un error al seleccionar la palabra.");
                return;
            }
        }

        gano = jugarPalabra(sc, palabra, pista);
       

        }
    }

    public boolean jugarPalabra(Scanner sc, String palabra, String pista) {
        int intentos = 2;
        System.out.println("================================");
        System.out.println("🧩 Pista: " + pista);
        System.out.println("Primera letra: " + palabra.charAt(0));

       
        while (intentos > 0) {
            System.out.print("¿Cuál es la palabra? ");
            String intento = sc.nextLine().toLowerCase();

            if (intento.equals(palabra)) {
                System.out.println("✅ ¡Correcto!\n");
                 System.out.println("🎉 ¡Gracias por cuidar el planeta! 🌱");
                return true;
            } else {
                System.out.println("❌ Incorrecto.");
                intentos--;
                return false;
            }
        }

        
        System.out.println("Letra extra: " + palabra.substring(0, 2));
        System.out.print("Último intento: ");
        String intentoFinal = sc.nextLine().toLowerCase();

        if (intentoFinal.equals(palabra)) {
            System.out.println("✅ ¡Correcto!\n");
             System.out.println("🎉 ¡Gracias por cuidar el planeta! 🌱");
            return true;
        } else {
            System.out.println("❌ La palabra correcta era: " + palabra + "\n");
              return false;
        }
    }
}
