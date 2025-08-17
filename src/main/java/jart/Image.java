package jart;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image implements Displayable {

    private final BufferedImage image;
    private Graphics2D graphics;

    public Image(Integer height, Integer width) {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.graphics = image.createGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, height);
    }

    @Override
    public void display(int x, int y, Color color) {
        if (x < 0 || x>=getWidth() ||  y< 0 || y >= getHeight() ) return; 
        image.setRGB(x, y, color.getRGB());
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public void save(String name) {
        File file = new File(name);
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}
