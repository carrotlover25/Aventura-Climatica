/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aventuraclimatica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

        int nodo_diverso = numeros.get(random.nextInt(numeros.size()));

    }
    
}
