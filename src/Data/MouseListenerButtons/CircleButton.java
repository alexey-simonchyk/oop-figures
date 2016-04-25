package Data.MouseListenerButtons;

import Data.MLButton;
import Main.Main;
import Data.MouseEvents.MouseCircleListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CircleButton extends MLButton {

    public CircleButton() {
        name = "Circle";
    }

    @Override
    public void setAction(Button button, Main main) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.removeLastEventHandler();
                MouseCircleListener temp = new MouseCircleListener();
                main.setDrawItems(temp);
                main.setEventHandler(temp);
            }
        });
    }
}
