package chrvk.JavaElementary.hw10.task2;

import chrvk.JavaElementary.hw10.task2.paint.Board;
import chrvk.JavaElementary.hw10.task2.paint.DisplayDriver;
import chrvk.JavaElementary.hw10.task2.platform.DisplayDriverImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 500;
    private static final int FPS = 60;

    private boolean closed;
    private GraphicsContext gc;

    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        closed = true;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFxSample");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        gc = canvas.getGraphicsContext2D();
        new Thread(this::runMainGameLoopInThread).start();

        DisplayDriver displayDriver = new DisplayDriverImpl(gc);
        board = new Board(displayDriver);
    }

    private void runMainGameLoopInThread() {
        while (!closed) {
            Platform.runLater(this::drawFrame);
            try {
                int pauseBetweenFramesMillis = 1000 / FPS;
                Thread.sleep(pauseBetweenFramesMillis);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void drawFrame() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        board.drawFrame();
        board.move();
    }
}
