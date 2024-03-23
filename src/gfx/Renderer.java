package gfx;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.nio.FloatBuffer;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import event.RenderEventListener;

public abstract class Renderer {

    // Framebuffer scaling and positioning variable declarations
    public static final int FRAMEBUFFER_BASE_WIDTH = 16 * 18; // 16:9 ratio is the aspect ratio for most monitors
    public static final int FRAMEBUFFER_BASE_HEIGHT = 9 * 18;
    public static float framebufferWidth = FRAMEBUFFER_BASE_WIDTH;
    public static float framebufferHeight = FRAMEBUFFER_BASE_HEIGHT;
    public static float framebufferX = 0;
    public static float framebufferY = 0;
    public static FloatBuffer framebufferVertexBuffer = Buffers.newDirectFloatBuffer(new float[] {

        // x, y, u, v
        -1.0f, -1.0f, 0.0f, 1.0f,   // Vertex 1 bl
        1.0f, -1.0f, 1.0f, 1.0f,    // Vertex 2 br
        -1.0f, 1.0f, 0.0f, 0.0f,   // Vertex 3 tl
        1.0f, 1.0f, 1.0f, 0.0f     // Vertex 4 tr

    });
    private static final BufferedImage FRAMEBUFFER = new BufferedImage(FRAMEBUFFER_BASE_WIDTH, FRAMEBUFFER_BASE_HEIGHT,
            BufferedImage.TYPE_INT_ARGB);
    private static Graphics2D framebufferGraphics2D = (Graphics2D) FRAMEBUFFER.getGraphics();
    private static Texture glTexture = null;

    /**
     * Creates framebuffer Graphics2D
     */
    public static final void createGraphics() {

        framebufferGraphics2D = (Graphics2D) FRAMEBUFFER.getGraphics();

    }



    /**
     * Clears framebuffer with hex colour
     * 
     * @param hex - (0x000000)
     */
    public static final void clear(int hex) {

        // Get current colour
        Color previousColour = framebufferGraphics2D.getColor();

        // Fill framebuffer with colour
        framebufferGraphics2D.setColor(new Color(hex));
        framebufferGraphics2D.fillRect(0, 0, FRAMEBUFFER_BASE_WIDTH, FRAMEBUFFER_BASE_HEIGHT);

        // Set colour back to previous
        framebufferGraphics2D.setColor(previousColour);

    }



    /**
     * Draws line onto frame buffer from (x1, y1) to (x2, y2) with the colour of the
     * supplied hex
     * 
     * @param x1 - start x
     * @param y1 - start y
     * @param x2 - end x
     * @param y2 - end y
     * @param hex - (0x000000)
     */
    public static final void drawLine(int x1, int y1, int x2, int y2, int hex) {

        // Get current colour
        Color previousColour = framebufferGraphics2D.getColor();

        // Draw line with colour
        framebufferGraphics2D.setColor(new Color(hex));
        framebufferGraphics2D.drawLine(x1, y1, x2, y2);

        // Set colour back to previous
        framebufferGraphics2D.setColor(previousColour);

    }



    /**
     * Draws line onto frame buffer from (x1, y1) to (x2, y2)
     * 
     * @param x1 - start x
     * @param y1 - start y
     * @param x2 - end x
     * @param y2 - end y
     */
    public static final void drawLine(int x1, int y1, int x2, int y2) {

        // Draw line
        framebufferGraphics2D.drawLine(x1, y1, x2, y2);

    }



    /**
     * Draws a rectangle on screen using the properties of the supplied rect
     * 
     * @param rect
     */
    public static final void drawRect(Rectangle rect) {

        framebufferGraphics2D.drawRect(rect.x, rect.y, rect.width, rect.height);

    }



    /**
     * Draws a rectangle on screen using the properties of the supplied rect with the supplied colour
     * 
     * @param rect
     */
    public static final void drawRect(Rectangle rect, int hex) {

        // Get current colour
        Color previousColour = framebufferGraphics2D.getColor();

        // Draw rect with colour
        framebufferGraphics2D.setColor(new Color(hex));
        framebufferGraphics2D.drawRect(rect.x, rect.y, rect.width, rect.height);

        // Set colour back to previous
        framebufferGraphics2D.setColor(previousColour);

    }



    /**
     * Draws image to framebuffer at supplied position
     * 
     * @param image - image to draw
     * @param x - pos x
     * @param y - pos y
     */
    public static final void drawImage(ImageResource image, int x, int y) {

        // Draw image at (x, y)
        framebufferGraphics2D.drawImage(image.getBufferedImage(), x, y, null);

    }



    /**
     * Sets framebuffer graphics2d colour to supplied hex
     * 
     * @param hex - (0x000000)
     */
    public static final void setColour(int hex) {

        // Set framebuffer graphics2d colour to hex
        framebufferGraphics2D.setColor(new Color(hex));

    }



    /**
     * Disposes framebuffer Graphics2D and creates OpenGL Texture
     */
    public static final void disposeGraphics() {

        // Dispose framebuffer Graphics2D
        framebufferGraphics2D.dispose();

    }



    /**
     * Scales and normalizes framebuffer dimensions and position to fit window perfectly
     * Keeps the aspect ratio and resolution the same
     * 
     * @param windowWidth - current window width from {@link RenderEventListener}
     * @param windowHeight - current window height from {@link RenderEventListener}
     */
    public static final void scaleFramebuffer(int windowWidth, int windowHeight) {

        // Get framebuffer scale factor
        float scale = Math.min(

            (float) windowWidth / (float) FRAMEBUFFER_BASE_WIDTH,
            (float) windowHeight / (float) FRAMEBUFFER_BASE_HEIGHT

        );

        // Scale width to fit window
        framebufferWidth = Math.round((float) FRAMEBUFFER_BASE_WIDTH * scale);
        framebufferHeight = Math.round((float) FRAMEBUFFER_BASE_HEIGHT * scale);

        // Calculate centre-screen positions
        framebufferX = Math.round(((float) windowWidth / 2) - ((float) framebufferWidth / 2));
        framebufferY = Math.round(((float) windowHeight / 2) - ((float) framebufferHeight / 2));

        // Normalize framebuffer position and dimensions to work with OpenGL co-ordinate system
        float glWidthInterval = (2.0f / windowWidth);
        float glHeightInterval = (2.0f / windowHeight);
        float glWidth = framebufferWidth * glWidthInterval;
        float glHeight = framebufferHeight * glHeightInterval;
        float glX = framebufferX * glWidthInterval - 1.0f;
        float glY = framebufferY * glHeightInterval - 1.0f;

        framebufferVertexBuffer = Buffers.newDirectFloatBuffer(new float[] {

            glX, glY, 0.0f, 1.0f,
            glX + glWidth, glY, 1.0f, 1.0f,
            glX, glY + glHeight, 0.0f, 0.0f,
            glX + glWidth, glY + glHeight, 1.0f, 0.0f,

        });

    }



    public static final BufferedImage getFramebuffer() {

        return FRAMEBUFFER;

    }


    
    /**
     * Creates and returns OpenGL Texture from bufferedImage
     * 
     * @return OpenGL Texture
     */
    public static final Texture getFramebufferGlTexture() {

        // Create OpenGL Texture from framebuffer
        glTexture = AWTTextureIO.newTexture(GLProfile.get(GLProfile.GL2), FRAMEBUFFER, true);

        return glTexture;

    }

}
