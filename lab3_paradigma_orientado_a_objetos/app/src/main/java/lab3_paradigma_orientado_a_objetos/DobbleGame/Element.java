/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

/**
 *
 * @author Matías Figueroa Contreras
 */
public class Element {
    public String element;
    public Element(String e){
        this.element = e;
    }
    
    public Element(int e){
       this.element = Integer.toString(e);
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == getClass()){
            Element e = (Element)o;
            return this.element.equals(e.element);
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.element;
    }
}
