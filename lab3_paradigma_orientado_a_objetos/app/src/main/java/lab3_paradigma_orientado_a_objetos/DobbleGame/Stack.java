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
    
    protected String spotIt(Element e, CardsSet cS){
        if (cS.elementOccurrences(e) >= 2){
            return "SpotIt";
        }
        else{
            return "NotSpotIt";
        }
    }
    
    protected boolean setCardsToPlay(DobbleGame dG){
        CardsSet cards = dG.gameArea.getCardsInPlay();
        Dobble dCards = dG.gameArea.getDobbleSet();
        if(dCards.numCards() >= 2){
            for(int i = 1; i <= 2; i++){
                cards.add(dCards.nthCard(i));
                dCards.removeCard(i);
            }
            return true;
        }
        
        return false;
    }
    
    protected void backCardsInPlay(DobbleGame dG){
        CardsSet cards = dG.gameArea.getCardsInPlay();
        Dobble dCards = dG.gameArea.getDobbleSet();
        for(int i = 1; i <= 2; i++){
            Card nCard = cards.nthCard(i);
            dCards.addCard(nCard);
        }
        cards.clear();
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
