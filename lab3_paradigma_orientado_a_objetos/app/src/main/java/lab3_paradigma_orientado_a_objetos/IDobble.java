/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author emdma
 */
public interface IDobble {
    public int findTotalCards(Card c);
    public int requiredElements(Card c);
    public CardsSet missingCards();
    public boolean isValidCard(Card c);
    public Card nthCard(int i);
    public void addCard(Card c);
    public void removeCard(int n);
    public void removeCard(Card c);
    //public void addElement(Element e);
    //public void removeElement(int n);
    //public void removeElement(Element e);
    public String toString();
    public boolean equals(Dobble d);
}
