/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

import static com.google.common.math.IntMath.isPrime;
import java.util.ArrayList;

/**
 *
 * @author emdma
 */
public class Dobble implements IDobble{
    private ICardsSet dobbleCS = new CardsSet();
    private IElementsSet elements;
    private int numE;
    private int[] elementsAppareances;
     
    public Dobble(IElementsSet eS, int numE, int maxC){
        this(numE);
        int totalCards = totalCardsNumElements(numE);
        if(eS.numElements() < totalCards){
            eS.insertXElements(totalCards - eS.numElements());
        }
        this.elements = eS;
        initDobbleCards(maxC);
    }

    public Dobble(ArrayList<String> elements, int numE, int maxC){
        this(numE);
        IElementsSet eS = new ElementsSet(elements);
        int totalCards = totalCardsNumElements(numE);
        if(eS.numElements() < totalCards){
            eS.insertXElements(totalCards - eS.numElements());
        }
        this.elements = eS;
        initDobbleCards(maxC);
    }
    
    public Dobble(IElementsSet eS, int numE){
        this(numE);
        this.elements = eS;
    }
    
    public Dobble(int numE){
        int n = numE - 1;
        if(isPrime(n)){
            int totalCards = totalCardsNumElements(numE);
            this.elements = new ElementsSet();
            this.elementsAppareances = new int[totalCards];
            initElementsAppearances();
            this.numE = numE;
        }
    }
    
    public void initDobbleCards(int maxC){
        int totalCards = totalCardsNumElements(this.numE);
        if(this.elements.numElements() >= totalCards){
            int n = this.numE - 1;
            if(maxC <= 0){
                maxC = totalCardsNumElements(numE);
            }
            firstCardGeneration(n);
            nCardsGeneration(n, maxC-1);
            n2CardsGeneration(n, maxC-n-1);
            this.dobbleCS.mix();
        }      
    }
    
    private void firstCardGeneration(int n){
        Card card = new Card();
        for(int i = 1; i <= n+1; i++){
            card.add(this.elements.nthElement(i));
            this.elementsAppareances[i - 1]++;
        }
        this.dobbleCS.add(card);
    }
    
    private void nCardsGeneration(int n, int maxC){
        for(int i = 1; i <= n && maxC > 0; i++, maxC--){
            Card card = new Card();
            card.add(this.elements.nthElement(1));
            this.elementsAppareances[0]++;
            for(int j = 1; j <= n; j++){
                card.add(this.elements.nthElement(n*i + (j+1)));
                this.elementsAppareances[(n*i + (j+1)) - 1]++;
            }
            this.dobbleCS.add(card);
        }
    }
    
