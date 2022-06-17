/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Busca representar un conjunto de cartas (ICardsSet), respetando como
 *  funcionan los conjuntos.
 * @author Matias Figueroa Contreras
 */
public class CardsSet implements ICardsSet{
    /**
    * El conjunto de cartas representado en un Arreglo. Creado en primera
    *   instancia vacio.
    */
    private ArrayList<Card> cardsSet = new ArrayList<>();
    
    /**
    * <p> Getter.
    * </p>
    * @return una copia del Arreglo de cartas.
    */
    public ArrayList<Card> getCards(){
        ArrayList<Card> cSCopy = new ArrayList<>(this.cardsSet);
        return cSCopy;
    }
    
    /**
    * <p> Setter, que cambia this.cardsSet por una copia de la nueva lista de 
    *       cartas verificando que esta cumpla con ser un conjunto de 
    *       cartas.
    * </p>
    * @param newCards lista de cartas a setear.
    */
    public void setCards(ArrayList<Card> newCards){
        if(isCardsSet(newCards)){
            this.cardsSet = new ArrayList<>(newCards);
        }
    }
    
    /**
    * <p> Busca verificar que una lista de cartas sea un conjunto de estos.
    *       es decir, sin cartas repetidas.
    * </p>
    * @param cards Arreglo de cartas a verificar.
    * @return true si es un conjunto, false si no es un conjunto.
    */
    private boolean isCardsSet(ArrayList<Card> cards){
        CardsSet cSCo = new CardsSet();
        for(int i = 0; i < cards.size(); i++){
            cSCo.add(cards.get(i));
        }
        return cSCo.numCards() == cards.size();
    }
    
    /**
    * <p> Añade una carta al conjunto, respetando que este no sea parte de este.
    * </p>
    * @param card carta a agregar al conjunto
    */
    public void add(Card card){
        if(!contains(card)){
           this.cardsSet.add(card);
        }
    }
    
    /**
    * <p> Busca la nth Carta del conjunto, partiendo desde 1.
    * </p>
    * @param n indice (nth) a buscar en el conjunto.
    * @return la nth carta buscada.
    */
    public Card nthCard(int n){
        return this.cardsSet.get(n-1);
    }
    
     /**
    * <p> Cuenta la cantidad de cartas en el conjunto.
    * </p>
    * @return cantidad de cartas en el conjunto.
    */
    public int numCards(){
        return this.cardsSet.size();
    }
    
    public void union(ICardsSet cS){
        for(int i = 1; i <= cS.numCards(); i++){
            add(cS.nthCard(i));
        }
    }
    
    public void subtract(ICardsSet cS){
        for(int i = 1; i <= cS.numCards(); i++){
            remove(cS.nthCard(i));
        }
    }
    
    /**
    * <p> Elimina la nth Carta del conjunto (partiendo de 1).
    * </p>
    * @param n nth carta a eliminar del conjunto.
    */
    public void remove(int n){
        this.cardsSet.remove(n-1);
    }
    
    /**
    * <p> Elimina la carta dada si es que se encuentra en el conjunto.
    * </p>
    * @param card carta a eliminar del conjunto.
    */
    public void remove(Card card){
        for(int i = 1; i <= numCards(); i++){
            if(card.equals(nthCard(i))){
                remove(i);
            }
        }
    }
    
    /**
    * <p> Elimina todas las cartas del conjunto.
    * </p>
    */
    public void clear(){
        this.cardsSet.clear();
    }
    
    /**
    * <p> Verifica si una carta pertenece al conjunto.
    * </p>
    * @param card carta a verifcar.
    * @return true si el conjunto contiene la carta dada, false sino la
    *           contiene.
    */
    public boolean contains(Card card){
        for(int i = 1; i <= numCards(); i++){
            if(card.equals(nthCard(i))){
                return true;
            }
        }
        return false;
    }
    
    /**
    * <p> Cuenta las apariciones de un elemento en el set de cartas.
    * </p>
    * @param element elemento a contar.
    * @return numero de apariciones del elmento dado.
    */
    public int elementOccurrences(String element){
        int count = 0;
        for(int i = 1; i <= numCards(); i++){
            if(nthCard(i).contains(element)){
                count++;
            }
        }
        return count;
    }
    
    /**
    * <p> Revuelve las cartas.
    * </p>
    */
    public void mix(){
        Random rand = new Random();
        int randNumChanges = rand.nextInt(numCards()*2) + numCards();
        for(int i = 1; i <= randNumChanges; i++){
            int n = rand.nextInt(numCards()) + 1;
            Card nCard = nthCard(n);
            remove(n);
            int newN = rand.nextInt(numCards());
            this.cardsSet.add(newN, nCard);
        }
    }
    
    /**
    * <p> Compara this con otro Objeto, para esto compara si son de la misma
    *      clase (CardsSet) y luego si los dos conjuntos poseen las mismas
    *      cartas.
    * </p>
    * @param object objeto a comparar con this.
    * @return true si son iguales, false si no son iguales.
    */
    @Override
    public boolean equals(Object o){
        if(o.getClass() == getClass()){
            CardsSet cS = (CardsSet)o;
            if(cS.numCards() == numCards()){
                for(int i = 1; i <= cS.numCards(); i++){
                    if(!contains(cS.nthCard(i))){
                        return false;
                    }
                }
                return true;
            }
        }
        
        return false;
    }
    
    /**
    * <p> Pasa la representacion del Conjunto de cartas a String.
    * </p>
    * @return String en representacion del conjunto de cartas.
    */
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
