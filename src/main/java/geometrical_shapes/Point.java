package geometrical_shapes;
import java.awt.Color;
import java.util.Random;

import jart.Displayable;
import jart.Drawable;

public class Point implements Drawable {
    private int x;
    private int y;
    final private Color  color;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.red;
    }

    @Override
    public void draw(Displayable displayable){
        displayable.display(this.x, this.y, this.color);
    }

    public int getX(){
        return x;
    }

    public void   setX(int x){
        this.x = x;
    }

    public void   setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public static Point random(Integer width, Integer height) {
            Random rand = new Random();
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            return new Point(x, y);
    }

    @Override
    public Color getColor(){
        return  color;
    }
}