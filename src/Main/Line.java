package Main;
import javafx.scene.canvas.GraphicsContext;

public class Line extends Figure {
    protected Coordinates secondPoint;

    public Line(double x1, double y1, double x2, double y2) {
        super(x1, y1);
        secondPoint = new Coordinates(x2, y2);
    }

    @Override
    public void setSecondPoint(double x, double y) {
        secondPoint.x = x;
        secondPoint.y = y;
    }

    @Override
    public void Draw(GraphicsContext gc){
        gc.strokeLine(firstPoint.x, firstPoint.y , secondPoint.x, secondPoint.y);
    }
}