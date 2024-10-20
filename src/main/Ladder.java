
package main;


public class Ladder {
    
    private int start;
    private int end;
    
    public Ladder(int pos1, int pos2) {
        this.start = pos1;
        this.end = pos2;
    }
    
    public int getBottomPosition(){
        return start;
    }
    
    public void setBottomPosition(int pos) {
        this.start = pos;
    }
    
    public int getTopPosition() {
        return end;
    }
    
    public void setTopPosition(int pos) {
        this.end = pos;
    }
    
    public int climb(int from) {
        return this.end;
    }
    
    
    
}
