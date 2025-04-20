/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aventuraclimatica;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author mfrey
 */
public class Arbol {
    Nodo raiz;
    
public void insertarNodo(int dato, String minigame_name, Minijuego juego) {
    Nodo nuevoNodo = new Nodo(dato, minigame_name, juego);
    if (this.raiz == null) {
        this.raiz = nuevoNodo;
    } else {
        insertarRecursivo(this.raiz, nuevoNodo);
    }
}
   
     public int altura(Nodo nodo){
        if ( nodo == null ){
            return 0;
        } return nodo.altura;
    } 
    
    public Nodo rotDerecha(Nodo y) {
        if (y == null || y.izq == null) return y; // validación

        Nodo x = y.izq;
        Nodo temp = x.der;

        // Realizar rotación
        x.der = y;
        y.izq = temp;

        // Actualizar alturas
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;

        return x;
    }

    public Nodo rotIzquierda(Nodo x) {
        if (x == null || x.der == null) return x; // validación

        Nodo y = x.der;
        Nodo temp = y.izq;

        // Realizar rotación
        y.izq = x;
        x.der = temp;

        // Actualizar alturas
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;

        return y;
    }

    public int factorEquilibrio(Nodo nodo){
        if (nodo == null){
            return 0;
        } return altura(nodo.der) - altura(nodo.izq);
    }
    
    private Nodo insertarRecursivo(Nodo nodo, Nodo nuevo) {
        if (nodo == null) {
            return nuevo;
        }

        if (nuevo.dato < nodo.dato) {
            nodo.izq = insertarRecursivo(nodo.izq, nuevo);
        } else if (nuevo.dato > nodo.dato) {
            nodo.der = insertarRecursivo(nodo.der, nuevo);
        } else {
            return nodo; // Valor duplicado
        }

        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));
        int fe = factorEquilibrio(nodo);

        if (fe > 1 && nodo.izq != null && nuevo.dato < nodo.izq.dato) {
            return rotDerecha(nodo);
        }

        if (fe < -1 && nodo.der != null && nuevo.dato > nodo.der.dato) {
            return rotIzquierda(nodo);
        }

        if (fe > 1 && nodo.izq != null && nuevo.dato > nodo.izq.dato) {
            nodo.izq = rotIzquierda(nodo.izq);
            return rotDerecha(nodo);
        }

        if (fe < -1 && nodo.der != null && nuevo.dato < nodo.der.dato) {
            nodo.der = rotDerecha(nodo.der);
            return rotIzquierda(nodo);
        }

        return nodo;
    }
     
    public void llenarConNumerosRandom() {
        Set<Integer> numerosUsados = new HashSet<>();
        Random random = new Random();

        while (altura(raiz) < 7) {
            int numero = random.nextInt(99) + 1; // Número entre 1 y 99

            if (!numerosUsados.contains(numero)) {
                numerosUsados.add(numero);

                insertarNodo(numero, "Minijuego" + numero, null); 
            }
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
 
}


