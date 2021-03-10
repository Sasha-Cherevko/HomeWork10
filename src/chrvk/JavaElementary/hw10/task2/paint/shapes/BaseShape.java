package chrvk.JavaElementary.hw10.task2.paint.shapes;

import chrvk.JavaElementary.hw10.task2.paint.Board;
import chrvk.JavaElementary.hw10.task2.paint.DisplayDriver;

import java.util.Random;

public abstract class BaseShape implements Shape {
    protected double size = 50;
    protected Board board;
    protected DisplayDriver displayDriver;
    protected double x;
    protected double y;
    protected double xSpeed;
    protected double ySpeed;

    public BaseShape(Board board, DisplayDriver displayDriver, int x, int y) {
        this.board = board;
        this.displayDriver = displayDriver;
        this.x = x;
        this.y = y;
        Random random = new Random();
        xSpeed = random.nextInt(2) + 3;
        ySpeed = random.nextInt(2) + 2;
    }

    @Override
    public void move() {
        calculateCollisions();

        if (x <= 0) {
            xSpeed = Math.abs(xSpeed);
        } else if (x + size >= displayDriver.getWidth()) {
            xSpeed = -Math.abs(xSpeed);
        }
        if (y <= 0) {
            ySpeed = Math.abs(ySpeed);
        } else if (y + size >= displayDriver.getHeight()) {
            ySpeed = -Math.abs(ySpeed);
        }

        x += xSpeed;
        y += ySpeed;
    }

    private boolean calculateCollisions() {
        for (Shape shape : board.getShapes()) {
            if (shape == this) {
                continue;
            }
            if (getDistance(shape.getX(), shape.getY()) < size) {
                if (x < shape.getX()) {
                    xSpeed = -Math.abs(xSpeed);
                } else {
                    xSpeed = Math.abs(xSpeed);
                }
                if (y < shape.getY()) {
                    ySpeed = -Math.abs(ySpeed);
                } else {
                    ySpeed = Math.abs(ySpeed);
                }
                return true;
            }
        }
        return false;
    }

    private double getDistance(double otherX, double otherY) {
        return Math.hypot(otherX - x, otherY - y);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }
}
