package MouseEvents;

import Main.Figure;
import Main.FigureList;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public abstract class MouseListener implements EventHandler<MouseEvent> {
    protected boolean isDrawing;
    protected Canvas canvas;
    protected FigureList figureList;

    MouseListener(Canvas canvas, FigureList figureList) {
        this.canvas = canvas;
        this.figureList = figureList;
        isDrawing = false;
    }

    @Override
    public void handle(MouseEvent event) {
    }

    public Figure createNewFigure(double x1, double y1, double x2, double y2) {
        Figure figure = new Figure(0, 0);
        return figure;
    }

    public void mousePressed(MouseEvent event) {
    }
    public void mousedMoved(MouseEvent event) {
    }
}
