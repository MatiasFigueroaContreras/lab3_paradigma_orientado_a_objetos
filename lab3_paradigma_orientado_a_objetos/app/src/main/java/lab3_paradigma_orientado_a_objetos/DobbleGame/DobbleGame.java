/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

import java.util.ArrayList;

/**
 *
 * @author emdma
 */
public class DobbleGame implements IDobbleGame{
    private String name;
    protected GameArea gameArea;
    protected PlayersGameControl playersGameControl;
    private Mode mode;
    private String status = "Esperando inicio del juego";
    
    public DobbleGame(String gameName, int maxP, String mode, ArrayList<String> elements, int numE, int maxC){
        Mode m = stringToMode(mode);
        if(m == null){
            return;
        }
        if(maxP <= m.getMaxPlayers() && maxP >= m.getMinPlayers()){
            this.playersGameControl = new PlayersGameControl(maxP + m.getExtraPlayers());
        }
        else{
            this.playersGameControl = new PlayersGameControl(m.getMaxPlayers() + m.getExtraPlayers());
        }
        this.name = gameName;
        this.gameArea = new GameArea(elements, numE, maxC);
        this.mode = m;
    }
    
    private Mode stringToMode(String mode){
        switch(mode){
            case "Stack Player vs CPU":{
                return new StackPlayerVsCpuMode();
            }
            default:{
                    return null;
                    }
        }
    }
    
    public static int totalCardsNumElements(int numE){
        return GameArea.totalCardsNumElements(numE);
    }
    
    public boolean start(){
        if(this.status.equals("Esperando inicio del juego") && playersGameControl.getTotalPlayers() >= this.mode.getMinPlayers()){
            this.status = mode.start(this);
            return true;
        }
        return false;
    }
    
    public boolean play(String option){
        if(!this.status.equals("Juego Terminado") && !this.status.equals("Esperando inicio del juego")){
            String newStatus = mode.play(this, option);
            if(newStatus == null){
                return false;
            }
            else{
                this.status = newStatus;
                return true;
            }
        }
        return false;
    }
    
    public boolean play(String option, String[] data){
        if(!this.status.equals("Juego Terminado") && !this.status.equals("Esperando inicio del juego")){
            String newStatus = mode.play(this, option, data);
            if(newStatus == null){
                return false;
            }
            else{
                this.status = newStatus;
                return true;
            }
        }
        return false;
    }

    public void finish(){
        this.status = "Juego Terminado";
    }
    
    public void register(String name){
        Player p = new Player(name);
        playersGameControl.addPlayer(p, this.mode.getExtraPlayers());
    }
    
    protected void registerExtra(String name){
        Player p = new Player(name);
        playersGameControl.addPlayer(p);
    }
    
    public String whoseTurnIsIt(){
        return playersGameControl.getPlayerTurn();
    }
    
    public int getScore(String name){
        return playersGameControl.getPlayerScore(name);
    }
    
    public String getNameMode(){
        return this.mode.getModeName();
    }
    
    public String getVersionMode(){
        return this.mode.getVersionModeName();
    }
    
    public String getExtraDataNeeded(String option){
        return this.mode.extraDataNeeded(this.status, option);
    }
    
    public int getNumExtraDataNeded(){
        return this.mode.numExtraDataNeeded(this);
    }
    
    public String getGameName(){
        String gameNameCopy = new String(this.name);
        return gameNameCopy;
    }
    
    public String getStatus(){
        String statusCopy = new String(this.status);
        return statusCopy;
    }
    
    protected void setStatus(String newStatus){
        this.status = new String(newStatus);
    }
    
    public boolean isFinished(){
        return this.status.equals("Juego Terminado");
    }
        
    public String cardsInPlayString(){
        return this.gameArea.cardsInPlayToString();
    }
    
    public String[] getPlaysOptions(){
        if(!this.status.equals("Juego Terminado")){
            return this.mode.playsOptions(this);
        }
        else{
            return new String[0];
        }
    }
    
    public String getWinners(){
        if(this.status.equals("Juego Terminado")){
            return this.playersGameControl.getWinners().toString();
        }
        return "Prueba";
    }
    
    public String getLosers(){
        if(this.status.equals("Juego Terminado")){
            return this.playersGameControl.getLosers().toString();
        }
        return null;
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == getClass()){
            DobbleGame dG = (DobbleGame)o;
            return this.name.equals(dG.getGameName()) || (this.playersGameControl.equals(dG.playersGameControl) && (this.status == dG.status) && this.mode.equals(dG.mode) && this.gameArea.equals(dG.gameArea)); 
        }
        return false;
    }
    
    public String registeredPlayers(){
        return this.playersGameControl.toString();
    }
    
    @Override
    public String toString(){
        String gameName = "Nombre del juego: " + this.name;
        String modeName = "\nModo de juego: " + getNameMode() + ", en su version: " + getVersionMode();
        String st = "Estado del Juego: " + getStatus();
        String cards = "Cartas en juego:\n" + cardsInPlayString();
        String players = "Jugadores registrados:\n" + registeredPlayers();
        String jump = "\n--------------\n";
        String strFinal = gameName + modeName + jump + st + jump + cards + jump + players;
        if(this.status == "Juego Terminado"){
            String winners = "Ganadores:\n" + this.playersGameControl.getWinners();
            String losers = "Perdedores:\n" + this.playersGameControl.getLosers();
            String results = "Resultados Finales:\n" + winners + "\n" + losers;
            strFinal += jump + results;
        }
        return strFinal;
    }
}
