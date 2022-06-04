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
    
    public int commonElements(Card c){
        int cont = 0;
        for(int i = 1; i <= c.numElements(); i++){
            
            if(contains(c.nthElement(i))){
                cont++;
            }
        }
        return cont;
    }
    
    public boolean oneCommonElement(Card c){
        int commonE = commonElements(c);
        return commonE == 1;
    }
}
