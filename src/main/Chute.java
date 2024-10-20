
package main;


public class Chute {
    
    private int start;
    private int end;
    
    public Chute(int pos1, int pos2) {
        this.start = pos1;
        this.end = pos2;
    }
    
    public int getTopPosition() {
        return start;
    }
    
    public void setTopPosition(int pos) {
        this.start = pos;
    }
    
    public int getBottomPosition() {
        return end;
    }
    
    public void setBottomPosition(int pos) {
        this.end = pos;
    }
    
    public int slide(int from) {
        return this.end;
    }
    
}
