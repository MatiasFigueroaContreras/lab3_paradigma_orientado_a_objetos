/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

/**
 *
 * @author emdma
 */
public abstract class Stack implements Mode{
    
    public String getModeName(){
        return "Stack";
    }
    
    public int numExtraDataNeeded(DobbleGame dGame){
        return 1;
    }
    
    protected String spotIt(String element, DobbleGame dG){
        if (dG.gameArea.elementOccurrencesCardsInPlay(element) >= 2){
            return "SpotIt";
        }
        else{
            return "NotSpotIt";
        }
    }
    
    protected boolean setCardsToPlay(DobbleGame dG){
        dG.gameArea.setDobbleCardsInPlay(1, 2);
        return true; //Agregar control
    }
    
    protected void backCardsInPlay(DobbleGame dG){
        dG.gameArea.backCardsInPlay();
    }
    
    
    
    protected void pass(DobbleGame dG){
        if(dG.getStatus().equals("SpotIt")){
            CardsSet cardsInPlay = dG.gameArea.getCardsInPlay();
            dG.playersGameControl.addScoreCurrentPlayerTurn(cardsInPlay.numCards());
            dG.playersGameControl.addCardsCurrentPlayerTurn(cardsInPlay);
            cardsInPlay.clear();
        }
        else if(dG.getStatus().equals("NotSpotIt")){
            backCardsInPlay(dG);
        }
        dG.playersGameControl.nextTurn();
    }
}
