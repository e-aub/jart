package jart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Image implements Displayable {
    private final BufferedImage image;

    public Image(Integer height, Integer width) {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public void display(int x, int y, Color color){
            image.setRGB(x,y,color.getRGB());
    }
    public void save(String name){
        File file = new File(name);
        try {
            ImageIO.write(image, "png", file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
