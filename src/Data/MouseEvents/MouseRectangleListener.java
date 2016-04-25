package Data.MouseEvents;

import Data.Figures.Rectangle;
import Data.Figures.Figure;

public class MouseRectangleListener extends MouseLineListener {

    public MouseRectangleListener() { super(); }

    @Override
    public Figure createNewFigure(double x1, double y1, double x2, double y2) {
        return new Rectangle(x1, y1, x2, y2);
    }

}
