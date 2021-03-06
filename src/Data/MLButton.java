package Data;


import javafx.scene.control.Button;
import Main.Main;

public abstract class MLButton {

    protected String name;

    public String getNameFigure() { return name; }

    public Button getButton(String name, int x, int y, int width, int height, Main main) {
        Button newButton = new Button(name);
        newButton.setLayoutX(x);
        newButton.setLayoutY(y);
        newButton.setPrefWidth(width);
        newButton.setPrefHeight(height);
        setAction(newButton, main);
        return newButton;
    }

    public void setAction(Button button, Main main) {
    }
}
