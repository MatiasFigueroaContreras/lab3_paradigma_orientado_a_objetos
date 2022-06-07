/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author emdma
 */
public class StackPlayerVsCpuMode extends Stack{
    public String playsOptionMenu(DobbleGame dGame){
        String status = dGame.getStatus();
        String str;
        
        if(status.equals("Esperando cartas en mesa")){
            str = "1. Voltear Cartas";
        }
        else if(status.equals("Cartas volteadas")){
            String cards = dGame.cardsInPlayString();
            str = "Cartas Volteadas:\n" + cards + "\n------------\n" + "1. Elegir elemento en comun\n2. Pasar";
        }
        else if(status.equals("SpotIt") || status.equals("NotSpotIt")){
            str = "Resultado Jugada: " + status + "\n1. Siguiente jugada";
        }
        else{
            str = "No hay opciones de juego";
        }
        
        return str;
    }
    
    public String playOption(DobbleGame dGame, int option){
        String status = dGame.getStatus();  
        if(status.equals("Esperando cartas en mesa")){
            if(option == 1){
                setCardsToPlay(dGame);
                return "Cartas volteadas";
            }
            else{
                return null;
            }
        }
        else if(status.equals("Cartas volteadas")){
            if(option == 2){
                    backCardsInPlay(dGame);
                    return "Esperando cartas en mesa";
            }
            else{
                return null;
            }
        }
        else if(status.equals("SpotIt") || status.equals("NotSpotIt")){
            if(option == 1){
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
    
    public String playOption(DobbleGame dGame, int option, String[] data){
        if(dGame.getStatus().equals("Cartas volteadas")){
            if(option == 1){
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
    
    
    public String extraDataNeeded(String status, int option){
        if(status.equals("Cartas volteadas") && option == 1){
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
