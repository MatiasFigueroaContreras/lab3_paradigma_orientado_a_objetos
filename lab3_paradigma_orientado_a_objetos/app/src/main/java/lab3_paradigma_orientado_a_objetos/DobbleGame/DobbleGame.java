/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

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
    
    public DobbleGame(String gameName, int maxP, Dobble dobbleSet, Mode mode){
        if(maxP <= mode.getMaxPlayers() && maxP >= mode.getMinPlayers()){
            this.gameArea = new GameArea(dobbleSet);
            this.playersGameControl = new PlayersGameControl(maxP + mode.getExtraPlayers());
            this.mode = mode;
            this.name = gameName;
        }
    }
    
    public void start(){
        if(this.status.equals("Esperando inicio del juego") && playersGameControl.getTotalPlayers() >= this.mode.getMinPlayers()){
            this.status = mode.start(this);
        }
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
        playersGameControl.addPlayer(p);
    }
    
    public String whoseTurnIsIt(){
        return playersGameControl.nthPlayer(playersGameControl.playerTurn).getName();
    }
    
    public int getScore(String name){
        return playersGameControl.getPlayer(name).getScore();
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
        
    public String cardsInPlayString(){
        return this.gameArea.cardsInPlayToString();
    }
    
    public String[] getPlaysOptions(){
        return this.mode.playsOptions(this);
    }
    
    public String getWinners(){
        if(this.status == "Juego Terminado"){
            return this.playersGameControl.getWinners().toString();
        }
        return null;
    }
    
    public String getLosers(){
        if(this.status == "Juego Terminado"){
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
