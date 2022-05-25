/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

import java.util.ArrayList;

/**
 *
 * @author emdma
 */
public class Card {
    ArrayList<Element> card = new ArrayList<>();
    
    public Element nthElement(int n){
        return this.card.get(n);
    }
    
    public int numElements(){
        return this.card.size();
    }
    
    public boolean equals(Card c){
        if (this.numElements() == c.numElements()){
            for(int i = 0; i < c.numElements(); i++){
                if(!this.card.contains(c.nthElement(i))){
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
            if(this.card.contains(c.nthElement(i))){ // funciona el contains con el element?
                cont++;
            }
        }
        return cont;
    }
    
    public boolean oneCommonElement(Card c){
        int commonE = this.commonElements(c);
        if(commonE == 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void insertElement(Element e){
        this.card.add(e);
    }
    
    @Override
    public String toString(){
        String str = "";
        int i;
        for(i = 0; i < this.numElements() - 1; i++){
            str = str + this.nthElement(i).toString() + ",";
        }
        return str + this.nthElement(i);
    }
}
