package geometrical_shapes;

import java.awt.Color;

import jart.Displayable;
import jart.Drawable;

public class Line implements Drawable {

    final private Point start, end;
    final private Color color;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.color = Color.black;
    }

    @Override
    public void draw(Displayable displayable) {
        int x0 = start.getX();
        int y0 = start.getY();
        int x1 = end.getX();
        int y1 = end.getY();

        boolean steep = Math.abs(y1 - y0) > Math.abs(x1 - x0);

        if (steep) {
            // Swap X and Y
            int tmp;
            tmp = x0;
            x0 = y0;
            y0 = tmp;
            tmp = x1;
            x1 = y1;
            y1 = tmp;
        }

        if (x0 > x1) {
            // Swap start and end points
            int tmp;
            tmp = x0;
            x0 = x1;
            x1 = tmp;
            tmp = y0;
            y0 = y1;
            y1 = tmp;
        }

        int dX = x1 - x0;
        int dY = Math.abs(y1 - y0);
        int error = dX / 2;
        int yStep = (y0 < y1) ? 1 : -1;
        int y = y0;

        for (int x = x0; x <= x1; x++) {
            if (steep) {
                displayable.display(y, x, color); // swapped back
            } else {
                displayable.display(x, y, color);
            }

            error -= dY;
            if (error < 0) {
                y += yStep;
                error += dX;
            }
        }
    }

    public static Line random(Integer width, Integer height) {
        return new Line(Point.random(width, height), Point.random(width, height));
    }
    

    @Override
    public Color getColor() {
        return color;
    }
}
