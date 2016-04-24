package Main;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public class Figure implements Serializable{
    protected Coordinates firstPoint;
    public Figure(double x, double y) {
        firstPoint = new Coordinates(x, y);
    }

    public void setSecondPoint(double x, double y) {}

    public void Draw(GraphicsContext gc){

    }
}
