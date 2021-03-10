package task1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application  {

    private static final int BOARD_WIDTH = 600;
    private static final int BOARD_HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello JavaFx");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        test(gc);
    }

    private void test(GraphicsContext gc) {
        gc.setFill(Color.YELLOW);
        gc.fillOval(500, 60, 80, 80);
        gc.setFill(Color.GREEN);
        gc.fillRoundRect(210, 220, 200, 200, 10, 10);
        gc.setFill(Color.WHITE);
        gc.fillRoundRect(260, 270, 100, 100, 10, 10);
        gc.setFill(Color.BLUE);
        gc.fillPolygon(new double[]{140, 320, 490}, new double[]{230, 80, 230}, 3);
    }

}