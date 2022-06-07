/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author emdma
 */
public interface IElementsSet {
    public Element nthElement(int n);
    public int numElements();
    public void add(Element e);
    public void remove(int n);
    public void remove(Element e);
    public void clear();
    public boolean contains(Element e);
    public int elementIndex(Element e);
    public String toString();
}
