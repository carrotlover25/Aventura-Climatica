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
import java.util.Scanner;

/**
 *
 * @author mfrey
 */
public class Arbol {
    Nodo raiz;

    private Minijuego generarJuegoAleatorio() {
        int r = new Random().nextInt(0,1); // genera entre 0 y 5
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
    
    private Nodo insertarRecursivo(Nodo nodo, int valor, int nivel) {
        if (nivel >= 6) return nodo;

        if (nodo == null) {
            Minijuego juegoAleatorio = generarJuegoAleatorio();
            return new Nodo(valor, juegoAleatorio);
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
 
    /* public boolean ruta(int elemento, int secreto) {
        Nodo current = raiz;
        System.out.print("Ruta: ");
    
        while (current != null) {
            System.out.print(current.dato + " -> ");
    
            if (elemento == current.dato) {
                System.out.println("\nEsta no es la temperatura correcta. Sigue Intentando");
                return false;
            }
    
            if (elemento < current.dato) {
                current = current.izq;
            } else {
                current = current.der;
            }
        }
    
        System.out.println("\nEl número ingresado no se encuentra en el árbol.");
        return false;
    } */
    
    public void jugar(){
        Nodo current = this.raiz;
        Scanner sc = new Scanner(System.in);
        
        while (current != null){
            System.out.println("juego actual: " + current.minigame_name);
            current.juego.play();
            
            if (current.izq == null || current.der == null){
                System.out.println("LLegaste al Final. Y lo que sea "); // WIP!!!!!!
                return;
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


