
package main;

import java.util.Random;


public class Dice {
    
    public static final int roll() {
        Random random = new Random();
        int diceNum = random.nextInt(6);
        return diceNum + 1;
    }
    
}
