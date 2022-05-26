/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author emdma
 */
public class Card extends ElementsSet{
    
    public boolean equals(Card c){
        if (this.numElements() == c.numElements()){
            for(int i = 0; i < c.numElements(); i++){
                if(!this.elementsSet.contains(c.nthElement(i))){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    public int commonElements(Card c){
        int cont = 0;
        for(int i = 0; i < c.numElements(); i++){
            if(this.elementsSet.contains(c.nthElement(i))){ // funciona el contains con el element?
                cont++;
            }
        }
        return cont;
    }
    
    public boolean oneCommonElement(Card c){
        int commonE = this.commonElements(c);
        return commonE == 1;
    }
}
