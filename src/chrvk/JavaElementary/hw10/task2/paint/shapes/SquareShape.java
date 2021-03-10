package chrvk.JavaElementary.hw10.task2.paint.shapes;

import chrvk.JavaElementary.hw10.task2.paint.Board;
import chrvk.JavaElementary.hw10.task2.paint.DisplayDriver;

public class SquareShape extends BaseShape implements Shape {
    public SquareShape(Board board, DisplayDriver displayDriver, int x, int y) {
        super(board, displayDriver, x, y);
    }

    @Override
    public void draw() {
        displayDriver.setColor("#0f0");
        displayDriver.drawSquare(x, y, size);
    }
}
