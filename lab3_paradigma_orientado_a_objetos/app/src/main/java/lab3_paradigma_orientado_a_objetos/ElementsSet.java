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
public class ElementsSet {
    ArrayList<Element> elementsSet = new ArrayList<>();
    
    public Element nthElement(int n){
        return this.elementsSet.get(n-1);
    }
    
    public int numElements(){
        return this.elementsSet.size();
    }
    
    public void insertElement(Element e){
        this.elementsSet.add(e);
    }
    
    public void delete(int n){
        this.elementsSet.remove(n-1);
    }
    
    public void delete(Element e){
        this.elementsSet.remove(e);
    }   
    
    public void clearOut(){
        this.elementsSet.clear();
    }
    
    public void insertXElements(int x){
        for(int i = 1; i <= x; i++){
            Element eX = new Element(i);
            if(contains(eX)){
                x++;
            }
            else{
                insertElement(eX);
            }
        }
    }
    
    public boolean contains(Element e){
        for(int i = 1; i <= numElements(); i++){
            if(e.equals(nthElement(i))){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        String str = "";
        int i;
        for(i = 1; i < numElements(); i++){
            str = str + nthElement(i).toString() + ", ";
        }
        if(i != 1){
            return str + nthElement(i);
        }
        else{
            return str;
        }
    }
}
    
