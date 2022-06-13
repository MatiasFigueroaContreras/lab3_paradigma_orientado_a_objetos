/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.UserMenu;

import java.util.ArrayList;
import java.util.Scanner;
import lab3_paradigma_orientado_a_objetos.DobbleGame.Dobble;
import lab3_paradigma_orientado_a_objetos.DobbleGame.DobbleGame;
import lab3_paradigma_orientado_a_objetos.DobbleGame.ElementsSet;
import lab3_paradigma_orientado_a_objetos.DobbleGame.IElementsSet;
import lab3_paradigma_orientado_a_objetos.DobbleGame.Mode;
import lab3_paradigma_orientado_a_objetos.DobbleGame.StackPlayerVsCpuMode;

/**
 *
 * @author emdma
 */
public class UserMenu {
    private ArrayList<DobbleGame> games = new ArrayList<>();
    private boolean salir;
    public void run(){
        IElementsSet es = new ElementsSet();
        Dobble d = new Dobble(es, 3, 7);
        Mode m = new StackPlayerVsCpuMode();
        DobbleGame dGn = new DobbleGame("Juego 1", 1, d, m);
        this.games.add(dGn);
        System.out.println("Juego Dobble Creado:\n" + d.toString());
        this.salir = false;
        while(!salir){
            System.out.println(mainMenuOptions());
            String opt = getOption();
            if(opt.equals("1")){
                
            }
            else if(opt.equals("2")){
                createdGamesMenu();
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
        String dobble = "°° Bienvendio al juego Dobble °°\n";
        String j = formatedJump();
        String option = "\nIngrese una opcion:\n";
        String op1 = "1. Crear Juego\n";
        String op2 = "2. Juegos Creados\n";
        String s = "s. Salir";
        return dobble + j + option + op1 + op2 + s;       
    }
    
    private String getOption(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    private void createGameMenu(){
        
    }
    
    private void createdGamesMenu(){
        boolean volver = false;
        while(!volver){
            System.out.println("\n  Menu de juegos creados");
            System.out.println(formatedJump());
            if(this.games.isEmpty()){
                System.out.println("No hay juegos registrados.\n");
                volver = true;
            }
            else{
                System.out.println("Seleccione un juego:");
                printGames();
                System.out.println("v. Volver");
                System.out.println("s. Salir");
                String opt = getOption();
                if(opt.equals("v")){
                    volver = true;
                }
                else if(opt.equals("s")){
                    volver = true;
                    this.salir = true;
                }
                else{
                    DobbleGame dG = null;
                    try{
                        int nthGame = Integer.parseInt(opt) - 1;
                        dG =  this.games.get(nthGame);
                        
                    }
                    catch(Exception e){
                        System.out.println("Ingrese una opcion valida.");
                    }
                    if(dG != null){
                        volver = initGameMenu(dG);
                    }
                }
            }
        } 
    }
    
    private void printGames(){
        for(int i = 0; i < this.games.size(); i++){
            DobbleGame dG = this.games.get(i);
            System.out.print((i+1) + ". " + dG.getGameName() + ", ");
            printGameMode(dG);
        }
    }
    
    private void printGameMode(DobbleGame dG){
        System.out.println("Modo de juego: " + dG.getNameMode() + ", en su version: " + dG.getVersionMode());
    }
    
    private void printRegisteredPlayers(DobbleGame dG){
        System.out.println(formatedJump());
        System.out.println(dG.registeredPlayers());
        System.out.println(formatedJump());
    }
    
    private void printPlayerScore(DobbleGame dG, String playerName){
        System.out.println(formatedJump());
        System.out.println("El puntaje del jugador " + playerName + " es: " + dG.getScore(playerName));
        System.out.println(formatedJump());
    }
    
    private void printGameInformation(DobbleGame dG){
        System.out.println(formatedJump());
        System.out.println(dG.toString());
        System.out.println(formatedJump());
    }
    
    private void printResults(DobbleGame dG){
        System.out.println(formatedJump());
        System.out.println("Resultados del juego");
        System.out.println("Ganadores:");
        System.out.println(dG.getWinners());
        System.out.println("Perdedores:");
        System.out.println(dG.getLosers());       
        System.out.println(formatedJump());
    }
    
    private boolean initGameMenu(DobbleGame dG){
        if(dG.getStatus().equals("Esperando inicio del juego")){
            return notStartedGameMenu(dG);
        }
        else if(dG.getStatus().equals("Juego Terminado")){
            return finishedGameMenu(dG);
        }
        else{
            return startedGameMenu(dG);
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
    
    private boolean notStartedGameMenu(DobbleGame dG){
        boolean volver = false;
        while(!volver){
            System.out.println("\nMenu de juego no comenzado: " + dG.getGameName());
            System.out.println(formatedJump());
            notStartedGameMenuOptions();
            String opt = getOption();
            switch(opt){
                case "1":{
                    dG.start();
                    playingMenu(dG);
                    return initGameMenu(dG);
                }
                case "2":{
                    System.out.println(formatedJump());
                    printGameMode(dG);
                    System.out.println(formatedJump());
                    break;
                }
                case "3":{
                    printRegisteredPlayers(dG);
                    break;
                }
                case "4":{
                    System.out.println(formatedJump());
                    System.out.println("Ingrese el nombre del jugador a registrar: ");
                    String playerName = getOption();
                    dG.register(playerName);
                    break;
                }
                case "5":{
                    break;
                }
                case "v":{
                    volver = true;
                    break;
                }
                case "s":{
                    volver = true;
                    this.salir = true;
                    return true;
                }
                default:{
                        System.out.println("Ingrese una opcion valida.");
                        break;
                        }
            }
        }
        return false;
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
    
    private boolean startedGameMenu(DobbleGame dG){
        boolean volver = false;
        while(!volver){
            System.out.println("\nMenu de juego comenzado: " + dG.getGameName());
            System.out.println(formatedJump());
            startedGameMenuOptions();
            String opt = getOption();
            switch(opt){
                case "1":{
                    playingMenu(dG);
                    break;
                }
                case "2":{
                    printGameMode(dG);
                    break;
                }
                case "3":{
                    printRegisteredPlayers(dG);
                    break;
                }
                case "4":{
                    System.out.println("Ingrese el nombre del jugador: ");
                    String playerName = getOption();
                    printPlayerScore(dG, playerName);
                    break;
                }
                case "5":{
                    System.out.println(formatedJump());
                    System.out.println("Estado del juego: " + dG.getStatus());
                    System.out.println(formatedJump());
                    break;
                }
                case "6":{
                    printGameInformation(dG);
                    break;
                }
                case "7":{
                    dG.finish();
                    volver = true;
                    System.out.println(formatedJump());
                    System.out.println("Juego Terminado");
                    printResults(dG);
                    break;
                }
                case "v":{
                    volver = true;
                    break;
                }
                case "s":{
                    volver = true;
                    this.salir = true;
                    return true;
                }
                default:{
                        System.out.println("Ingrese una opcion valida.");
                        break;
                        }
            }
        }
        return false;
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
    
    private boolean finishedGameMenu(DobbleGame dG){
        boolean volver = false;
        while(!volver){
            System.out.println("\nMenu de juego terminado: " + dG.getGameName());
            System.out.println(formatedJump());
            finishedGameMenuOptions();
            String opt = getOption();
            switch(opt){
                case "1":{
                    printResults(dG);
                    break;
                }
                case "2":{
                    printGameMode(dG);
                    break;
                }
                case "3":{
                    printRegisteredPlayers(dG);
                    break;
                }
                case "4":{
                    System.out.println("Ingrese el nombre del jugador: ");
                    String playerName = getOption();
                    printPlayerScore(dG, playerName);
                    break;
                }
                case "5":{
                    printGameInformation(dG);
                    break;
                }
                case "v":{
                    volver = true;
                    break;
                }
                case "s":{
                    volver = true;
                    this.salir = true;
                    return true;
                }
                default:{
                        System.out.println("Ingrese una opcion valida.");
                        break;
                        }
            }
        }
        return false;
    }
    
    private void printPlayOptions(DobbleGame dG){
        String[] options = dG.getPlaysOptions();
        for(int i = 0; i < options.length; i++){
            System.out.println((i+1) + ". " + options[i]);
        }
    }
    
    private void playingMenu(DobbleGame dG){
        boolean volver = false;
        while(!volver){
            System.out.print("Nombre de juego: " + dG.getGameName() + ", ");
            printGameMode(dG);
            System.out.println(formatedJump());
            System.out.println("Turno del jugador: " + dG.whoseTurnIsIt());
            System.out.println(dG.getStatus());
            printPlayOptions(dG);
            System.out.println("v. Volver");
            String opt = getOption();
            if(opt.equals("v")){
                volver = true;
            }
            else{
                String playOption = null;
                String extraDataName = null;
                try{
                    int nPlayOption = Integer.parseInt(opt) - 1;
                    playOption = dG.getPlaysOptions()[nPlayOption];
                    extraDataName = dG.getExtraDataNeeded(playOption);
                }
                catch(Exception e){
                    System.out.println("Ingrese una opcion valida.");
                }
                                    
                if(extraDataName != null){
                    String[] extraData = getExtraData(extraDataName, dG.getNumExtraDataNeded());
                    dG.play(playOption, extraData);
                }
                else{
                    dG.play(playOption);
                }
            }
            
        }
    }
    
    private String[] getExtraData(String dataNeeded, int num){
        String[] extraData = new String[num];
        if(dataNeeded.equals("Element")){
            for(int i = 0; i < num; i++){
                System.out.println("Ingrese el elemento: ");
                extraData[i] = getOption();
            }
            
        }
        return extraData;
    }
    
    private String formatedJump(){
        return "--------------------------";
    }
}
