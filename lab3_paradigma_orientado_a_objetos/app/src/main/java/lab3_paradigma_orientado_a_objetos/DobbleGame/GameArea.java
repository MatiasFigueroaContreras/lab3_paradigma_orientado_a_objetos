/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

/**
 *
 * @author emdma
 */
public class GameArea {
    private Dobble dobbleSet;
    private CardsSet cardsInPlay = new CardsSet();
    
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
    
    public String cardsInPlayToString(){
        return this.cardsInPlay.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == getClass()){
            GameArea gA = (GameArea)o;
            return this.cardsInPlay.equals(gA.cardsInPlay) && this.dobbleSet.equals(gA.cardsInPlay);
        }
        return false;
    }
}
