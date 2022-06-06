/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

import java.util.ArrayList;

/**
 *
 * @author emdma
 */
public class CardsSet {
    private ArrayList<Card> cardsSet = new ArrayList<>();
    
    public ArrayList<Card> getCards(){
        ArrayList<Card> cSCopy = new ArrayList<>(this.cardsSet);
        return cSCopy;
    }
    
    public void setCards(ArrayList<Card> newCards){
        if(isCardsSet(newCards)){
            this.cardsSet = new ArrayList<Card>(newCards);
        }
    }
    
    private boolean isCardsSet(ArrayList<Card> cards){
        CardsSet cSCo = new CardsSet();
        for(int i = 0; i < cards.size(); i++){
            cSCo.add(cards.get(i));
        }
        return cSCo.numCards() == cards.size();
    }
    
    public void add(Card c){
        if(!contains(c)){
           this.cardsSet.add(c);
        }
    }
    
    public Card nthCard(int n){
        return this.cardsSet.get(n-1);
    }
    
    public int numCards(){
        return this.cardsSet.size();
    }
    
    public void union(CardsSet cS){
        for(int i = 1; i <= cS.numCards(); i++){
            add(cS.nthCard(i));
        }
    }
    
    public void subtract(CardsSet cS){
        for(int i = 1; i <= cS.numCards(); i++){
            remove(cS.nthCard(i));
        }
    }
    
    public void remove(int n){
        this.cardsSet.remove(n-1);
    }
    
    public void remove(Card c){
        for(int i = 1; i <= numCards(); i++){
            if(c.equals(nthCard(i))){
                remove(i);
            }
        }
    }
    
    public void clear(){
        this.cardsSet.clear();
    }
    
    public boolean contains(Card c){
        for(int i = 1; i <= numCards(); i++){
            if(c.equals(nthCard(i))){
                return true;
            }
        }
        return false;
    }
    
    public int elementOccurrences(Element e){
        int count = 0;
        for(int i = 1; i <= numCards(); i++){
            if(nthCard(i).contains(e)){
                count++;
            }
        }
        return count;
    }
    
    @Override
    public String toString(){
        String str = "";
        for(int i = 1; i <= numCards(); i++){
            String n = Integer.toString(i) + ": ";
            str += "Card n" + n + nthCard(i).toString() + "\n";
        }
        return str;
    }
}
