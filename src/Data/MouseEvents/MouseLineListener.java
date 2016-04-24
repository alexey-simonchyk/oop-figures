package Data.MouseEvents;

import Data.Figures.Figure;
import Data.FigureList;
import Data.Figures.Line;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseLineListener extends MouseListener {

    protected Figure figure;

    public MouseLineListener() {
        super();
    }

    @Override
    public void setItems (Canvas canvas, FigureList figureList) {
        super.setItems(canvas, figureList);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (isDrawing) {

                isDrawing = false;
            } else {
                figure = createNewFigure(event.getX(), event.getY(), event.getX(), event.getY());
                figureList.add(figure);
                isDrawing = true;
            }
        } else {
            if (event.getButton() == MouseButton.SECONDARY) {
                if (isDrawing) {
                    figureList.removeLastFigure();
                }
                isDrawing = false;
            }
        }
    }

    @Override
    public Figure createNewFigure(double x1, double y1, double x2, double y2) {
        return new Line(x1, y1, x2, y2);
    }

    @Override
    public void mousedMoved(MouseEvent event) {
        if (isDrawing) {
            figure.setSecondPoint(event.getX(), event.getY());
            figureList.replaceLastFigure(figure);
            figureList.Draw();
        }
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED || event.getEventType() == MouseEvent.MOUSE_RELEASED)
            mousePressed(event);
        else
            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED)
                mousedMoved(event);

    }
}
