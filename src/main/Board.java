package main;

/**
 * This is a class for the Board object.
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class Board {

    // Constants

    private final Square[] SQUARES = new Square[101];

    // Instance Variables

    private int x;
    private int y;

    // Private Methods
    
    private final void addChutesAndLadders() {
        Square startSquare;
        Square endSquare;

        Chute chute;
        for (int[] positions : Settings.CHUTE_LOCATIONS) {
            startSquare = SQUARES[positions[0]];
            endSquare = SQUARES[positions[1]];
            chute = new Chute(startSquare, endSquare);
            startSquare.setChute(chute);
        }

        Ladder ladder;
        for (int[] positions : Settings.LADDER_LOCATIONS) {
            startSquare = SQUARES[positions[0]];
            endSquare = SQUARES[positions[1]];
            ladder = new Ladder(startSquare, endSquare);
            startSquare.setLadder(ladder);
        }
    }

    private final int squareX(int col) {
        return x + (col * Settings.SQUARE_SIZE);
    }

    private final int squareY(int row) {
        return y + (row * Settings.SQUARE_SIZE);
    }

    /* Public Interface */

    // Constructor

    /**
     * Constructor for the Board object
     * @param xPos int for x position
     * @param yPos int for y position
     */
    public Board(int xPos, int yPos) {
        this.x = xPos;
        this.y = yPos;
        
        // Player Start Square
        SQUARES[0] = new Square(0, squareX(-1), squareY(9));

        // Visible Board Squares
        int row = 9;
        int col = 0;
        for(int i = 1; i <= 100; i++) {
            SQUARES[i] = new Square(i, squareX(col), squareY(row));
            if ((i) % 10 == 0) {
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
        addChutesAndLadders();
    }

    // Accessors

    /**
     * Returns the x position of the Board
     * @return int for x position
     */
    public int getX() {return x;}

    /**
     * Returns the y position of the Board
     * @return int for y position
     */
    public int getY() {return y;}

    /**
     * Returns a Square object using its ID number
     * @param squareID int for the ID number of the Square
     * @return The Square object
     */
    public Square getSquare(int squareID) {
        return SQUARES[squareID];
    }
}
