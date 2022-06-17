/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

import java.util.ArrayList;

/**
 * Representa una carta para el juego Dobble, la cual hereda los atributos
 *  y metodos de la clase ElementsSet.
 * @author Matias Figueroa Contreras
 */
public class Card extends ElementsSet{
    
    /**
    * <p> Constructor, con un conjunto de elementos vacio.
    * </p>
    * @return el objeto Card creado.
    */
    public Card(){
        this.elementsSet = new ArrayList<>();
    }
    
    /**
    * <p> Constructor, agrega elementos al conjunto
    *       (Respetando que no se repitan estos).
    * </p>
    * @param elements Arreglo de strings con los elementos a agregar.
    * @return el objeto Card creado.
    */
    public Card(ArrayList<String> elements){
        this.elementsSet = new ArrayList<>();
        for(int i = 0; i < elements.size(); i++){
            Element e = new Element(elements.get(i));
            add(e);
        }
    }
    
    /**
    * <p> Cuenta los elmentos comunes entre la carta entregada y this. 
    * </p>
    * @param card carta con la cual se comparan los elementos.
    * @return numero de elementos comunes.
    */
    public int commonElements(Card card){
        int cont = 0;
        for(int i = 1; i <= card.numElements(); i++){
            if(contains(card.nthElement(i))){
                cont++;
            }
        }
        return cont;
    }
    
    /**
    * <p> Consulta si una carta dada tiene solo un elemento en comun con this.
    * </p>
    * @param card carta con la cual se comparan los elementos.
    * @return true si tiene un solo elemento en comun, false sino.
    */
    public boolean oneCommonElement(Card card){
        int commonE = commonElements(card);
        return commonE == 1;
    }
}
