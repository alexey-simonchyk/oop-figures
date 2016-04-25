package Data.MouseListenerButtons;

import Data.MLButton;
import Main.Main;
import Data.MouseEvents.MouseLineListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LineButton extends MLButton {

    public LineButton() {
        name = "Line";
    }

    @Override
    public void setAction(Button button, Main main) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.removeLastEventHandler();
                MouseLineListener temp = new MouseLineListener();
                main.setDrawItems(temp);
                main.setEventHandler(temp);
            }
        });
    }
}
