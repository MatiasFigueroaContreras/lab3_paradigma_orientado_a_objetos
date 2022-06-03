/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

import static com.google.common.math.IntMath.isPrime;
import java.util.ArrayList;

/**
 *
 * @author emdma
 */
public class Dobble {
    CardsSet dobbleCS = new CardsSet();
    ElementsSet elements;
            
    public Dobble(ElementsSet eS, int numE, int maxC){
        int n = numE - 1;
        if(isPrime(numE)){
            if(eS.numElements() < totalCardsNumE(numE)){
                eS.insertXElements(totalCardsNumE(numE) - eS.numElements());
            }
            if(maxC <= 0){
                maxC = totalCardsNumE(numE);
            }
            this.elements = eS;
            firstCardGeneration(n);
            nCardsGeneration(n, maxC-1);
            n2CardsGeneration(n, maxC-n-1);
        }
    }
    
    private int totalCardsNumE(int numE){
        return numE*numE - numE+1; 
    }
    
    private void firstCardGeneration(int n){
        Card card = new Card();
        for(int i = 1; i <= n+1; i++){
            card.insertElement(this.elements.nthElement(i));
        }
        this.dobbleCS.insertCard(card);
    }
    
    private void nCardsGeneration(int n, int maxC){
        for(int i = 1; i <= n && maxC > 0; i++, maxC--){
            Card card = new Card();
            card.insertElement(this.elements.nthElement(1));

            for(int j = 1; j <= n; j++){
                card.insertElement(this.elements.nthElement(n*i + (j+1)));
            }
            this.dobbleCS.insertCard(card);
        }
    }
    
    private void n2CardsGeneration(int n, int maxC){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n && maxC > 0; j++, maxC--){
                Card card = new Card();
                card.insertElement(this.elements.nthElement(i+1));
                for(int k = 1; k <= n; k++){
                    card.insertElement(this.elements.nthElement(n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n)));
                }
                this.dobbleCS.insertCard(card);
            }
        }
    }
    
    public int findTotalCards(Card c){
        return totalCardsNumE(c.numElements());
    }
    
    public int requiredElements(Card c){
        return totalCardsNumE(c.numElements());
    }
    
    public CardsSet missingCards(){
        int numE = this.dobbleCS.nthCard(1).numElements();
        Dobble fullDobble = new Dobble(this.elements, numE, 0);
        fullDobble.dobbleCS.subtract(this.dobbleCS);
        return fullDobble.dobbleCS;
    }
    
    
    
    @Override
    public String toString(){
        return "Elements:\n" + this.elements.toString() + "\nCards:\n" + this.dobbleCS.toString();
    }
    
    public boolean equals(Dobble d){
        return d.dobbleCS.equals(this.dobbleCS);
    }
    
    
}
