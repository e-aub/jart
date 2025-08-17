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
        // Draw circle using Bresenham's circle algorithm
        int x0 = center.getX();
        int y0 = center.getY();
        int r = radius;
        
        int x = r;
        int y = 0;
        int err = 0;
        
        while (x >= y) {
            System.out.println("Drawing circle at: (" + x0 + ", " + y0 + ") with radius: " + r);
            displayable.display(x0 + x, y0 + y, color);
            displayable.display(x0 + y, y0 + x, color);
            displayable.display(x0 - y, y0 + x, color);
            displayable.display(x0 - x, y0 + y, color);
            displayable.display(x0 - x, y0 - y, color);
            displayable.display(x0 - y, y0 - x, color);
            displayable.display(x0 + y, y0 - x, color);
            displayable.display(x0 + x, y0 - y, color);
            
            if (err <= 0) {
                y += 1;
                err += 2 * y + 1;
            }
            
            if (err > 0) {
                x -= 1;
                err -= 2 * x + 1;
            }
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
        int radius = rand.nextInt(Math.max(1, Math.min(maxRadius, 100))) + 10;
        return new Circle(center, radius);
    }
}