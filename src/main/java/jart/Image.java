package jart;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Image implements Displayable {

    private final BufferedImage image;

    public Image(Integer height, Integer width) {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, Color.BLACK.getRGB()); 
            }
        }
    }

    @Override
    public void display(int x, int y, Color color) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
