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
    private Circle c = null;
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
        c = new Circle(100, 100, 10, Color.RED);
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

        Kreis k1 = new Kreis(-1, 11, 100, 0.2f);
        k1.setRadius(10);

        Kreis k2 = new Kreis(10, 1, 150, 1.2f);
        k2.setRadius(120);

        Kreis k3 = k1;
        k3.setRadius(30);

        int r1 = k3.getRadius();

        double ar1 = k1.area();


        System.out.println(ar1);

        //launch();
    }
}


class Kreis{
    private int radius;
    private int xPosition;
    private int yPosition;
    private float thickness;

    private final double pi = 3.14;
    public double area() {
        return pi*Math.pow(radius, 2);
    }



    public Kreis(int r, int x, int y , float t ){
        radius = r;
        xPosition = x;
        yPosition = y;
        thickness = t;
    }

    public void setRadius(int r){
        this.radius = r;
    }

    public int getRadius(){
        return radius;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }
}

