/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_paradigma_orientado_a_objetos;

/**
 *
 * @author emdma
 */
public class Player {
    String name;
    int score;
    CardsSet cards = new CardsSet();
    
    public Player(String n){
        this.name = n;
        this.score = 0;
    }
    
    public void addScore(int s){
        this.score += s;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public void setScore(int s){
        this.score = s;
    }
    
    public void setCards(CardsSet cS){
        this.cards = cS;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public CardsSet getCards(){
        return this.cards;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + this.name + ", Puntaje: " + this.score;
    }
    
    public boolean equals(Player p){
        return getName().equals(p.name);
    }
    
}
