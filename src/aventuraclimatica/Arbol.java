/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aventuraclimatica;

import core.minijuegos.Completar;
import core.minijuegos.Crucigrama;
import core.minijuegos.RockPaperScissor;
import core.minijuegos.TempSecreta;
import core.minijuegos.Triqui;
import core.minijuegos.Trivia;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mfrey
 */
public class Arbol {
    Nodo raiz;

    private Minijuego generarJuegoAleatorio() {
        int r = new Random().nextInt(0,6); // genera entre 0 y 5
        switch (r) {
            case 0: return new Trivia();
            case 1: return new TempSecreta(); //Adivinar num
            case 2: return new Crucigrama();
            case 3: return new Triqui();
            case 4: return new RockPaperScissor();
            case 5: return new Completar(); 
            default: return new Trivia(); 
        }
    }
    
    private Nodo insertarRecursivo(Nodo nodo, int valor, int nivel, Nodo padre) {
        if (nivel >= 6) return nodo;

        if (nodo == null) {
            Minijuego juegoAleatorio = generarJuegoAleatorio();
            Nodo nuevoNodo = new Nodo(valor, juegoAleatorio);
            nuevoNodo.padre = padre;
            return nuevoNodo;
        }

        if (valor < nodo.dato) {
            nodo.izq = insertarRecursivo(nodo.izq, valor, nivel + 1, nodo);
        } else if (valor > nodo.dato) {
            nodo.der = insertarRecursivo(nodo.der, valor, nivel + 1, nodo);
        }

        return nodo;
    }

    public void insertarBalanceado(ArrayList<Integer> lista, int inicio, int fin, int nivel) {
        if (inicio > fin || nivel >= 6) return;
        int medio = (inicio + fin) / 2;
        raiz = insertarRecursivo(raiz, lista.get(medio), 1, null); // raíz no tiene padre
        insertarBalanceado(lista, inicio, medio - 1, nivel + 1);
        insertarBalanceado(lista, medio + 1, fin, nivel + 1);
    }

    public ArrayList<Integer> obtenerNodosUltimoNivel() {
        ArrayList<Integer> resultado = new ArrayList<>();
        int altura = altura(raiz);
        recolectarNodosEnNivel(raiz, 1, altura, resultado);
        return resultado;
    }

    private int altura(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(altura(nodo.izq), altura(nodo.der));
    }

    private void recolectarNodosEnNivel(Nodo nodo, int nivelActual, int nivelObjetivo, ArrayList<Integer> resultado) {
        if (nodo == null) return;

        if (nivelActual == nivelObjetivo) {
            resultado.add(nodo.dato);
        } else {
            recolectarNodosEnNivel(nodo.izq, nivelActual + 1, nivelObjetivo, resultado);
            recolectarNodosEnNivel(nodo.der, nivelActual + 1, nivelObjetivo, resultado);
        }
    }
 

       private void imprimirArbol(Nodo raiz, String estructuraDibujar, boolean esIzquierdo, Nodo actual, ArrayList<Nodo> visitados) {
        if (raiz == null) return;

        String nuevaEstructura = estructuraDibujar;
        String simbolo = esIzquierdo ? "├── " : "└── ";
        nuevaEstructura += esIzquierdo ? "│   " : "    ";

        // Determinar el marcador del nodo
        String marcador = "";
        if (raiz == actual) {
            marcador = " ⭐ (Actual)";
        } else if (visitados.contains(raiz)) {
            marcador = " ✅ (Visitado)";
        }

        System.out.println(estructuraDibujar + simbolo + raiz.dato + marcador);

        imprimirArbol(raiz.izq, nuevaEstructura, true, actual, visitados);
        imprimirArbol(raiz.der, nuevaEstructura, false, actual, visitados);
    }
    
    public void imprimirArbol(Nodo raiz, Nodo actual, ArrayList<Nodo> visitados) {
        imprimirArbol(raiz, "", false, actual, visitados);
    }
    
}


