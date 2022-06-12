/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

import java.util.Random;

/**
 *
 * @author emdma
 */
public class StackPlayerVsCpuMode extends Stack{
    public String[] playsOptions(DobbleGame dGame){
        String status = dGame.getStatus();
        String[] str;
        
        if(status.equals("Esperando cartas en mesa")){
            str = new String[1];
            str[0] = "Voltear Cartas";
        }
        else if(status.equals("Cartas volteadas")){
            str = new String[2];
            str[0] = "Elegir elemento en comun";
            str[1] = "Pasar";
        }
        else{
            str = new String[1];
            str[0] = "Siguiente jugada";
        }
        
        return str;
    }
    
    public String play(DobbleGame dGame, String option){
        String status = dGame.getStatus();  
        if(status.equals("Esperando cartas en mesa")){
            if(option.equals("Voltear Cartas")){
                setCardsToPlay(dGame);
                return "Cartas volteadas";
            }
        }
        else if(status.equals("Cartas volteadas")){
            if(option.equals("Pasar")){
                    backCardsInPlay(dGame);
                    return "Esperando cartas en mesa";
            }
        }
        else if(option.equals("Siguiente jugada")){
            return "Esperando cartas en mesa";
        }
        return null;
    }
    
    private String cpuPlay(DobbleGame dGame){
        Random rand = new Random();
        int randNumber = rand.nextInt(dGame.gameArea.getDobbleSet().numElements()) + 1;
        Element e = dGame.gameArea.getDobbleSet().nthElement(randNumber);
        String cpuStatus = spotIt(e, dGame.gameArea.getCardsInPlay());
        return cpuStatus;
    }
    
    public String play(DobbleGame dGame, String option, String[] data){
        if(dGame.getStatus().equals("Cartas volteadas")){
            if(option.equals("Elegir elemento en comun")){
                Element e = new Element(data[0]);
                String playerStatus = spotIt(e, dGame.gameArea.getCardsInPlay());
                String status = dGame.whoseTurnIsIt() + ": " + playerStatus;
                dGame.setStatus(playerStatus);
                pass(dGame);
                String cpuStatus = cpuPlay(dGame);
                status += ", " + dGame.whoseTurnIsIt() + ": " + cpuStatus;
                dGame.setStatus(cpuStatus);
                pass(dGame);
                return status;
            }
        }
        return null;
    }
    
    public String start(DobbleGame dG){
        dG.register("CPU");
        return "Esperando cartas en mesa";
    }
    
    
    public String extraDataNeeded(String status, String option){
        if(status.equals("Cartas volteadas") && option.equals("Elegir elemento en comun")){
            return "Element";
        }
        else{
            return null;
        }
    }
    
    public String getVersionModeName(){
        return "Player vs Cpu";
    }
    
    public int getMaxPlayers(){
        return 1;
    }
    
    public int getMinPlayers(){
        return 1;
    }
    
    public int getExtraPlayers(){
        return 1;
    }
    
    @Override
    public boolean equals(Object o){
        return o.getClass() == getClass();
    }
}
