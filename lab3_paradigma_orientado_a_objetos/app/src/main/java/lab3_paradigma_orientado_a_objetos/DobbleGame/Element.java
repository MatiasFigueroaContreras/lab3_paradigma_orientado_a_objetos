/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

/**
 * La clase Element, busca representar los elementos que estara presente en las
 *  cartas, de una manera mas estandarizada.
 * @author Matias Figueroa Contreras
 */
public class Element implements IElement{
    /**
    * El Elemento que sera representado como una String.
    */
    public String element;
    
    /**
    * <p> Crea el objeto Element.
    * </p>
    * @param element El elemento representado en String
    * @return el objeto Element creado
    */
    public Element(String element){
        this.element = element;
    }
    
    /**
    * <p> Crea el objeto Element, transformando el elemento entero a String.
    * </p>
    * @param element El elemento representado en int
    * @return el objeto Element creado
    */
    public Element(int element){
       this.element = Integer.toString(element);
    }
    
    /**
    * <p> Compara this con otro Objeto, para esto compara si son de la misma
    *      clase (Element) y luego si el valor de su atributo es el mismo.
    * </p>
    * @param object objeto a comparar con this
    * @return true si son iguales, false si no son iguales.
    */
    @Override
    public boolean equals(Object object){
        if(object.getClass() == getClass()){
            Element e = (Element)object;
            return this.element.equals(e.element);
        }
        return false;
    }
    
    /**
    * <p> Pasa la representacion del Elemento a String (es el mismo this.element).
    * </p>
    * @return String en representacion del elemento (this.element).
    */
    @Override
    public String toString(){
        return this.element;
    }
}
