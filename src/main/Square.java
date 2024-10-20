
package main;


public class Square {
    
    private int id;
    private Ladder ladder;
    private Chute chute;
    
    
    public Square() {
        this.id = 0;
        this.ladder = null;
        this.chute = null;
    }
    
    public Square(int id){
        this.id = id;
        this.ladder = null;
        this.chute = null;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Ladder getLadder() {
        return ladder;
    }
    
    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
    
    public Chute getChute() {
        return chute;
    }
    
    public void setChute(Chute chute) {
        this.chute = chute;
    }
    
    
}
