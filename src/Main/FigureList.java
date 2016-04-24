package Main;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class FigureList {

    private ArrayList<Figure> list;
    private GraphicsContext graphicsContext;

    FigureList(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        list = new ArrayList();
    }

    public ArrayList getList() {
        return list;
    }

    public void removeLastFigure(){
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
    }

    public void replaceLastFigure(Figure newFigure) {
        removeLastFigure();
        list.add(newFigure);
    }

    public void clearList(){
        list.clear();
    }

    public void setList(ArrayList<Figure> list) {
        this.list = list;
    }

    public void add(Figure newFigure){
        list.add(newFigure);
    }

    public void Draw() {
        graphicsContext.clearRect(0, 0, 640, 480);
        for (Figure figure: list
             ) {
            figure.Draw(graphicsContext);
        }
    }
}
