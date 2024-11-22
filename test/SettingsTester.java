import java.util.Arrays;

import main.Settings;

public class SettingsTester {
    public static void main(String[] args) {
        // Test for window size
        System.out.println("Window Size: " + Settings.WINDOW_SIZE);
        
        // Test for board positions
        System.out.println("Board X Position" + Settings.BOARD_X);
        System.out.println("Board Y Position" + Settings.BOARD_Y);
        
        // Test for square and connector size
        System.out.println("Square Size: " + Settings.SQUARE_SIZE);
        System.out.println("Connector Width: " + Settings.CONNECTOR_WIDTH);
        
        // Testing for chutes and ladder locations
        System.out.println("Ladder Locations" + Arrays.deepToString(Settings.LADDER_LOCATIONS));
        System.out.println("Chute Locations" + Arrays.deepToString(Settings.CHUTE_LOCATIONS));
        
        // Test the player panel dimensions 
        System.out.println("Player Panel Width: " + Settings.PLAYER_PANEL_WIDTH); 
        System.out.println("Player Panel Height: " + Settings.PLAYER_PANEL_HEIGHT);
        
        // Test player radius 
        System.out.println("Player Radius: " + Settings.PLAYER_RADIUS);
        
        // Test the player colors 
        System.out.println("Player Colors: " + Arrays.toString(Settings.PLAYER_COLORS));
        
        // Test the board panel color 
        System.out.println("Board Panel Color: " + Settings.BOARD_PANEL_COLOR);
        
        // Test square colors 
        System.out.println("Square Colors: " + Arrays.toString(Settings.SQUARE_COLORS));
        
        // Test chute and ladder colors 
        System.out.println("Chute Color: " + Settings.CHUTE_COLOR); 
        System.out.println("Ladder Color: " + Settings.LADDER_COLOR);
        
        // Test player step delay 
        System.out.println("Player Step Delay: " + Settings.PLAYER_STEP_DELAY);
    }
}