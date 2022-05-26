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
public class Dobble {
    CardsSet dobbleCS = new CardsSet();
    ElementsSet elements;
            
    public Dobble(ElementsSet eS, int numE, int maxC, int seed){
        int n = numE - 1;
        
        if(eS.numElements() < totalCardsNumE(numE)){
            eS.insertXElements(totalCardsNumE(numE) - eS.numElements());
        }
        this.elements = eS;
        firstCardGeneration(n);
        nCardsGeneration(n, maxC-1);
        n2CardsGeneration(n, maxC-n-1);
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
        Card card = new Card();
        for(int i = 1; i <= n; i++){
            if(maxC > 0){
                card.clearOut();
                card.insertElement(this.elements.nthElement(1));

                for(int j = 1; j <= n; j++){
                    card.insertElement(this.elements.nthElement(n*i + (j+1)));
                }
                this.dobbleCS.insertCard(card);
                maxC--;
            }
            else{
                return;
            }
        }
    }
    
    private void n2CardsGeneration(int n, int maxC){
        Card card = new Card();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(maxC > 0){
                    card.clearOut();
                    card.insertElement(this.elements.nthElement(i+1));
                    for(int k = 1; k <= n; k++){
                        card.insertElement(this.elements.nthElement(n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n)));
                    }
                    this.dobbleCS.insertCard(card);
                    maxC--;
                }
                else{
                    return;
                }
            }
        }
    }
}
