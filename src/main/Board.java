
package main;


public class Board {
    
    protected static final Square[] squares = new Square[100];
    
    public static final void setUpBoard() {
        for(int i = 0; i < 100; i++) {
            squares[i] = new Square(i+1);
        }
        addLadders();
        addChutes();
    }
    
    
    public static final void addLadders() {
        squares[1].setLadder(new Ladder(1, 38));
        squares[4].setLadder(new Ladder(4, 14));
        squares[9].setLadder(new Ladder(9, 31));
        squares[21].setLadder(new Ladder(21, 42));
        squares[28].setLadder(new Ladder(28, 84));
        squares[36].setLadder(new Ladder(36, 43));
        squares[51].setLadder(new Ladder(51, 68));
        squares[71].setLadder(new Ladder(71, 91));
        squares[80].setLadder(new Ladder(80, 100));
        
    }
    
    public static final void addChutes() {
        squares[98].setChute(new Chute(98, 78));
        squares[95].setChute(new Chute(95, 75));
        squares[93].setChute(new Chute(93, 73));
        squares[87].setChute(new Chute(87, 24));
        squares[64].setChute(new Chute(64, 60));
        squares[62].setChute(new Chute(62, 19));
        squares[56].setChute(new Chute(56, 53));
        squares[49].setChute(new Chute(49, 11));
        squares[47].setChute(new Chute(47, 26));
        squares[16].setChute(new Chute(16, 6));
        
        
    }
    
}
