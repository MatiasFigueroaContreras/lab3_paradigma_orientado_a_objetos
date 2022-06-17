/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

/**
 *
 * @author emdma
 */
public interface IDobble {
    public int findTotalCards(Card card);
    public int requiredElements(Card card);
    public ICardsSet missingCards();
    public boolean isValidCard(Card card);
    public Card nthCard(int n);
    public void addCard(Card card);
    public void removeCard(int n);
    public void removeCard(Card card);
    public void addElement(String element);
    public void removeElement(int n);
    public void removeElement(String element);
    public ICardsSet getDobbleCards();
    public void setDobbleCards(ICardsSet cards);
    public IElementsSet getElements();
    public void setElements(IElementsSet elements);
    public String toString();
    public boolean equals(Object o);
}
