import javax.swing.JFrame;

import main.Board;
import main.Player;
import main.Settings;
import graphics.BoardComponent;

public class BoardComponentTester {
    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player(1, "test player 1");
        players[1] = new Player(2, "test player 2");

        Board board = new Board(10, 10);
        BoardComponent boardImage = new BoardComponent(board, players);

        // Test getSquare method
        players[0].setLocation(board.getSquare(55).getCenter());;
        players[1].setLocation(board.getSquare(37).getCenter());;

        // Test getX and getY methods
        System.out.println("Board Position:");
        System.out.println("x: " + board.getX());
        System.out.println("y: " + board.getY());
        System.out.println();

        // Test BoardComponent
        JFrame frame = new JFrame();
        frame.setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        frame.setTitle("Board Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(boardImage);
        frame.setVisible(true);
    }
}
