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
public interface IElementsSet {
    public ArrayList<Element> getElements();
    public void setElements(ArrayList<Element> elements);
    public Element nthElement(int n);
    public int numElements();
    public void add(Element e);
    public void insertXElements(int x);
    public void remove(int n);
    public void remove(Element e);
    public void clear();
    public boolean contains(Element e);
    public int elementIndex(Element e);
    public String toString();
    public boolean equals(Object o);
}
