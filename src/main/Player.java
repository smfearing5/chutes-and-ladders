
package main;


public class Player {
    
    private int position;
    private String name;
    
    public Player() {
        this.position = 0;
    }
    
    public Player(int playerID, String name) {
        this.name = name;
        this.position = 0;
        
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int pos) {
        this.position = pos; 
    }
}
