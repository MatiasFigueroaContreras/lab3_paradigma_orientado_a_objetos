/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author emdma
 */
public abstract class Stack implements Mode{
    
    public String getNameMode(){
        return "Stack";
    }
    
    private boolean spotIt(Element e, CardsSet cS){
        return cS.elementOccurrences(e) >= 2;
    }
    
    private void setCardsToPlay(DobbleGame dG){
        CardsSet cards = dG.gameArea.getCardsInPlay();
        Dobble dCards = dG.gameArea.getDobbleSet();
        for(int i = 1; i <= 2; i++){
            cards.add(dCards.nthCard(i));
            dCards.removeCard(i);
        }
        
    }
    
    private void backCardsInPlay(DobbleGame dG){
        CardsSet cards = dG.gameArea.getCardsInPlay();
        Dobble dCards = dG.gameArea.getDobbleSet();
        for(int i = 1; i <= 2; i++){
            Card nCard = cards.nthCard(i);
            dCards.addCard(nCard);
            cards.remove(i);
        }
    }
    
    private void pass(DobbleGame dG){
        if(dG.getStatus().equals("SpotIt")){
            CardsSet cardsInPlay = dG.gameArea.getCardsInPlay();
            dG.playersGameControl.addScoreCurrentPlayerTurn(cardsInPlay.numCards());
            dG.playersGameControl.addCardsCurrentPlayerTurn(cardsInPlay);
            cardsInPlay.clear();
        }
        else if(dG.getStatus().equals("NotSpotIt")){
            backCardsInPlay(dG);
        }
    }
}
