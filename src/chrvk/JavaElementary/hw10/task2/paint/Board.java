package chrvk.JavaElementary.hw10.task2.paint;

import chrvk.JavaElementary.hw10.task2.paint.shapes.CircleShape;
import chrvk.JavaElementary.hw10.task2.paint.shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private final DisplayDriver displayDriver;

    private final List<Shape> shapes = new ArrayList<>();

    public Board(DisplayDriver displayDriver) {
        this.displayDriver = displayDriver;
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            shapes.add(new CircleShape(this, displayDriver,
                    random.nextInt(100), random.nextInt(100)));
        }
    }

    public void drawFrame() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void move() {
        for (Shape shape : shapes) {
            shape.move();
        }
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
