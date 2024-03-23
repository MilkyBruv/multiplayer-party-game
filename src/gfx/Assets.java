package gfx;

import java.io.IOException;

import debug.Debug;

public abstract class Assets {
    
    public static ImageResource spritesheet = null;
    public static ImageResource player = null;
    public static ImageResource buttonUp = null;
    public static ImageResource buttonDown = null;

    public static final void loadAssets() {

        try {

            spritesheet = new ImageResource("spritesheet.png");

        } catch (IllegalArgumentException | IOException e) {

            Debug.printErr("Can't load image", e);

        }

    }

}
