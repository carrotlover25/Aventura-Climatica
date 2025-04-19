/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aventuraclimatica;

/**
 *
 * @author mfrey
 */
public class Arbol {
    Nodo raiz;
    
public void insertarNodo(int valor, String minigame_name, Minijuego juego) {
    Nodo nuevoNodo = new Nodo(valor, minigame_name, juego);
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
    
    public Nodo rotDerecha(Nodo y){
        Nodo x = y.izq;
        Nodo temp = x.der;
        
        x.der = y;
        y.izq = temp;
        
        y.altura = Math.max(altura(y.izq), altura(x.der))+ 1;
        x.altura = Math.max(altura(x.izq), altura(y.der)) +1;
        
        return x;
    }
    
    public Nodo rotIzquierda(Nodo nodo){
        Nodo y = nodo.der;
        Nodo x = y.izq;
        
        y.izq = nodo;
        nodo.der = x;
        
        y.altura = Math.max(altura(y.izq), altura(x.der))+ 1;
        x.altura = Math.max(altura(x.izq), altura(y.der)) +1;
        
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
            return nodo; // Valor duplicado, no se inserta
        }

        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));
        int fe = factorEquilibrio(nodo);

        if ( fe > 1 && nuevo.dato < nodo.izq.dato){
            return rotDerecha(nodo);
        }
        
        if (fe < -1 && nuevo.dato > nodo.der.dato){
            return rotIzquierda(nodo);
        }
        
        if (fe > 1 && nuevo.dato > nodo.izq.dato){
            return rotDerecha(nodo);
        }
        
        if (fe < -1 && nuevo.dato < nodo.der.dato){
            return rotIzquierda(nodo);
        } return nodo;
    }
 
    }


