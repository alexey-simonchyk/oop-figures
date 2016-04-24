package MouseListenerButtons;

import Main.Main;
import MouseEvents.MouseTriangleListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class TriangleButton extends MLButton {
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
