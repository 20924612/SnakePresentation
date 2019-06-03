
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20924612v
 */
public class Snake {

    private List<Node> body;
    private Direction direction;
    private int remainingRow;
    public boolean eatFood;

    public Snake(int numNodes) {
        body = new ArrayList<Node>();
        for (int i = 0; i < numNodes; i++) {
            body.add(new Node(Config.NUM_ROWS / 2, Config.NUM_COLS / 2 - i));
        }
        direction = Direction.RIGHT;
        remainingRow = 0;
        eatFood = false;

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Node> getBody() {
        return body;
    }

    public void paint(Graphics2D g, int squareWidth, int squareHeight) {

        for (Node node : body) {
            Board.drawSquare(g, node.getRow(), node.getCol(), squareWidth, squareHeight, getRandomColor());
        }
    }
    
    public static Color getRandomColor() {

        int nColor = (int) (Math.random() * 9);

        switch (nColor) {

            case 1:
                return Color.BLUE;
            case 2:
                return Color.CYAN;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.MAGENTA;
            case 5:
                return Color.ORANGE;
            case 6:
                return Color.RED;
            case 7:
                return Color.YELLOW;
            default:
                return Color.CYAN;
        }
}

    public void move() {
        Node newNode = new Node(body.get(0).getRow(), body.get(0).getCol()); //head
        switch (direction) {
            case UP:
                newNode.setRow(body.get(0).getRow() - 1);
                body.add(0, newNode);
                break;
            case DOWN:
                newNode.setRow(body.get(0).getRow() + 1);
                body.add(0, newNode);
                break;
            case LEFT:
                newNode.setCol(body.get(0).getCol() - 1);
                body.add(0, newNode);
                break;
            case RIGHT:
                newNode.setCol(body.get(0).getCol() + 1);
                body.add(0, newNode);
                break;
        }
        if (remainingRow == 0) {
            body.remove(body.size() - 1);
        } else {
            remainingRow--;
        }

    }

    public Direction getDirection() {
        return direction;
    }

    public void growSnake(int numNodes) {
        remainingRow = numNodes;
    }

    public boolean eatedFood(Food food) {
        if (body.get(0).getRow() == food.getRandomRow() && body.get(0).getCol() == food.getRandomCol()) {
            return true;
        }
        return false;
    }


}
