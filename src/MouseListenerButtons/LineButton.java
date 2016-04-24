package MouseListenerButtons;

import Main.Main;
import MouseEvents.MouseLineListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LineButton extends MLButton {

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
