/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

import java.util.ArrayList;

/**
 *
 * @author emdma
 */
public interface ICardsSet {
    public void add(Card c);
    public Card nthCard(int n);
    public int numCards();
    public void remove(int n);
    public void remove(Card c);
    public void clear();
    public boolean contains(Card c);
    public int elementOccurrences(Element e);
    public String toString();
}
