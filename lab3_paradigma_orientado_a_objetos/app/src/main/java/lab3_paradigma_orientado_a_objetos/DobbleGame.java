/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author emdma
 */
public class DobbleGame {
    protected GameArea gameArea;
    protected PlayersGameControl playersGameControl;
    private Mode mode;
    private String status = "Esperando inicio del juego";
    
    public DobbleGame(int maxP, Dobble dobbleSet, Mode mode){
        if(maxP <= mode.getMaxPlayers() && maxP >= mode.getMinPlayers()){
            this.gameArea = new GameArea(dobbleSet);
            this.playersGameControl = new PlayersGameControl(maxP);
            this.mode = mode;
        }
    }
    
    public void start(){
        if(this.status.equals("Esperando inicio del juego") && playersGameControl.getTotalPlayers() >= this.mode.getMinPlayers()){
            this.status = mode.start(this);
        }
    }
    
    public void play(int option){
        if(!this.status.equals("Juego Terminado") && !this.status.equals("Esperando inicio del juego")){
            this.status = mode.playOption(this, option);
        }    
    }
    
    public void play(int option, String element){
        if(!this.status.equals("Juego Terminado") && !this.status.equals("Esperando inicio del juego")){
            Element e = new Element(element);
            this.status = mode.playOption(this, option, e);
        }
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
    
    public String getStatus(){
        return this.status;
    }
        
    public String cardsInPlayString(){
        return this.gameArea.getCardsInPlay().toString();
    }
    
    public String getPlaysOptions(){
        return this.mode.playsOptionMenu();
    }
    
    public String toString(){
        String modeName = "Modo de juego: " + getNameMode() + ", en su version: " + getVersionMode();
        String st = "Estado del Juego: " + getStatus();
        String cards = "Cartas en juego:\n" + cardsInPlayString();
        String players = "Jugadores registrados:\n" + this.playersGameControl.toString();
        String jump = "\n--------------\n";
        String strFinal = modeName + jump + st + jump + cards + jump + players;
        if(this.status == "Juego Terminado"){
            String winners = "Ganadores:\n" + this.playersGameControl.getWinners();
            String losers = "Perdedores:\n" + this.playersGameControl.getLosers();
            String results = "Resultados Finales:\n" + winners + "\n" + losers;
            strFinal += jump + results;
        }
        return strFinal;
    }
}
