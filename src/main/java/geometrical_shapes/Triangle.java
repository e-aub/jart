package geometrical_shapes;

import java.awt.Color;

import jart.Displayable;
import jart.Drawable;

public class Triangle implements Drawable{
    final private Point a, b, c;
    final private Color color;
    // private boolean filled; TODO!

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = Color.blue;
    }

    @Override
    public void draw(Displayable displayable){
        new Line(a, b).draw(displayable);
        new Line(b, c).draw(displayable);
        new Line(c, a).draw(displayable);
    }

    @Override
    public Color getColor(){
        return this.color;
    }

    
}
