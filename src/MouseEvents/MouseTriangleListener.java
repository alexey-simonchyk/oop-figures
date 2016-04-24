package MouseEvents;

import Main.Figure;
import Main.FigureList;
import Main.Triangle;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class MouseTriangleListener extends MouseLineListener {

    public MouseTriangleListener(Canvas canvas, FigureList figureList) {
        super(canvas, figureList);
    }

    @Override
    public Figure createNewFigure(double x1, double y1, double x2, double y2) {
        return new Triangle(x1, y1, x2, y2);
    }

    @Override
    public void handle(MouseEvent event) {
        super.handle(event);
    }
}
