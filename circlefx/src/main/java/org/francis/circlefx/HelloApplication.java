package org.francis.circlefx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Circle c = new Circle(100, 100, 10, Color.RED);
    private int clickedCounter = 0;
    private int radiusChange = 1;
    EventHandler<MouseEvent> handleMouseDrag = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
            c.setCenterX(t.getX());
            c.setCenterY(t.getY());
            t.consume();
        }
    };

    EventHandler<MouseEvent> handleMouseClick = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
            clickedCounter++;
            if(clickedCounter % 3 == 0){
                c.setFill(Color.RED);
            } else if(clickedCounter % 3 == 1) {
                c.setFill(Color.YELLOW);
            } else {
                c.setFill(Color.GREEN);
            }
        }
    };
    EventHandler<MouseEvent> handleBackGroundDrag = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {

            if(c.getRadius() > 100){
                radiusChange = -1;
            }
            if(c.getRadius() < 10){
                radiusChange = 1;
            }
            c.setRadius(c.getRadius() + radiusChange);
        }
    };

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello World!");
        primaryStage.setFullScreen(true);
        c.setOnMouseDragged(handleMouseDrag);
        c.setOnMouseClicked(handleMouseClick);
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setOnMouseDragged(handleBackGroundDrag);
        root.getChildren().add(c);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}