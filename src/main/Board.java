package main;

public class Board {
    // Constants
    private final Square[] SQUARES = new Square[100];
    // Instance Variables
    private int x;
    private int y;
    // Constructor
    public Board(int xPos, int yPos) {
        x = xPos;
        y = yPos;
        int row = 9;
        int col = 0;
        for(int i = 0; i < 100; i++) {
            SQUARES[i] = new Square(i+1, row, col);
            if ((i+1) % 10 == 0) {
                row -= 1;
            }
            else {
                if (row % 2 == 1) {
                    col += 1;
                }
                else {
                    col -= 1;
                }
            }
        }
        addLadders();
        addChutes();
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public Square getSquare(int squareID) {
        return SQUARES[squareID - 1];
    }

    private final void addLadders() {
        getSquare(1).setLadder(new Ladder(1, 38));
        getSquare(4).setLadder(new Ladder(4, 14));
        getSquare(9).setLadder(new Ladder(9, 31));
        getSquare(21).setLadder(new Ladder(21, 42));
        getSquare(28).setLadder(new Ladder(28, 84));
        getSquare(36).setLadder(new Ladder(36, 43));
        getSquare(51).setLadder(new Ladder(51, 68));
        getSquare(71).setLadder(new Ladder(71, 91));
        getSquare(80).setLadder(new Ladder(80, 100));
    }
    
    private final void addChutes() {
        getSquare(98).setChute(new Chute(98, 78));
        getSquare(95).setChute(new Chute(95, 75));
        getSquare(93).setChute(new Chute(93, 73));
        getSquare(87).setChute(new Chute(87, 24));
        getSquare(64).setChute(new Chute(64, 60));
        getSquare(62).setChute(new Chute(62, 19));
        getSquare(56).setChute(new Chute(56, 53));
        getSquare(49).setChute(new Chute(49, 11));
        getSquare(47).setChute(new Chute(47, 26));
        getSquare(16).setChute(new Chute(16, 6));   
    }
}
