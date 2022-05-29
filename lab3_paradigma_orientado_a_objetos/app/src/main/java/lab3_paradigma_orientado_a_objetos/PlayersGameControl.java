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
public class PlayersGameControl {
    int maxPlayers;
    int playerTurn;
    ArrayList<Player> players = new ArrayList<>();
    
    public PlayersGameControl(int mP){
        if(mP >= 1){
            this.maxPlayers = mP;
            this.playerTurn = 1;
        }
    }
    
    public int getTotalPlayers(){
        return this.players.size();
    }
    
    public void addPlayer(Player p){
        if(getTotalPlayers() < this.maxPlayers && !contains(p)){
            this.players.add(p);
        }
    }
    
    public Player nthPlayer(int n){
        return this.players.get(n-1);
    }
    
    public boolean contains(Player p){
        for(int i = 1; i <= getTotalPlayers(); i++){
            if(p.equals(nthPlayer(i))){
                return true;
            }
        }
        return false;
    }
    
    public Player getPlayer(String s){
        Player p = new Player(s);
        Player pi;
        for(int i = 1; i <= getTotalPlayers(); i++){
            pi = nthPlayer(i);
            if(p.equals(pi)){
                return pi;
            }
        }
        return null;
    }
    
    public void nextTurn(){
        this.playerTurn++;
    }
}
