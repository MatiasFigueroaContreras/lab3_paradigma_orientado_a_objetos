/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

/**
 *
 * @author emdma
 */
public interface IDobbleGame {
    public void start();
    public boolean play(String option);
    public boolean play(String option, String[] data);
    public void finish();
    public void register(String name);
    public String whoseTurnIsIt();
    public int getScore(String name);
    public String getNameMode();
    public String getVersionMode();
    public String getStatus();
    public String toString();
}
