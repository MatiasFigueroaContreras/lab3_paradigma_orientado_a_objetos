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
    
    public DobbleGame(int maxP, Dobble dobbleSet, Mode mode){
        this.gameArea = new GameArea(dobbleSet);
        this.playersGameControl = new PlayersGameControl(maxP);
        this.mode = mode;
    }
}
