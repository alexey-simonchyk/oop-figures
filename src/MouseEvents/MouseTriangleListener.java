package MouseEvents;

import Main.FigureList;
import javafx.scene.input.MouseEvent;

import javafx.scene.canvas.Canvas;

public class MouseTriangleListener extends MouseListener {

    MouseTriangleListener(Canvas canvas, FigureList figureList) {
        super(canvas, figureList);
    }

    @Override
    public void handle(MouseEvent event) {

    }
}
