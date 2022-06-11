/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

import java.util.ArrayList;

/**
 *
 * @author emdma
 */
public class ElementsSet implements IElementsSet{
    private ArrayList<Element> elementsSet = new ArrayList<>();
    
    public ArrayList<Element> getElements(){
        ArrayList<Element> eSCopy = new ArrayList<>(this.elementsSet);
        return eSCopy;
    }
    
    public void setElements(ArrayList<Element> newElements){
        if(isElementsSet(newElements)){
            this.elementsSet = new ArrayList<Element>(newElements);
        }
    }

    private boolean isElementsSet(ArrayList<Element> elements){
        ElementsSet eSCo = new ElementsSet();
        for(int i = 0; i < elements.size(); i++){
            eSCo.add(elements.get(i));
        }
        return eSCo.numElements() == elements.size();
    }
    
    public Element nthElement(int n){
        return this.elementsSet.get(n-1);
    }
    
    public int numElements(){
        return this.elementsSet.size();
    }
    
    public void add(Element e){
        if(!contains(e)){
           this.elementsSet.add(e);
        }
    }
    
    public void remove(int n){
        this.elementsSet.remove(n-1);
    }
    
    public void remove(Element e){
        this.elementsSet.remove(e);
    }
    
    public void clear(){
        this.elementsSet.clear();
    }
    
    public void insertXElements(int x){
        for(int i = 1; i <= x; i++){
            Element eX = new Element(i);
            if(contains(eX)){
                x++;
            }
            else{
                add(eX);
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
    
    public int elementIndex(Element e){
        for(int i = 1; i <= numElements(); i++){
            if(e.equals(nthElement(i))){
                return i;
            }
        }
        return -1;
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
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == getClass()){
            ElementsSet eS = (ElementsSet)o;
            if (numElements() == eS.numElements()){
                for(int i = 1; i <= eS.numElements(); i++){
                    if(!contains(eS.nthElement(i))){
                        return false;
                    }
                }
                return true;
            }
        }
        
        return false;
    }
}

