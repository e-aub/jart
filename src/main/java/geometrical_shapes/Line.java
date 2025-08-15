package geometrical_shapes;

import geometrical_shapes.Point;
import jart.Displayable;
import jart.Drawable;

import java.awt.*;

public class Line implements Drawable {
    private Point start;
    private Point end;
    final private Color color;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.color = Color.red;
    }

    @Override
    public void draw(Displayable displayable) {
//        displayable.display();
        Integer x0 = start.getX();
        Integer y0 = start.getY();
        Integer x1 = end.getX();
        Integer y1 = end.getY();
        Integer dX =  x1 - x0;
        Integer dY = y1 - y0;
        Integer y = y0;
        Integer p = 2*dY - dX;


        for (int i = 0; i <= dX + 1; i++) {
            displayable.display(x0 + i, y, color);

            if (p >= 0){
                y+=1;
                p = p - (2 * dX);
            }else{
                p = p + 2 * dY;
            }
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}