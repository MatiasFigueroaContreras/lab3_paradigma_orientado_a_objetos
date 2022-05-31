/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author emdma
 */
public class GameArea {
    Dobble dobbleSet;
    CardsSet cardsInPlay = new CardsSet();
    
    public GameArea(Dobble dS){
        this.dobbleSet = dS;
    }
    
    public Dobble getDobbleSet(){
        return this.dobbleSet;
    }
    
    public CardsSet getCardsInPlay(){
        return this.cardsInPlay;
    }
    
    public void setDobble(Dobble dS){
        this.dobbleSet = dS;
    }
    
    public void setCardsInPlay(CardsSet cS){
        this.cardsInPlay = cS;
    }
}
