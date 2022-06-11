/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

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
        else if(status.equals("SpotIt") || status.equals("NotSpotIt")){
            str = new String[1];
            str[0] = "Siguiente jugada";
        }
        else{
            str = null;
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
            else{
                return null;
            }
        }
        else if(status.equals("Cartas volteadas")){
            if(option.equals("Pasar")){
                    backCardsInPlay(dGame);
                    return "Esperando cartas en mesa";
            }
            else{
                return null;
            }
        }
        else if(status.equals("SpotIt") || status.equals("NotSpotIt")){
            if(option.equals("Siguiente jugada")){
                    pass(dGame);
                    return "Esperando cartas en mesa";
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    
    public String play(DobbleGame dGame, String option, String[] data){
        if(dGame.getStatus().equals("Cartas volteadas")){
            if(option.equals("Elegir elemento en comun")){
                Element e = new Element(data[0]);
                if(spotIt(e, dGame.gameArea.getCardsInPlay())){
                    return "SpotIt";
                }
                else{
                    return "NotSpotIt";
                }
                
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    
    public String start(DobbleGame dG){
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
}
