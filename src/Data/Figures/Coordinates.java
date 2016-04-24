package Data.Figures;

import java.io.Serializable;

public class Coordinates implements Serializable {
    double x;
    double y;
    Coordinates(double newX, double newY){
        x = newX;
        y = newY;
    }
}