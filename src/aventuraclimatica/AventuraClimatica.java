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
        boolean adivinado = false;
        Scanner scanner = new Scanner(System.in);
        int NODO_SOSTENIBILIDAD = 0;
        
        System.out.println("¡Bienvenido a la gran Aventura Climática!");
        System.out.println("Encuentra el Nodo de Sostenibilidad que ayudara a salvar el planeta!");

        
        for (int i = 0; i < 63; i++) {
            int a = random.nextInt(99)+1;
            numeros.add(a);       
        }

        Collections.sort(numeros); // importante que esté ordenada

        Arbol miArbol = new Arbol();
        miArbol.insertarBalanceado(numeros, 0, numeros.size() - 1, 1);
        miArbol.imprimirArbol(miArbol.raiz);

        ArrayList<Integer> ultimos = miArbol.obtenerNodosUltimoNivel();

       if (!ultimos.isEmpty()) {
            Random rand = new Random();
            int aleatorio = ultimos.get(rand.nextInt(ultimos.size()));
            NODO_SOSTENIBILIDAD = aleatorio;
            System.out.println("Nodo aleatorio del último nivel: " + aleatorio);
        } else {
            System.out.println("El árbol está vacío o no tiene nodos en el último nivel.");
        }

        System.out.println(NODO_SOSTENIBILIDAD);

        Nodo current = miArbol.raiz;
        Scanner sc = new Scanner(System.in);
        
        while (current != null){
            System.out.println("juego actual: " + current.minigame_name);
            current.juego.play();
            
            if (current.izq == null || current.der == null){
                System.out.println("LLegaste al Final. Y lo que sea "); // WIP!!!!!!
                return;
            }

            if (current.dato == NODO_SOSTENIBILIDAD){
                System.out.println("¡Felicidades! Has encontrado el Nodo de Sostenibilidad.");
                System.out.println("¡Gracias por ayudar a salvar el planeta!");
                return;
            } else if (current.dato < NODO_SOSTENIBILIDAD){
                System.out.println("El número es menor que el Nodo de Sostenibilidad.");
            } else {
                System.out.println("El número es mayor que el Nodo de Sostenibilidad.");
            }

            System.out.println("Escriba (i) para ir a la izquierda.");
            System.out.println("Escriba (d) para ir a la derecha");
            String op = sc.nextLine().toLowerCase();
            if (op.equals("i")){
                current = current.izq;
            } else if (op.equals("d")){
                current = current.der;
            } else {
                System.out.println("Error de opción ");
                op = sc.nextLine().toLowerCase();
            }
        }
    
    
}

}
