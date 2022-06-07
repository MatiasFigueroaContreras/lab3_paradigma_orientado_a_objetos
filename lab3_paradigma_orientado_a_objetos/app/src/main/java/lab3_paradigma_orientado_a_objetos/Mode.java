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
    public String playsOptionMenu(String status);
    public String playOption(DobbleGame dGame, int option);
    public String playOption(DobbleGame dGame, int option, String[] data);
    public String start(DobbleGame dG);
    public String getVersionModeName();
    public String getModeName();
    public String extraDataNeded(String status, int option);
    public int numExtraDataNeded(DobbleGame dGame);
    public int getMaxPlayers();
    public int getMinPlayers();
}
