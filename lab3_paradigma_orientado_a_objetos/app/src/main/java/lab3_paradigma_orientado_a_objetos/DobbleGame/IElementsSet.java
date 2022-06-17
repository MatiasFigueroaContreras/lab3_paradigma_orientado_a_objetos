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
    public ArrayList<IElement> getElements();
    public void setElements(ArrayList<IElement> elements);
    public IElement nthElement(int n);
    public String nthElementString(int n);
    public int numElements();
    public void add(IElement element);
    public void add(String element);
    public void insertXElements(int x);
    public void remove(int n);
    public void remove(IElement element);
    public void remove(String element);
    public void clear();
    public boolean contains(IElement element);
    public boolean contains(String element);
    public int elementIndex(IElement element);
    public String toString();
    public boolean equals(Object object);

}
