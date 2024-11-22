import main.Board;
import main.Settings;
import main.Square;

public class BoardTester {
    public static void main(String[] args) {
        // This us for testing the initial starting point
        Board board = new Board(0, 0);
        
        System.out.println("Board Position : (" + board.getX() + ", " + board.getY() + ")");
        
        // This test the squares
        Square startSquare = board.getSquare(0);
        Square tenthSquare = board.getSquare(10);
        System.out.println("Start Square Position : (" + startSquare.getX() + ", " + startSquare.getY() + ")");
        System.out.println("10th Square Position : (" + tenthSquare.getX() + ", " + tenthSquare.getY() + ")");
        
        // This is for testing the Chutes and Ladders
        for (int[] positions : Settings.CHUTE_LOCATIONS){
            Square startChute = board.getSquare(positions[0]);
            Square endChute = board.getSquare(positions[1]);
            System.out.println("Chute from square " + positions[0] + " to " + positions[1] + ": " + (startChute.getChute().getEndSquare() == endChute));
        }
        for (int[] positions : Settings.LADDER_LOCATIONS){
            Square startLadder = board.getSquare(positions[0]);
            Square endLadder = board.getSquare(positions[1]);
            System.out.println("Ladder from square " + positions[0] + " to " + positions[1] + ": " + (startLadder.getLadder().getEndSquare() == endLadder));
        }
    }
    
}
