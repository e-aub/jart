package jart;
import geometrical_shapes.Line;
import geometrical_shapes.Point;
//import java.awt.*;



public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);
        Point point = new Point(50, 50);
        point.draw(image);

        Line line = new Line(new Point(1, 1), new Point(999, 999));
        line.draw(image);

        //Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
//        rectangle.draw(image);
//        Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
//        triangle.draw(image);
//
//        for (int i = 0; i < 50; i++) {
//            Circle circle = Circle.random(image.getWidth(), image.getHeight());
//            circle.draw(image);
//        }
        image.save("image.png");
    }
}