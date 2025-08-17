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
        this.color = Color.white;
    }

    public Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    @Override
    public void draw(Displayable displayable) {
        int x0 = start.getX();
        int y0 = start.getY();
        int x1 = end.getX();
        int y1 = end.getY();

        int dx = x1 - x0;
        int dy = y1 - y0;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;

        float x = x0;
        float y = y0;

        for (int i = 0; i <= steps; i++) {
            displayable.display(Math.round(x), Math.round(y), color);
            x += xInc;
            y += yInc;
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
