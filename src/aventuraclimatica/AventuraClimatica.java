/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aventuraclimatica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mfrey
 */
public class AventuraClimatica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> numeros = new ArrayList<>();
        int NODO_SOSTENIBILIDAD = 0;
        ArrayList<Nodo> visitados = new ArrayList<>();
        Arbol miArbol = new Arbol();
      
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido a la gran Aventura Climática! 🌿");
        System.out.println("Encuentra el Nodo de Sostenibilidad que ayudara a salvar el planeta! 🌎");

        
        for (int i = 0; i < 63; i++) {
            int a = random.nextInt(99)+1;
            numeros.add(a);       
        }

        Collections.sort(numeros); // importante que esté ordenada

        miArbol.insertarBalanceado(numeros, 0, numeros.size() - 1, 1);

        ArrayList<Integer> ultimos = miArbol.obtenerNodosUltimoNivel();

       if (!ultimos.isEmpty()) {
            Random rand = new Random();
            int aleatorio = ultimos.get(rand.nextInt(ultimos.size()));
            NODO_SOSTENIBILIDAD = aleatorio;
        } else {
            System.out.println("El árbol está vacío o no tiene nodos en el último nivel.");
        }

        Nodo current = miArbol.raiz;


       // miArbol.imprimirArbol(miArbol.raiz, current, visitados);

        
        while (current != null){
            if (current.dato == NODO_SOSTENIBILIDAD){
                System.out.println("¡Felicidades! Has encontrado el Nodo de Sostenibilidad.");
                System.out.println("Has aprendido sobre el cambio climativo y como ayudar a salvar el planeta ¡Gracias por ayudar a salvar el planeta!");
                return;
            } 

            if (!visitados.contains(current)) {
                visitados.add(current);
            }

            miArbol.imprimirArbol(miArbol.raiz, current, visitados);

            System.out.println("juego actual: " + current.minigame_name);
            current.juego.play();

            System.out.println("Escriba (i) para ir a la izquierda.");
            System.out.println("Escriba (d) para ir a la derecha");
            if (current.padre != null) System.out.println("Escriba (b) para volver al nodo anterior.");
            System.out.println("Escriba (q) para salir del juego.");

            
            
            if (current.dato < NODO_SOSTENIBILIDAD){
                System.out.println("El número es menor que el Nodo de Sostenibilidad.");
            } else {
                System.out.println("El número es mayor que el Nodo de Sostenibilidad.");
            }


            String op = sc.nextLine().toLowerCase();

            if (op.equals("i") && current.izq != null) {
                current = current.izq;
            } else if (op.equals("d") && current.der != null) {
                current = current.der;
            } else if (op.equals("b") && current.padre != null) {
                current = current.padre;
            } else if (op.equals("q")) {
                System.out.println("Gracias por jugar.");
                return;
            } else {
                System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    
    
}

}
