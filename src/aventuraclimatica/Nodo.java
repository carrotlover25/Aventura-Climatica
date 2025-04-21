/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aventuraclimatica;

/**
 *
 * @author mfrey
 */
public class Nodo {
    
    String minigame_name;
    Minijuego juego;
    int dato;  // esta es la identificación del nodo, para que a la hora de insertarlo sea más fácil balancear el arbol. Asumamos que el id es el que yo quiera. 
    Nodo izq;
    Nodo der;
    int altura;

    public Nodo(int dato, Minijuego juego) {
        this.minigame_name = "Juego :D";
        this.dato = dato;
        this.juego = juego;
        this.izq = null;
        this.der = null;
        this.altura = 1;
    }
    
    
    
}
