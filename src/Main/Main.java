package Main;


import Data.ClassList;
import Data.FigureList;
import Data.InformationFile;
import Data.MouseEvents.MouseListener;
import Data.MLButton;
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
    private Canvas canvas;

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
        Button buttonClear = addButton("Clear", 310, 10, 80, 20);
        Button buttonUndo = addButton("Undo", 410, 10, 80, 20);
        canvas = new Canvas(640, 480);
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(Color.RED);
        figureList = new FigureList(graphicsContext);
        file.read(figureList);
        figureList.Draw();

        group.getChildren().addAll(canvas, buttonClear, buttonUndo);
        getFigures(group);

        Scene scene = new Scene(group, 640, 480);


        stage.setScene(scene);
        stage.show();


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


    public void removeLastEventHandler () {
        if (lastEventHandler != null)
            canvas.removeEventHandler(MouseEvent.ANY, lastEventHandler);
    }

    public void setDrawItems(MouseListener mouseListener) {
        mouseListener.setItems(canvas, figureList);
    }

    public void setEventHandler (EventHandler eventHandler) {
        lastEventHandler = eventHandler;
        canvas.addEventHandler(MouseEvent.ANY, lastEventHandler);
    }

    private void getFigures(Group group) {
        int posX = 10;
        String[] figures = new ClassList().getFilesList();
        for (String temp: figures) {
            try {
                if (!temp.contains("$")) {
                    String className = new String(temp.split(".class")[0]);
                    Class tempClass = Class.forName("Data.MouseListenerButtons." + className);
                    MLButton button = (MLButton) tempClass.newInstance();
                    group.getChildren().add(button.getButton(className, posX, 10, 80, 20, this));
                    posX += 100;
                }
            }
            catch (InstantiationException e) {
                System.out.println(e);
            }
            catch (IllegalAccessException e) {
                System.out.println(e);
            }
            catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }

}



