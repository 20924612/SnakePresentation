
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20924612v
 */
public class Food implements ActionListener {

    private Node position;
    private int randomRow;
    private int randomCol;
    private Timer timer;
    private int deltaTime;

    public Food(boolean special, Snake snake, Snake snake2) {
        randomRow = 0;
        randomCol = 0;
        special = false;
        deltaTime = 3000;
        timer = new Timer(deltaTime, this);
        timer.start();
    }

    public void generatePosition(Snake snake, Snake snake2, Wall wall) {
        boolean collision = true;

        while (collision) {
            randomRow = (int) (Math.random() * Config.NUM_ROWS);
            randomCol = (int) (Math.random() * Config.NUM_COLS);
            collision = false;
            for (Node node : snake.getBody()) {
                if (node.getRow() == randomRow && node.getCol() == randomCol) {
                    collision = true;
                    break;
                }
            }
            for(Node node : wall.list){
                if(randomRow == node.getRow() && randomCol == node.getCol()){
                    collision = true;
                }
            }
}
    }

    public void paint(Graphics2D g, int squareWidth, int squareHeight) {
        Board.drawSquare(g, randomRow, randomCol, squareWidth, squareHeight, Color.GREEN);
    }

    public int getRandomRow() {
        return randomRow;
    }

    public void setRandomRow(int randomRow) {
        this.randomRow = randomRow;
    }

    public int getRandomCol() {
        return randomCol;
    }

    public void setRandomCol(int randomCol) {
        this.randomCol = randomCol;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}
