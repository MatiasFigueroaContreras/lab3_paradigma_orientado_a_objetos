/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author emdma
 */
public interface Mode {
    public void start(DobbleGame dG);
    public void pass(DobbleGame dG);
    public void setCardsInPlay(DobbleGame dG);
    public String getModeName();
}
