/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

import java.util.ArrayList;

/**
 *
 * @author emdma
 */
public interface ICardsSet {
    public ArrayList<Card> getCards();
    public void setCards(ArrayList<Card> cards);
    public void add(Card card);
    public Card nthCard(int n);
    public int numCards();
    public void union(ICardsSet cS);
    public void subtract(ICardsSet cS);
    public void remove(int n);
    public void remove(Card card);
    public void clear();
    public boolean contains(Card card);
    public int elementOccurrences(String element);
    public void mix();
    public boolean equals(Object object);
    public String toString();
}
