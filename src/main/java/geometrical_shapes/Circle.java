package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

import jart.Displayable;
import jart.Drawable;

public class Circle implements Drawable {
    private Point center;
    private int radius;
    private Color color;
    private static Random rand = new Random();
    
    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
    
    public Circle(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }
    
    @Override
    public void draw(Displayable displayable) {
        int x0 = center.getX();
        int y0 = center.getY();
        int r = radius;
        
        double stpes = 0.0;
        while (stpes < 360.0) {
            double angle = (stpes * Math.PI / 180.0);
            int x = (int)(x0 + r * Math.cos(angle));
            int y = (int)(y0 + r * Math.sin(angle));
            displayable.display(x, y, color);
            stpes += 0.01;
        }
    }

    
    @Override
    public Color getColor() {
        return color;
    }
    
    public static Circle random(int maxX, int maxY) {
        Point center = Point.random(maxX, maxY);
        int maxRadius = Math.min(
            Math.min(center.getX(), maxX - center.getX()),
            Math.min(center.getY(), maxY - center.getY())
        );
        int radius = (int) (Math.random() * maxX);
        return new Circle(center, radius);
    }
}