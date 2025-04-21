/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.minijuegos;

import aventuraclimatica.Minijuego;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mfrey
 */
public class Trivia implements Minijuego {
    Scanner sc = new Scanner(System.in);
    @Override
    public void play(){
        System.out.println("Bienvenid@ a Trivia");
        Random random = new Random();
        int aleatorio = random.nextInt(2);
        
        switch (aleatorio){
            case 0:
                pregunta1();
                break;
            case 1:
                pregunta2();
                break;
            case 2:
                pregunta3();
                break;  
            default:
                System.out.println("Error del juego.");
        }
    }
    
    
    public void pregunta1(){
        System.out.println("Pregunta:");
        System.out.println("¿Cuál de las siguientes acciones ayuda más a combatir el cambio climático?");
        System.out.println("a) Usar bolsas de plástico una sola vez");
        System.out.println("b) Plantar árboles");
        System.out.println("c) Dejar las luces encendidas");
        System.out.println("d) Comprar más ropa nueva");
        System.out.println("Escribe tu respuesta:" );
        String ans;
        ans = sc.nextLine().toLowerCase();
        
        if (ans.equals("b")){
            System.out.println("Correcto! Plantar árboles ayuda a absorber dióxido de carbono.\n");
        } else {
            System.out.println("Incorrecto. La respuesta es la b \n");
        }
    }
    
    public void pregunta2(){
        System.out.println("Pregunta");
        System.out.println("¿Cuál es una de las principales causas de la contaminación de los océanos?");
        System.out.println("a) El canto de las ballenas");
        System.out.println("b) El turismo controlado");
        System.out.println("c) El plástico de un solo uso");
        System.out.println("d) Las lluvias");
        String ans;
        ans = sc.nextLine().toLowerCase();
        if (ans.equals("c")){
            System.out.println("Correcto! El plástico de un solo uso se convierte en microplásticos, contaminando los océanos.\n");
        } else {
            System.out.println("Incorrecto. La respuesta es la c \n");
        }
    }
    
    public void pregunta3(){
        System.out.println("Pregunta:");
        System.out.println("¿Qué gas es el principal responsable del efecto invernadero?");
        System.out.println("a) Oxígeno");
        System.out.println("b) Nitrógeno");
        System.out.println("c) Dióxido de carbono (CO₂)");
        System.out.println("d) Helio");
        String ans;
        ans = sc.nextLine().toLowerCase();
        if (ans.equals("c")){
            System.out.println("Correcto! El dioxido de carbono atrapa el calor en la atmósfera \n");
        } else {
            System.out.println("Incorrecto. La respuesta es la c \n");
        }
    }
}
