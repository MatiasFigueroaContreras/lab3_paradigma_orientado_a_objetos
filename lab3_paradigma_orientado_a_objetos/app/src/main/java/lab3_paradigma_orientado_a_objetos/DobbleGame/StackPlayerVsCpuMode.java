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
    /**
    * <p> Otorga una lista con las opciones de juego segun el estado en el
    *       que este se encuentra.
    * </p>
    * @param dGame juego Dobble, para obtener el estado de este.
    * @return lista con las opciones de juego.
    */
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
    
    /**
    * <p> Permite realizar una jugada, segun el estado del juego y la opcion
    *       ingresada
    * </p>
    * @param dGame juego Dobble para la gestion y control de la jugada.
    * @param option opcion para realizar la jugada.
    * @return estado luego de la jugada realizada.
    */
    public String play(DobbleGame dGame, String option){
        String status = dGame.getStatus();
        if(dGame.numDobbleCards() < 2){
            dGame.finish();
            return null;
        }
        if(status.equals("Esperando cartas en mesa")){
            if(option.equals("Voltear Cartas")){
                dGame.addDobbleCardsInPlay(1, 2);
                return "Cartas volteadas";
            }
        }
        else if(status.equals("Cartas volteadas")){
            if(option.equals("Pasar")){
                dGame.backCardsInPlay();
                return "Esperando cartas en mesa";
            }
        }
        else if(option.equals("Siguiente jugada")){
            return "Esperando cartas en mesa";
        }
        return null;
    }
    

    private String cpuPlay(DobbleGame dGame, String playerStatus){
        Random rand = new Random();
        int randNumber = rand.nextInt(dGame.numElements()) + 1;
        String element = dGame.nthElement(randNumber);
        String cpuStatus = spotIt(element, dGame);
        if(cpuStatus.equals("SpotIt")){
            dGame.addScorePlayer(dGame.numCardsInPlay(), "CPU");
            if(playerStatus.equals("NotSpotIt")){
                dGame.addCardsInPlayPlayer("CPU");
            }
        }
        return cpuStatus;
    }
    
    /**
    * <p> Permite realizar una jugada, verificando el estado del juego y 
    *       la opcion ingresada sean acordes con la jugada, y para esto
    *       utiliza la informacion extra otorgada.
    * </p>
    * @param dGame juego Dobble para la gestion y control de la jugada.
    * @param option opcion para realizar la jugada.
    * @param data informacion extra con el elemento que es necesario 
    *               para realizar la jugada.
    * @return estado luego de la jugada realizada.
    */
    public String play(DobbleGame dGame, String option, String[] data){
        if(dGame.getStatus().equals("Cartas volteadas")){
            if(option.equals("Elegir elemento en comun")){
                String element = data[0];
                String playerStatus = spotIt(element, dGame);
                String cpuStatus = cpuPlay(dGame, playerStatus);
                dGame.setStatus(playerStatus);
                String status = dGame.whoseTurnIsIt() + ": " + playerStatus + ", CPU: " + cpuStatus;
                pass(dGame);
                dGame.nextTurn();
                return status;
            }
        }
        return null;
    }
   
    /**
    * <p> Inicializa el juego, agregando a la CPU como jugador.
    * </p>
    * @param dGame juego Dobble para agregar a la CPU como jugador.
    * @return estado luego de iniciar el juego.
    */
    public String start(DobbleGame dG){
        dG.registerExtra("CPU");
        return "Esperando cartas en mesa";
    }
    
    /**
    * <p> Consulta si el modo de juego segun una jugada y el estado del juego
    *       necesita informacion extra, para poder ser realizada.
    * </p>
    * @param status estado del juego.
    * @param option opcion de juego.
    * @return Element si es necesario que se ingrese este, o null si no se 
    *           necesita informacion extra.
    */
    public String extraDataNeeded(String status, String option){
        if(status.equals("Cartas volteadas") && option.equals("Elegir elemento en comun")){
            return "Element";
        }
        else{
            return null;
        }
    }
    
    /**
    * <p> Getter.
    * </p>
    * @return Version del modo de juego "Player vs CPU".
    */
    public String getVersionModeName(){
        return "Player vs CPU";
    }
    
    /**
    * <p> Getter.
    * </p>
    * @return 1, ya que el modo de juegor establece que es jugador contra CPU.
    */
    public int getMaxPlayers(){
        return 1;
    }
    
    /**
    * <p> Getter.
    * </p>
    * @return 1, ya que se necesita al jugador que jugara contra la CPU.
    */
    public int getMinPlayers(){
        return 1;
    }
    
    /**
    * <p> Getter.
    * </p>
    * @return 1 ya que se necesita a la CPU como jugador.
    */
    public int getExtraPlayers(){
        return 1;
    }
    
    /**
    * <p> Compara this con otro Objeto, consultando que sean de la misma clase.
    * </p>
    * @param object objeto a comparar con this.
    * @return true si son iguales, false si no son iguales.
    */
    @Override
    public boolean equals(Object o){
        return o.getClass() == getClass();
    }
}
