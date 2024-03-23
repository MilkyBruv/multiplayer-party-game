package gfx;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Main;

public class ImageResource {

    protected BufferedImage bufferedImage = null;
    protected int width, height;
    protected final GraphicsConfiguration GRAPHICS_CONFIG = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice().getDefaultConfiguration();

    /**
     * Instantiates ImageResource, and loads and optimizes supplied BufferedImage
     * 
     * @param bufferedImage - Pre-loaded image
     */
    public ImageResource(BufferedImage bufferedImage) {

        // Set bufferedImage, then get dimensions and optimize it
        this.bufferedImage = bufferedImage;
        this.setImageProperties();

    }



    /**
     * Instantiates ImageResource, and loads and optimizes BufferedImage from path
     * 
     * @param fileName - Name of file
     * @throws IOException If cannot find specified image
     */
    public ImageResource(String fileName) throws IOException {

        // Read image data from File and get dimensions
        this.bufferedImage = ImageIO.read(Main.class.getResourceAsStream("../res/" + fileName));
        this.setImageProperties();

    }



    /**
     * Optimizes and gets dimensions of bufferedImage
     */
    private final void setImageProperties() {

        this.optimizeBufferedImage();
        this.setImageDimensions();

    }



    /**
     * Sets width and height to bufferedImage dimensions
     */
    private final void setImageDimensions() {

        this.width = this.bufferedImage.getWidth();
        this.height = this.bufferedImage.getHeight();

    }



    /**
     * Optimizes bufferedImage using current GraphicsConfiguration
     */
    private final void optimizeBufferedImage() {

        // Create optimized / more compatible bufferedImage for faster rendering
        BufferedImage newImage = GRAPHICS_CONFIG.createCompatibleImage(this.bufferedImage.getWidth(), 
            this.bufferedImage.getHeight(), this.bufferedImage.getTransparency());

        // Draw new bufferedImage onto existing bufferedImage
        Graphics2D g2d = (Graphics2D) this.bufferedImage.getGraphics();
        g2d.drawImage(newImage, 0, 0, null);
        g2d.dispose();

    }



    /**
     * @param x
     * @param y
     * @param width
     * @param height
     * @return New sub {@link ImageResource} from bufferedImage at (x, y) with the dimensions of (width, height)
     */
    public final ImageResource getSubImage(int x, int y, int width, int height) {

        // Return new sub image
        return new ImageResource(this.bufferedImage.getSubimage(x, y, width, height));

    }



    /**
     * @param x
     * @param y
     * @param width
     * @param height
     * @return New sub {@link ImageResource} from bufferedImage at (x * width, y * height) with the dimensions of 
     * (width, height)
     */
    public final ImageResource getSubImageByDimensions(int x, int y, int width, int height) {

        // Return new sub image
        return new ImageResource(this.bufferedImage.getSubimage(x * width, y * height, width, height));

    }



    public final BufferedImage getBufferedImage() {

        return this.bufferedImage;

    }



    /**
     * Sets bufferedImage to supplied bufferedImage
     * 
     * @param bufferedImage
     */
    public final void setBufferedImage(BufferedImage bufferedImage) {

        // Set and optimize bufferedImage
        this.bufferedImage = bufferedImage;
        this.setImageProperties();

    }



    /**
     * Loads and optimizes and gets dimensions of bufferedImage from file path
     * 
     * @param fileName - Name of file
     * @throws IOException If image cannot be found
     */
    public final void setBufferedImage(String fileName) throws IOException {

        // Read image data from file path and optimize and get dimensions
        this.bufferedImage = ImageIO.read(Main.class.getResourceAsStream("../res/" + fileName));
        this.setImageProperties();

    }



    public final int getWidth() {

        return this.width;

    }


    
    public final int getHeight() {

        return this.height;

    }

}
