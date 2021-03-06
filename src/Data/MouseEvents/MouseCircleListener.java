package Data.MouseEvents;

import Data.Figures.Circle;
import Data.Figures.Figure;
import Data.FigureList;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class MouseCircleListener extends MouseLineListener {

    public MouseCircleListener() {
        super();
    }

    @Override
    public void setItems (Canvas canvas, FigureList figureList) {
        super.setItems(canvas, figureList);
    }

    @Override
    public Figure createNewFigure(double x1, double y1, double x2, double y2) {
        return new Circle(x1, y1, x2, y2);
    }

    @Override
    public void handle(MouseEvent event) {
        super.handle(event);
    }
}
