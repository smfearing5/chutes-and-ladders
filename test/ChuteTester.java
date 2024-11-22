import main.Chute;
import main.Square;

public class ChuteTester {
    public static void main(String[] args) {
        //
        Square startSquare = new Square(0, 50, 100);
        Square endSquare = new Square(100, 50, 0);
        
        // Makes a new Chute object to test
        Chute chute = new Chute(startSquare, endSquare);
        
        // This test the getStartSquare and getEndSquare
        assert chute.getStartSquare() == startSquare : "getStartSquare() failed";
        assert chute.getEndSquare() == endSquare : "getEndSquare() failed";
        
        Square newStartSquare = new Square(200, 200, 50);
        Square newEndSquare = new Square(300, 300, 50);
        chute.setStartSquare(newStartSquare);
        chute.setEndSquare(newEndSquare);
        
        //
        assert chute.getStartSquare() == newStartSquare : "setStartSquare() failed";
        assert chute.getEndSquare() == newEndSquare : "setEndSquare() failed";
        //
        System.out.println("All tests passed!");
    }
    
}
