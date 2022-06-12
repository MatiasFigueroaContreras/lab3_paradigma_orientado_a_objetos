/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.UserMenu;

import java.util.ArrayList;
import java.util.Scanner;
import lab3_paradigma_orientado_a_objetos.DobbleGame.DobbleGame;

/**
 *
 * @author emdma
 */
public class UserMenu {
    private ArrayList<DobbleGame> games = new ArrayList<>();
    private boolean salir;
    public void run(){
        this.salir = false;
        while(!salir){
            System.out.println(mainMenuOptions());
            String opt = getOption();
            if(opt.equals("1")){
                
            }
            else if(opt.equals("2")){
                
            }
            else if(opt.equals("s")){
                this.salir = true;
            }
            else{
                System.out.println("Ingrese una opcion valida.\n");
            }
              
        }
    }
    
    private String mainMenuOptions(){
        String dobble = "°° Bienvendio al juego Dobble °°";
        String j = formatedJump();
        String option = "Ingrese una opcion:\n";
        String op1 = "1. Crear Juego\n";
        String op2 = "2. Juegos Creados\n";
        String s = "s. Salir";
        return dobble + j + op1 + op2 + s;       
    }
    
    private String getOption(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    private void createdGames(){
        boolean volver = false;
        while(!volver){
            System.out.println("\nMenu de juegos creados" + formatedJump());
            if(this.games.isEmpty()){
                System.out.println("No hay juegos registrados.");
                volver = true;
            }
            else{
                System.out.println("Seleccione un juego:\n");
                //Juegos
                String opt = getOption();
                if(opt.equals("v")){
                    volver = true;
                }
                else if(opt.equals("s")){
                    volver = true;
                    this.salir = true;
                }
                else{
                    try{
                        int nthGame = Integer.parseInt(opt);
                    }
                    catch(Exception e){
                        System.out.println("Ingrese una opcion valida.");
                    }
                    //Nth Juego
                }
            }
        } 
    }
    
    private void initGameMenu(DobbleGame dG){
        if(dG.getStatus().equals("Esperando inicio del juego")){
            notStartedGameMenu(dG);
        }
        else if(dG.getStatus().equals("Juego Terminado")){
            finishedGameMenu(dG);
        }
        else{
            startedGameMenu(dG);
        }
    }
    
    private void notStartedGameMenu(DobbleGame dG){
        boolean volver = false;
        while(!volver){
            System.out.println("\nMenu de juego no comenzado: " + dG.getGameName() + formatedJump());
            notStartedGameMenuOptions();
            String opt = getOption();
            switch(opt){
                case "1":{
                    
                }
                case "2":{
                    
                }
                case "3":{
                    
                }
                case "4":{
                    
                }
                case "5":{
                    
                }
                case "v":{
                    volver = true;
                }
                case "s":{
                    volver = true;
                    this.salir = true;
                }
                default:{
                        System.out.println("Ingrese una opcion valida.");
                        }
            }
        }
    }
    
    private void notStartedGameMenuOptions(){
        System.out.println("1. Iniciar juego");
        System.out.println("2. Modo de juego");
        System.out.println("3. Jugadores registrados");
        System.out.println("4. Registrar jugador");
        System.out.println("5. Eliminar jugador registrado");
        System.out.println("v. Volver");
        System.out.println("s. Salir");
    }
    private void startedGameMenu(DobbleGame dG){
        boolean volver = false;
        while(!volver){
            System.out.println("\nMenu de juego comenzado: " + dG.getGameName() + formatedJump());
            startedGameMenuOptions();
            String opt = getOption();
            switch(opt){
                case "1":{
                    
                }
                case "2":{
                    
                }
                case "3":{
                    
                }
                case "4":{
                    
                }
                case "5":{
                    
                }
                case "6":{
                    
                }
                case "7":{
                    
                }
                case "v":{
                    volver = true;
                }
                case "s":{
                    volver = true;
                    this.salir = true;
                }
                default:{
                        System.out.println("Ingrese una opcion valida.");
                        }
            }
        }
    }
        
    private void startedGameMenuOptions(){
        System.out.println("1. Continuar juego");
        System.out.println("2. Modo de juego");
        System.out.println("3. Jugadores registrados");
        System.out.println("4. Puntaje de jugador");
        System.out.println("5. Estado del juego");
        System.out.println("6. Informacion general");
        System.out.println("7. Finalizar juego");
        System.out.println("v. Volver");
        System.out.println("s. Salir");
    }
    
    private void finishedGameMenu(DobbleGame dG){
        boolean volver = false;
        while(!volver){
            System.out.println("\nMenu de juego terminado: " + dG.getGameName() + formatedJump());
            notStartedGameMenuOptions();
            String opt = getOption();
            switch(opt){
                case "1":{
                    
                }
                case "2":{
                    
                }
                case "3":{
                    
                }
                case "4":{
                    
                }
                case "5":{
                    
                }
                case "v":{
                    volver = true;
                }
                case "s":{
                    volver = true;
                    this.salir = true;
                }
                default:{
                        System.out.println("Ingrese una opcion valida.");
                        }
            }
        }
    }
    
    private void finishedGameMenuOptions(){
        System.out.println("1. Resultados");
        System.out.println("2. Modo de juego");
        System.out.println("3. Jugadores registrados");
        System.out.println("4. Puntaje de jugador");
        System.out.println("5. Informacion general");
        System.out.println("v. Volver");
        System.out.println("s. Salir");
    }
    
    private String formatedJump(){
        return "\n--------------------------\n";
    }
}
