/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

import java.util.ArrayList;

/**
 * Interfaz que busca establecer los metodos que necesita conjunto de cartas, 
 *  respetando como funcionan los conjuntos.
 * @author Matias Figueroa Contreras
 */
public interface ICardsSet {
    /**
    * <p> Getter.
    * </p>
    * @return Arreglo de cartas.
    */
    public ArrayList<Card> getCards();
    
    /**
    * <p> Setter.
    * </p>
    * @param cards lista de cartas a setear.
    */
    public void setCards(ArrayList<Card> cards);
    
    /**
    * <p> Añade una carta al conjunto, respetando que este no sea parte de este.
    * </p>
    * @param card carta a agregar al conjunto.
    */
    public void add(Card card);
    
    /**
    * <p> Busca la nth Carta del conjunto.
    * </p>
    * @param n indice (nth) a buscar en el conjunto.
    * @return la nth carta buscada.
    */
    public Card nthCard(int n);
    
    /**
    * <p> Cuenta la cantidad de cartas en el conjunto.
    * </p>
    * @return cantidad de cartas en el conjunto.
    */
    public int numCards();
    
    /**
    * <p> Une un conjunto de cartas dado con this, respetando la union
    *       de conjuntos conocida.
    * </p>
    * @param cards cartas a unir con this.
    */
    public void union(ICardsSet cS);
    
    /**
    * <p> Hace una resta de conjuntos entre las cartas dadas y this, respetando
    *       la reste de conjuntos conocidas.
    * </p>
    * @param cards cartas a restar con this.
    */
    public void subtract(ICardsSet cS);
    
    /**
    * <p> Elimina la nth Carta del conjunto (partiendo de 1).
    * </p>
    * @param n nth carta a eliminar del conjunto.
    */
    public void remove(int n);
    
    /**
    * <p> Elimina la carta dada si es que se encuentra en el conjunto.
    * </p>
    * @param card carta a eliminar del conjunto.
    */
    public void remove(Card card);
    
    /**
    * <p> Elimina todas las cartas del conjunto.
    * </p>
    */
    public void clear();
    
    /**
    * <p> Verifica si una carta pertenece al conjunto.
    * </p>
    * @param card carta a verifcar.
    * @return true si el conjunto contiene la carta dada, false sino la
    *           contiene.
    */
    public boolean contains(Card card);
    
    /**
    * <p> Cuenta las apariciones de un elemento en el set de cartas.
    * </p>
    * @param element elemento a contar.
    * @return numero de apariciones del elmento dado.
    */
    public int elementOccurrences(String element);
    
    /**
    * <p> Revuelve las cartas.
    * </p>
    */
    public void mix();
    
    /**
    * <p> Compara this con otro Objeto.
    * </p>
    * @param object objeto a comparar con this.
    * @return true si son iguales, false si no son iguales.
    */
    public boolean equals(Object object);
    
    /**
    * <p> Pasa la representacion del Conjunto de cartas a String.
    * </p>
    * @return String en representacion del conjunto de cartas.
    */
    public String toString();
}
