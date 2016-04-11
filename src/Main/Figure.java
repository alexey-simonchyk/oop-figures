package Main;

import javafx.scene.canvas.GraphicsContext;

public class Figure{
    protected Coordinates firstPoint;
    public Figure(double x, double y) {
        firstPoint = new Coordinates(x, y);
    }

    public void setSecondPoint(double x, double y) {}

    public void Draw(GraphicsContext gc){

    }
}
