package Main;
import javafx.scene.canvas.GraphicsContext;

public class Triangle extends Line {
    protected Coordinates thirdPoint;
    private Coordinates center;

    Triangle (double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
        thirdPoint = new Coordinates(x1, y1);
        center = new Coordinates(x1, y1);
    }

    @Override

    public void setSecondPoint(double x, double y) {
        super.setSecondPoint(x, y);
        firstPoint.x = x - ( x - center.x );

    }

    @Override
    public void Draw(GraphicsContext gc) {
        gc.strokeLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
        gc.strokeLine(secondPoint.x, secondPoint.y, thirdPoint.x, thirdPoint.y);
        gc.strokeLine(firstPoint.x, firstPoint.y, thirdPoint.x, thirdPoint.y);

    }
}