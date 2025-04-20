/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aventuraclimatica;

import java.util.ArrayList;

/**
 *
 * @author mfrey
 */
public class Arbol {
    Nodo raiz;
    
    private Nodo insertarRecursivo(Nodo nodo, int valor, int nivel) {
        if (nivel >= 6) return nodo;

        if (nodo == null) {
            return new Nodo(valor, "", null);
        }

        if (valor < nodo.dato) {
            nodo.izq = insertarRecursivo(nodo.izq, valor, nivel + 1);
        } else if (valor > nodo.dato) {
            nodo.der = insertarRecursivo(nodo.der, valor, nivel + 1);
        }

        return nodo;
    }

    // Inserta de manera balanceada a partir de una lista ordenada
    public void insertarBalanceado(ArrayList<Integer> lista, int inicio, int fin, int nivel) {
        if (inicio > fin || nivel >= 6) return;

        int medio = (inicio + fin) / 2;
        raiz = insertarRecursivo(raiz, lista.get(medio), 1);

        insertarBalanceado(lista, inicio, medio - 1, nivel + 1);
        insertarBalanceado(lista, medio + 1, fin, nivel + 1);
    }
 

       private void imprimirArbol(Nodo raiz, String estructuraDibujar, boolean esIzquierdo) {
        if (raiz == null) {
            return;
        }

        String nuevaEstructura = estructuraDibujar;
        String simbolo;

        if (esIzquierdo) {
            simbolo = "├── ";
            nuevaEstructura += "│   ";
        } else {
            simbolo = "└── ";
            nuevaEstructura += "    ";
        }

        System.out.println(estructuraDibujar + simbolo + raiz.dato);

        imprimirArbol(raiz.izq, nuevaEstructura, true);
        imprimirArbol(raiz.der, nuevaEstructura, false);
    }
    
    public void imprimirArbol(Nodo raiz) {
        imprimirArbol(raiz, "", false);
    }
 
}