    private void n2CardsGeneration(int n, int maxC){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n && maxC > 0; j++, maxC--){
                Card card = new Card();
                card.add(this.elements.nthElement(i+1));
                this.elementsAppareances[i]++;
                for(int k = 1; k <= n; k++){
                    card.add(this.elements.nthElement(n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n)));
                    this.elementsAppareances[(n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n)) - 1]++;
                }
                this.dobbleCS.add(card);
            }
        }
    }
    
    public static int totalCardsNumElements(int numE){
        return numE*numE - numE+1; 
    }
    
    private void initElementsAppearances(){
        for(int i = 0; i < this.elementsAppareances.length; i++){
            this.elementsAppareances[i] = 0;
        }
    }
    
    public CardsSet getDobbleCards(){
        CardsSet dobbleCSCopy = new CardsSet();
        dobbleCSCopy.setCards(this.dobbleCS.getCards());
        return dobbleCSCopy;
    }
    
    public void setDobbleCards(CardsSet newDobbleCards){
        if(completeNumElements()){
            int[] copyEA = this.elementsAppareances.clone();
            initElementsAppearances();
            if(isDobbleCards(newDobbleCards)){
               this.dobbleCS.setCards(newDobbleCards.getCards());
            }
            this.elementsAppareances = copyEA;
        }
    }

    public ElementsSet getElements(){
        ElementsSet elementsCopy = new ElementsSet();
        elementsCopy.setElements(this.elements.getElements());
        return elementsCopy;
    }
    
    public void setElements(ElementsSet newElements){
        if(this.dobbleCS.numCards() == 0){
            if(newElements.numElements() <= totalCardsNumElements(numE)){
                this.elements.setElements(newElements.getElements());
            }
        }
    }
    
    private boolean completeNumElements(){
        return this.elements.numElements() == totalCardsNumElements(numE);
    }
    
    private boolean isDobbleCards(CardsSet cS){
        for(int i = 1; i <= cS.numCards(); i++){
            Card nCard = cS.nthCard(i);
            if(addElementsAppearences(nCard, this.elementsAppareances)){
                for(int j = i + 1; j <= cS.numCards(); j++){
                    if(!nCard.oneCommonElement(cS.nthCard(j))){
                        return false;
                    }
                }               
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    private boolean addElementsAppearences(Card c, int[] elementsA){
        for(int i = 1; i <= c.numElements(); i++){      
            int eIndex = this.elements.elementIndex(c.nthElement(i)) - 1;
            if(eIndex <= -1 || (elementsA[eIndex] + 1) > this.numE){
                return false;
            }
            else{
                elementsA[eIndex]++;
            }
        }
        return true;
    }
    
    private void resElementsAppearences(Card c){
        for(int i = 1; i <= c.numElements(); i++){
            int eIndex = this.elements.elementIndex(c.nthElement(i)) - 1;
            this.elementsAppareances[eIndex]--;
        }
    }
    
    public int findTotalCards(Card c){
        return totalCardsNumElements(c.numElements());
    }
    
    public int requiredElements(Card c){
        return totalCardsNumElements(c.numElements());
    }
    
    public ICardsSet missingCards(){
        int numE = this.dobbleCS.nthCard(1).numElements();
        Dobble fullDobble = new Dobble(this.elements, numE, 0);
        fullDobble.dobbleCS.subtract(this.dobbleCS);
        return fullDobble.dobbleCS;
    }
    
    public boolean isValidCard(Card c){
        for(int i = 1; i <= this.dobbleCS.numCards(); i++){
            if(!this.dobbleCS.nthCard(i).oneCommonElement(c)){
                return false;
            }
        }
        return true;
    }
    
    public int numCards(){
        return this.dobbleCS.numCards();
    }
    
    public Card nthCard(int i){
        return this.dobbleCS.nthCard(i);
    }
    
    public void addCard(Card c){
        if(completeNumElements()){
            System.out.println();
            int[] copyEA = this.elementsAppareances.clone();
            if(addElementsAppearences(c, copyEA)){
                if(isValidCard(c)){
                    this.dobbleCS.add(c);
                    this.elementsAppareances = copyEA;
                }
            }           
        }
    }
    
    public void removeCard(int n){
        resElementsAppearences(this.dobbleCS.nthCard(n));
        this.dobbleCS.remove(n);
    }
    
    public void removeCard(Card c){
        this.dobbleCS.remove(c);
        resElementsAppearences(c);
    }
    
    public void addElement(String e){
        if(!completeNumElements()){
            this.elements.add(e);
        }
    }
    
    public int numElements(){
        return this.elements.numElements();
    }
    
    public Element nthElement(int i){
        return this.elements.nthElement(i);
    }
    
    public void removeElement(int n){
        if(this.dobbleCS.numCards() == 0){
            this.elements.remove(n);
        }
    }
    
    public void removeElement(String e){
        if(this.dobbleCS.numCards() == 0){
            this.elements.remove(e);
        }
    }
    
    @Override
    public String toString(){
        return "Elements:\n" + this.elements.toString() + "\nCards:\n" + this.dobbleCS.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == getClass()){
            Dobble d = (Dobble)o;
            return d.dobbleCS.equals(this.dobbleCS) && d.elements.equals(this.elements); 
        }
        return false;
    }
}
