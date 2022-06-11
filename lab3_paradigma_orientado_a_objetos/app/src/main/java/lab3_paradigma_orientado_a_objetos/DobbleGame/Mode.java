/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos.DobbleGame;

/**
 *
 * @author emdma
 */
public interface Mode {
    public String[] playsOptions(DobbleGame dGame);
    public String play(DobbleGame dGame, String option);
    public String play(DobbleGame dGame, String option, String[] data);
    public String start(DobbleGame dG);
    public String getVersionModeName();
    public String getModeName();
    public String extraDataNeeded(String status, String option);
    public int numExtraDataNeeded(DobbleGame dGame);
    public int getMaxPlayers();
    public int getMinPlayers();
}
