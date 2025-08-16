package geometrical_shapes;

import java.awt.Color;

import jart.Displayable;
import jart.Drawable;

public class Rectangle implements Drawable{
    final private Point a, b;
    final private Color color;

    public Rectangle(Point a, Point b) {
        this.a = a;
        this.b = b;
        this.color = Color.white;
    }

    public Rectangle(Point a, Point b, Color color) {
        this.a = a;
        this.b = b;
        this.color = color;
    }
    
    
    @Override
    public void draw(Displayable displayable){
        Point topLeft = new Point(Math.min(a.getX(), b.getX()), Math.min(a.getY(), b.getY()));
        Point topRight = new Point(Math.max(a.getX(), b.getX()), Math.min(a.getY(), b.getY()));
        Point bottomLeft = new Point(Math.min(a.getX(), b.getX()), Math.max(a.getY(), b.getY()));
        Point bottomRight = new Point(Math.max(a.getX(), b.getX()), Math.max(a.getY(), b.getY()));
        
        new Line(topLeft, topRight, this.color).draw(displayable);     
        new Line(topLeft, bottomLeft, this.color).draw(displayable);   
        new Line(topRight, bottomRight, this.color).draw(displayable); 
        new Line(bottomLeft, bottomRight, this.color).draw(displayable); 
    }

    
    @Override
    public Color getColor(){
        return this.color;
    }
}