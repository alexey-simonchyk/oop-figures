package Data.Figures;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Line {
    public Rectangle(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void Draw(GraphicsContext gc) {
        gc.strokeRect(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
    }
}
