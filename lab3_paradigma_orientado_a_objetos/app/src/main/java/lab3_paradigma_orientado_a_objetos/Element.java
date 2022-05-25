/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author Matías Figueroa Contreras
 */
public class Element {
    String element;
    public Element(String e){
        this.element = e;
    }
    
    public Element(int e){
       this.element = Integer.toString(e);
    }
    
    public boolean equals(Element e){
        return this.element.equals(e.element);
    }
    
    @Override
    public String toString(){
        return this.element;
    }
}
