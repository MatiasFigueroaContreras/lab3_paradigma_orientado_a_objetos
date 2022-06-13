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
public class PlayersGameControl {
    public int maxPlayers;
    public int playerTurn;
    public ArrayList<Player> players = new ArrayList<>();
    
    public PlayersGameControl(int mP){
        if(mP >= 1){
            this.maxPlayers = mP;
            this.playerTurn = 1;
        }
    }
    
    public int getTotalPlayers(){
        return this.players.size();
    }
    
    public void addScoreCurrentPlayerTurn(int score){
        nthPlayer(this.playerTurn).addScore(score);
    }
    
    public void addCardsCurrentPlayerTurn(CardsSet cards){
        nthPlayer(this.playerTurn).setCards(cards);
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
        if(this.playerTurn >= players.size()){
            this.playerTurn = 1;
        }
        else{
            this.playerTurn++;
        }
    }
    
    private int highestScore(){
        int h = nthPlayer(1).score;
        for(int i = 2; i <= getTotalPlayers(); i++){
            int nScore = nthPlayer(i).score;
            if(h < nScore){
                h = nScore;
            }
        }
        
        return h;
    }
    
    public ArrayList<String> getWinners(){
        int h = highestScore();
        ArrayList<String> winners = new ArrayList<>();
        for(int i = 1; i <= getTotalPlayers(); i++){
            Player nPlayer = nthPlayer(i);
            if(h == nPlayer.score){
                winners.add(nPlayer.name);
            }
        }
        return winners;
    }
    
    public ArrayList<String> getLosers(){
        int h = highestScore();
        ArrayList<String> losers = new ArrayList<>();
        for(int i = 1; i <= getTotalPlayers(); i++){
            Player nPlayer = nthPlayer(i);
            if(h > nPlayer.score){
                losers.add(nPlayer.name);
            }
        }
        return losers;
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == getClass()){
            PlayersGameControl pGC = (PlayersGameControl)o;
            return (this.maxPlayers == pGC.maxPlayers) && (this.playerTurn == pGC.playerTurn) && this.players.equals(pGC);
        }
        return false;
    }
    
    @Override
    public String toString(){
        String str = "";
        for(int i = 1; i <= getTotalPlayers(); i++){
            String n = Integer.toString(i) + ": ";
            str += "Player n" + n + nthPlayer(i).toString() + "\n";
        }
        return str;
    }
}
