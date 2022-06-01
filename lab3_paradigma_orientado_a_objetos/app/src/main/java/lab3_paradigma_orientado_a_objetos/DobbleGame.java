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
    GameArea gameArea;
    PlayersGameControl playersGameControl;
    Mode mode;
    String status = "Esperando inicio del juego";
    
    public DobbleGame(int maxP, Dobble dobbleSet, Mode mode){
        this.gameArea = new GameArea(dobbleSet);
        this.playersGameControl = new PlayersGameControl(maxP);
        this.mode = mode;
    }
    
    public void start(){
        if(this.status.equals("Esperando inicio del juego") && playersGameControl.getTotalPlayers() > 0){
            this.status = "Esperando cartas en mesa";
            mode.start(this);
        }
    }
    
    public void play(String p){
        switch(p){
            case "flip":
                if(this.status.equals("Esperando cartas en mesa")){
                    mode.setCardsInPlay(this);
                }
            case "finish":
                finish();
        }
    }
    
    public void play(String p, Element e){
        if(p.equals("spotIt") && this.status.equals("cartas en mesa")){
            spotIt(e);
            mode.pass(this);
            this.status = "Esperando cartas en mesa";
        }
    }
    
    public void finish(){
        this.status = "Juego Terminado";
    }
    
    private void spotIt(Element e){
        if(this.gameArea.getCardsInPlay().elementOccurrences(e) >= 2){
            this.status = "spotIt";
        }
        else{
            this.status = "notSpotIt";
        }
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
}
