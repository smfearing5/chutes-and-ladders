import main.Ladder;
import main.Square;


//Note that this tester is pretty much the same as the Chute tester.

public class LadderTester {
    public static void main(String[] args) {
        //
        Square startSquare = new Square(0, 50, 100);
        Square endSquare = new Square(100, 50, 0);
        
        // Makes a new Ladder object to test
        Ladder ladder = new Ladder(startSquare, endSquare);
        
        // This test the getStartSquare and getEndSquare
        assert ladder.getStartSquare() == startSquare : "getStartSquare() failed";
        assert ladder.getEndSquare() == endSquare : "getEndSquare() failed";
        
        Square newStartSquare = new Square(200, 200, 50);
        Square newEndSquare = new Square(300, 300, 50);
        ladder.setStartSquare(newStartSquare);
        ladder.setEndSquare(newEndSquare);
        
        //
        assert ladder.getStartSquare() == newStartSquare : "setStartSquare() failed";
        assert ladder.getEndSquare() == newEndSquare : "setEndSquare() failed";
        //
        System.out.println("All tests passed!");
    }
    
}
