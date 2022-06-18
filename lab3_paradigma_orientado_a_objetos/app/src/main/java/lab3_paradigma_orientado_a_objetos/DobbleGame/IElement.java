/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

/**
 * Interfaz que busca estandarizar y definir las acciones que tiene que realizar
 *  un elemento
 * @author Matias Figueroa Contreras
 */
public interface IElement {
    /**
    * <p> Compara si son iguales this con otro Objeto.
    * </p>
    * @param object objeto a comparar con this
    * @return true si son iguales, false si no son iguales.
    */
    public boolean equals(Object object);
    /**
    * <p> Pasa la representacion del elemento a String.
    * </p>
    * @return String en representacion del elemento.
    */
    public String toString();
}
