/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.UserMenu;

import static com.google.common.math.IntMath.isPrime;
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
                createGameMenu();
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
    
    private int getIntOption(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    private void createGameMenu(){
        System.out.println(formatedJump());
        System.out.println("Datos para crear el mazo de cartas Dobble");
        System.out.println(formatedJump());
        int numE = getNumElements();
        int maxC = getMaxC();
        ArrayList<String> elements = getElements(numE);
            
        System.out.println(formatedJump());
        System.out.println("Datos para crear el juego Dobble");
        System.out.println(formatedJump());
        String name = getGameName();
        String mode = getGameMode();
        int numP = getNumPlayers();
        
        DobbleGame newDG = new DobbleGame(name, numP, mode, elements, numE, maxC);
        this.games.add(newDG);
        System.out.println("Juego creado con exito!!.");
    }
    
    private int getNumElements(){
        boolean check = false;
        int numE = -1;
        while(!check){
            System.out.println("Ingrese el numero de elementos por carta (procure que el numero menos 1 sea primo): ");
            try{
                numE = getIntOption();
                if(isPrime(numE - 1)){
                    check = true;
                }
                else{
                    System.out.println("Debe ingresar un numero, tal que restandole 1 sea primo.");
                }
            }
            catch(Exception e){
                System.out.println("Debe ingresar un numero.");
            }
        }
        System.out.println("Numero ingresado con exito!!.");
        return numE;
    }
    
    private int getMaxC(){
        boolean check = false;
        int maxC = -1;
        while(!check){
            System.out.println("Ingrese el numero de cartas del mazo (Si desea el maximo posible ingrese un numero menor o igual a 0): ");
            try{
                maxC = getIntOption();
                check = true;
            }
            catch(Exception e){
                System.out.println("Debe ingresar un numero.");
            }
        }
        System.out.println("Numero ingresado con exito!!.");
        return maxC;
    }
    
    private ArrayList<String> getElements(int numE){
        ArrayList<String> elements = new ArrayList<>();
        int numCards = DobbleGame.totalCardsNumElements(numE);
        System.out.println("Ingrese los elementos que contendran las cartas:");
        System.out.println("Maximo a ingresar " + numCards);
        for(int i = 1; i <= numCards; i++){
            System.out.println("Escriba STOP si desea autorellenar los elementos.");
            String e = getOption();
            if(e.equals("STOP")){
                return elements;
            }
            else if(!elements.contains(e)){
                elements.add(e);
                System.out.println("Elemento ingresado correctamente, Restantes " + (numCards - i) + ".");
            }
            else{
                System.out.println("El elemento ya ha sido ingresado, porfavor ingrese otro.");
                i--;
            }
        }
        return elements;
    }
    
    private String getGameName(){
        while(true){
            System.out.println("Ingrese el nombre del juego a registrar: ");
            String name = getOption();
            if(nameExist(name)){
                System.out.println("El nombre ingresado ya existe, porfavor ingrese otro nombre.");
            }
            else if(name.replace(" ", "").length() == 0){
                System.out.println("Ingrese un nombre no vacio.");
            }
            else{
                return name;
            }
        }
    }
    
    private boolean nameExist(String name){
        for(DobbleGame game: this.games){
            if(game.getGameName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    private int getNumPlayers(){
        boolean check = false;
        int numE = 1;
        while(!check){
            System.out.println("Ingrese el numero maximo de jugadores a registrar (Se acoplara al modo de juego): ");
            try{
                numE = getIntOption();
                check = true;
            }
            catch(Exception e){
                System.out.println("Debe ingresar un numero.");
            }
        }
        System.out.println("Numero ingresado con exito!!.");
        return numE;
    }
    
    private String getGameMode(){
        while(true){
            printGameModes();
            String opt = getOption();
            if(opt.equals("1")){
                while(true){
                    printGameModeVersions("Stack");
                    String vOpt = getOption();
                    if(vOpt.equals("1")){
                        return "Stack Player vs CPU";
                    }
                    else{
                        System.out.println("Ingrese una opcion valida.");
                    }
                }
            }
            else{
                System.out.println("Ingrese una opcion valida.");
            }
        }
    }
    
    private void printGameModes(){
        System.out.println("Ingrese una opcion de modo de juego: ");
        System.out.println("1. Stack");
    }
    
    private void printGameModeVersions(String mode){
        System.out.println("Ingrese una version del modo de juego " + mode + ": ");
        if(mode == "Stack"){
            System.out.println("1. Player vs CPU");
        }
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
                    if(dG.start()){
                        playingMenu(dG);
                        return initGameMenu(dG);
                    }
                    else{
                        System.out.println("Debe registrar jugadores.");
                    }
                    break;
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
                    System.out.println("   Juego Terminado!!.");
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
            if(!dG.isFinished()){
                System.out.print("Nombre de juego: " + dG.getGameName() + ", ");
                printGameMode(dG);
                System.out.println(formatedJump());
                System.out.println("Turno del jugador: " + dG.whoseTurnIsIt());
                System.out.println(dG.getStatus());
                System.out.println(dG.cardsInPlayString());
                printPlayOptions(dG);
                System.out.println("v. Volver");
                String opt = getOption();
                if(opt.equals("v")){
                    volver = true;
                }
                else{
                    try{
                        int nPlayOption = Integer.parseInt(opt) - 1;
                        String playOption = dG.getPlaysOptions()[nPlayOption];
                        String extraDataName = dG.getExtraDataNeeded(playOption);
                        if(extraDataName != null){
                            String[] extraData = getExtraData(extraDataName, dG.getNumExtraDataNeded());
                            dG.play(playOption, extraData);
                        }
                        else{
                            dG.play(playOption);
                        }
                    }
                    catch(Exception e){
                        System.out.println("Ingrese una opcion valida.");
                    }
                }
            }
            else{
                System.out.println(formatedJump());
                System.out.println("  Juego Terminado!!");
                System.out.println(formatedJump());
                printResults(dG);
                volver = true;
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
