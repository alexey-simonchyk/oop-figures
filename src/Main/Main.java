package Main;


import MouseEvents.MouseCircleListener;
import MouseEvents.MouseLineListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public FigureList figureList;
    public GraphicsContext graphicsContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        Group group = new Group();
        stage.setTitle("Draw Figures");
        Button buttonCircle = addButton("Circle", 10, 10, 80, 20);
        Button buttonLine = addButton("Line", 110, 10, 80, 20);
        Button buttonTriangle = addButton("Triangle", 210, 10, 80, 20);
        Canvas canvas = new Canvas(640, 480);
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(Color.RED);
        figureList = new FigureList(graphicsContext);

        group.getChildren().addAll(canvas, buttonCircle, buttonLine, buttonTriangle);
        Scene scene = new Scene(group, 640, 480);


        stage.setScene(scene);
        stage.show();

        buttonLine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                canvas.addEventHandler(MouseEvent.ANY, new MouseLineListener(canvas, figureList));
            }
        });

        buttonTriangle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        buttonCircle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                canvas.addEventHandler(MouseEvent.ANY, new MouseCircleListener(canvas, figureList));
            }
        });
    }

    public Button addButton(String name, int x, int y, int width, int height){
        Button newButton = new Button(name);
        newButton.setLayoutX(x);
        newButton.setLayoutY(y);
        newButton.setPrefWidth(width);
        newButton.setPrefHeight(height);
        return newButton;
    }

}



