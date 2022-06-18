/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

import java.util.ArrayList;

/**
 * Busca representar un conjunto de elementos (IElement), respetando como 
 *  funcionan los conjuntos.
 * @author Matias Figueroa Contreras
 */
public class ElementsSet implements IElementsSet{
    /**
    * El conjunto de elementos implementado como un ArrayList.
    */
    protected ArrayList<IElement> elementsSet;
    
    /**
    * <p> Constructor, con un conjunto de elementos vacio.
    * </p>
    * @return el objeto ElementSet creado.
    */
    public ElementsSet(){
        this.elementsSet = new ArrayList<>();
    }
    
    /**
    * <p> Constructor, agrega elementos al conjunto
    *       (Respetando que no se repitan estos).
    * </p>
    * @param elements Arreglo de strings con los elementos a agregar.
    * @return el objeto ElementSet creado.
    */
    public ElementsSet(ArrayList<String> elements){
        this.elementsSet = new ArrayList<>();
        for(int i = 0; i < elements.size(); i++){
            IElement e = new Element(elements.get(i));
            add(e);
        }
    }
    
    /**
    * <p> Getter.
    * </p>
    * @return una copia del Arreglo de elementos.
    */
    public ArrayList<IElement> getElements(){
        ArrayList<IElement> eSCopy = new ArrayList<>(this.elementsSet);
        return eSCopy;
    }
    
    /**
    * <p> Setter, que cambia this.elements por una copia de la nueva lista de 
    *       elementos verificando que esta cumpla con ser un conjunto de 
    *       elementos.
    * </p>
    * @param newElements lista de elementos a agregar.
    */
    public void setElements(ArrayList<IElement> newElements){
        if(isElementsSet(newElements)){
            this.elementsSet = new ArrayList<IElement>(newElements);
        }
    }
    
    /**
    * <p> Busca verificar que una lista de elementos sea un conjunto de estos.
    *       es decir, sin elementos repetidos.
    * </p>
    * @param elements Arreglo de elementos a verificar.
    * @return true si es un conjunto, false si no es un conjunto.
    */
    private boolean isElementsSet(ArrayList<IElement> elements){
        ElementsSet eSCo = new ElementsSet();
        for(int i = 0; i < elements.size(); i++){
            eSCo.add(elements.get(i));
        }
        return eSCo.numElements() == elements.size();
    }
    
    /**
    * <p> Busca el nth Elemento del conjunto, partiendo desde 1.
    * </p>
    * @param n indice (nth) a buscar en el conjunto.
    * @return el nth elemento buscado.
    */
    public IElement nthElement(int n){
        return this.elementsSet.get(n-1);
    }
    
    
    /**
    * <p> Busca el nth Elemento del conjunto y lo representa en string.
    * </p>
    * @param n indice (nth) a buscar en el conjunto.
    * @return el nth elemento representado en string.
    */
    public String nthElementString(int n){
        return nthElement(n).toString();
    }
    
    
    /**
    * <p> Cuenta la cantidad de elementos en el conjunto.
    * </p>
    * @return la cantidad de elementos del conjunto.
    */
    public int numElements(){
        return this.elementsSet.size();
    }
    
    
    /**
    * <p> Añade un elemento al conjunto, respetando que este no sea parte de 
    * este.
    * </p>
    * @param element elemento a agregar al conjunto.
    */
    public void add(IElement element){
        if(!contains(element)){
           this.elementsSet.add(element);
        }
    }
    
    /**
    * <p> Añade un elemento al conjunto, respetando que este no sea parte de
    *       ya, pasando el string a su representacion en Element.
    * </p>
    * @param element elemento a agregar al conjunto.
    */
    public void add(String element){
        IElement el = new Element(element);
        add(el);
    }
    
    /**
    * <p> Agrega x cantidad de elementos al conjunto
    * </p>
    * @param x cantidad de elementos a agregar.
    */
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
    
    /**
    * <p> Elimina el nth Elemento del conjunto (partiendo de 1).
    * </p>
    * @param n nth elemento a eliminar del conjunto.
    */
    public void remove(int n){
        this.elementsSet.remove(n-1);
    }
    
    /**
    * <p> Elimina el elemento dado si es que se encuentra en el conjunto.
    * </p>
    * @param element elemento a eliminar del conjunto.
    */
    public void remove(IElement element){
        this.elementsSet.remove(element);
    }
    
    /**
    * <p> Elimina el elemento dado en forma de String si es que se encuentra 
    *       en el conjunto.
    * </p>
    * @param element elemento a eliminar del conjunto, en su forma de String.
    */
    public void remove(String element){
        IElement el = new Element(element);
        remove(el);
    }
    
    /**
    * <p> Elimina todos los elementos del conjunto.
    * </p>
    */
    public void clear(){
        this.elementsSet.clear();
    }
    
    /**
    * <p> Verifica si un elmento pertenece al conjunto.
    * </p>
    * @param element elemento a verifcar.
    * @return true si el conjunto contiene el elemento dado, false sino lo
    *           contiene.
    */
    public boolean contains(IElement element){
        for(int i = 1; i <= numElements(); i++){
            if(element.equals(nthElement(i))){
                return true;
            }
        }
        return false;
    }
    
    /**
    * <p> Verifica si un elmento pertenece al conjunto, transformando el string
    *       a su representacion en elemento.
    * </p>
    * @param element representacion en string del elemento a verifcar.
    * @return true si el conjunto contiene el elemento dado, false sino lo
    *           contiene.
    */
    public boolean contains(String element){
        IElement e = new Element(element);
        for(int i = 1; i <= numElements(); i++){
            if(e.equals(nthElement(i))){
                return true;
            }
        }
        return false;
    }
    
    /**
    * <p> Busca el indice del elemento entregado.
    * </p>
    * @param element elemento a buscar el indice.
    * @return el indice del elemento, y -1 si no lo encuentra.
    */
    public int elementIndex(IElement element){
        for(int i = 1; i <= numElements(); i++){
            if(element.equals(nthElement(i))){
                return i;
            }
        }
        return -1;
    }
    
    /**
    * <p> Pasa la representacion del Conjunto de Elementos a String.
    * </p>
    * @return String en representacion del conjunto de elementos.
    */
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
    
    
    /**
    * <p> Compara this con otro Objeto, para esto compara si son de la misma
    *      clase (ElementSet) y luego si los dos conjuntos poseen los mismos
    *      elementos.
    * </p>
    * @param object objeto a comparar con this.
    * @return true si son iguales, false si no son iguales.
    */
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

