package Data.MouseListenerButtons;

import Data.MLButton;
import Data.MouseEvents.MouseTriangleListener;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class TriangleButton extends MLButton {

    public TriangleButton() {
        name = "Triangle";
    }

    @Override
    public void setAction(Button button, Main main) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.removeLastEventHandler();
                MouseTriangleListener temp = new MouseTriangleListener();
                main.setDrawItems(temp);
                main.setEventHandler(temp);
            }
        });
    }
}
