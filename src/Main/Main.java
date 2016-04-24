package Main;


import MouseEvents.MouseCircleListener;
import MouseEvents.MouseLineListener;
import MouseEvents.MouseTriangleListener;
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
import javafx.stage.WindowEvent;

public class Main extends Application {

    public FigureList figureList;
    public GraphicsContext graphicsContext;
    private EventHandler lastEventHandler;
    private InformationFile file;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        file = new InformationFile();
        file.checkExsistFile();
        lastEventHandler = null;
        Group group = new Group();
        stage.setTitle("Draw Figures");
        Button buttonCircle = addButton("Circle", 10, 10, 80, 20);
        Button buttonLine = addButton("Line", 110, 10, 80, 20);
        Button buttonTriangle = addButton("Triangle", 210, 10, 80, 20);
        Button buttonClear = addButton("Clear", 310, 10, 80, 20);
        Button buttonUndo = addButton("Undo", 410, 10, 80, 20);
        Canvas canvas = new Canvas(640, 480);
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(Color.RED);
        figureList = new FigureList(graphicsContext);
        file.read(figureList);
        figureList.Draw();

        group.getChildren().addAll(canvas, buttonCircle, buttonLine, buttonTriangle, buttonClear, buttonUndo);
        Scene scene = new Scene(group, 640, 480);


        stage.setScene(scene);
        stage.show();

        buttonLine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (lastEventHandler != null)
                    canvas.removeEventHandler(MouseEvent.ANY, lastEventHandler);
                lastEventHandler = new MouseLineListener(canvas, figureList);
                canvas.addEventHandler(MouseEvent.ANY, lastEventHandler);
            }
        });

        buttonClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                figureList.clearList();
                figureList.Draw();
                file.write(figureList);
            }
        });

        buttonUndo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                figureList.removeLastFigure();
                figureList.Draw();
                file.write(figureList);

            }
        });

        buttonTriangle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (lastEventHandler != null)
                    canvas.removeEventHandler(MouseEvent.ANY, lastEventHandler);
                lastEventHandler = new MouseTriangleListener(canvas, figureList);
                canvas.addEventHandler(MouseEvent.ANY, lastEventHandler);
            }
        });

        buttonCircle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (lastEventHandler != null)
                    canvas.removeEventHandler(MouseEvent.ANY, lastEventHandler);
                lastEventHandler = new MouseCircleListener(canvas, figureList);
                canvas.addEventHandler(MouseEvent.ANY, lastEventHandler);
            }
        });

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                file.write(figureList);
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



