
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20924612v
 */
public class SpecialFood extends Food {

    private int visibleMilliseconds;
    public static final int MAX_MILLISECONDS = 10000;
    public static final int MIN_MILLISECONDS = 3000;

    public SpecialFood(boolean special, Snake snake) {
        super(true, snake);
        special = true;
        visibleMilliseconds = (int) (Math.random() * (MAX_MILLISECONDS - MIN_MILLISECONDS)
                + MIN_MILLISECONDS);
    }
    
    public int getVisibleTime(){
        return visibleMilliseconds;
    }
    @Override
    public void paint(Graphics2D g, int squareWidth, int squareHeight) {
        Board.drawSquare(g, getRandomRow(), getRandomCol(), squareWidth, squareHeight, Color.RED);
    }

}
