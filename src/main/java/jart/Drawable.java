package jart;

import jart.Displayable;

import java.awt.*;

public interface Drawable {
    void draw(Displayable displayable);
    Color getColor();
}