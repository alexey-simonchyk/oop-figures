package Data.MouseListenerButtons;

import Data.MLButton;
import Main.Main;
import Data.MouseEvents.MouseRectangleListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RectangleButton extends MLButton {
	public	RectangleButton () {
		name = "Rectangle";
	}

	public void setAction (Button button, Main main) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				main.removeLastEventHandler();
                MouseRectangleListener temp = new MouseRectangleListener();
                main.setDrawItems(temp);
                main.setEventHandler(temp);
			}
		});
	}
}