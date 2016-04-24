package Data.Figures;
import javafx.scene.canvas.GraphicsContext;

public class Circle extends Figure {
    protected double radius;
    public Circle(double x1, double y1, double x2, double y2){
        super(x1, y1);
        setSecondPoint(x2, y2);
    }

    @Override
    public void setSecondPoint(double x1, double y1) {
        radius = Math.sqrt(Math.pow((x1 - firstPoint.x), 2) + Math.pow((y1 - firstPoint.y), 2));
    }

    @Override
    public void Draw(GraphicsContext gc){
        gc.strokeOval(firstPoint.x, firstPoint.y, radius, radius);
    }
}