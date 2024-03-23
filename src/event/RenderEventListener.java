package event;

import java.awt.image.BufferedImage;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.math.Matrix4;

import game.GameEventManager;
import gfx.Renderer;
import shader.Shader;

public final class RenderEventListener implements GLEventListener {

    private int windowWidth = 10;
    private int windowHeight = 10;
    private int vao;
    private int vbo;
    private int projectionMatrixPos;
    private Matrix4 projectionMatrix;
    private GameEventManager game;
    private FloatBuffer vertexBuffer = Renderer.framebufferVertexBuffer;

    public RenderEventListener(GameEventManager game) {

        this.game = game;

    }



    @Override
    public synchronized void init(GLAutoDrawable drawable) {

        GL4 gl = drawable.getGL().getGL4();

        Renderer.scaleFramebuffer(windowWidth, windowHeight);

        // Set clear colour and enable images to be draw to the window
        gl.glClearColor(0f, 0f, 0f, 1f);
        gl.glEnable(GL4.GL_TEXTURE_2D);

        // Create shaders
        Shader.loadAndCompileShaders(gl);
        Shader.createProgram(gl);

        // Create VAOs and VBOs and pass info to shaders
        int[] vaoArray = new int[1];
        gl.glGenVertexArrays(1, vaoArray, 0);
        vao = vaoArray[0];
        gl.glBindVertexArray(vao);

        int[] vboArray = new int[1];
        gl.glGenBuffers(1, vboArray, 0);
        vbo = vboArray[0];
        
        gl.glBindBuffer(GL4.GL_ARRAY_BUFFER, vbo);
        gl.glBufferData(GL4.GL_ARRAY_BUFFER, vertexBuffer.capacity() * Float.BYTES, vertexBuffer, GL4.GL_STATIC_DRAW);

        int positionAttrib = gl.glGetAttribLocation(Shader.program, "position");
        int texCoordAttrib = gl.glGetAttribLocation(Shader.program, "texCoord");

        gl.glEnableVertexAttribArray(positionAttrib);
        gl.glVertexAttribPointer(positionAttrib, 2, GL4.GL_FLOAT, false, 4 * Float.BYTES, 0);
        gl.glEnableVertexAttribArray(texCoordAttrib);
        gl.glVertexAttribPointer(texCoordAttrib, 2, GL4.GL_FLOAT, false, 4 * Float.BYTES, 2 * Float.BYTES);
        gl.glBindVertexArray(0);

        projectionMatrixPos = gl.glGetUniformLocation(Shader.program, "projectionMatrix");

    }



    @Override
    public synchronized void display(GLAutoDrawable drawable) {

        GL4 gl = drawable.getGL().getGL4();

        gl.glClear(GL4.GL_COLOR_BUFFER_BIT);

        // Draw onto framebuffer
        Renderer.createGraphics();

            this.game.draw();

        Renderer.disposeGraphics();
        
        // Set origin to (0, 0) as top-left
        projectionMatrix = new Matrix4();
        projectionMatrix.makeOrtho(0.0f, (float) windowWidth, (float) windowHeight, 0.0f, 1.0f, -1.0f);
        gl.glUniformMatrix4fv(projectionMatrixPos, 1, false, projectionMatrix.getMatrix(), 0);

        // Use shader
        gl.glUseProgram(Shader.program);

        // Bind VAO
        gl.glBindVertexArray(vao);

        // Draw texture
        createAndBindTexture(gl, Renderer.getFramebuffer());

        // Set texture sampler pos uniform in shaders
        int textureSamplerPos = gl.glGetUniformLocation(Shader.program, "textureSampler");
        gl.glUniform1i(textureSamplerPos, 0);

        // Render texture
        gl.glDrawArrays(GL4.GL_TRIANGLE_STRIP, 0, 4);

        // Unbind shader program and vertex array
        gl.glBindVertexArray(0);
        gl.glUseProgram(0);

    }



    @Override
    public synchronized void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        GL4 gl = drawable.getGL().getGL4();

        windowWidth = width;
        windowHeight = height;

        // Set display viewport to resized window
        gl.glViewport(x, y, width, height);

        // Scale framebuffer only when window is resized
        Renderer.scaleFramebuffer(windowWidth, windowHeight);

        vertexBuffer = Renderer.framebufferVertexBuffer;

        // Create VAOs and VBOs and pass info to shaders
        int[] vaoArray = new int[1];
        gl.glGenVertexArrays(1, vaoArray, 0);
        vao = vaoArray[0];
        gl.glBindVertexArray(vao);

        int[] vboArray = new int[1];
        gl.glGenBuffers(1, vboArray, 0);
        vbo = vboArray[0];
        
        gl.glBindBuffer(GL4.GL_ARRAY_BUFFER, vbo);
        gl.glBufferData(GL4.GL_ARRAY_BUFFER, vertexBuffer.capacity() * Float.BYTES, vertexBuffer, GL4.GL_STATIC_DRAW);

        int positionAttrib = gl.glGetAttribLocation(Shader.program, "position");
        int texCoordAttrib = gl.glGetAttribLocation(Shader.program, "texCoord");

        gl.glEnableVertexAttribArray(positionAttrib);
        gl.glVertexAttribPointer(positionAttrib, 2, GL4.GL_FLOAT, false, 4 * Float.BYTES, 0);
        gl.glEnableVertexAttribArray(texCoordAttrib);
        gl.glVertexAttribPointer(texCoordAttrib, 2, GL4.GL_FLOAT, false, 4 * Float.BYTES, 2 * Float.BYTES);
        gl.glBindVertexArray(0);

        projectionMatrixPos = gl.glGetUniformLocation(Shader.program, "projectionMatrix");

    }


    
    @Override
    public synchronized void dispose(GLAutoDrawable drawable) {

        GL4 gl = drawable.getGL().getGL4();

        // Delete VBOs and VAOs
        gl.glDeleteBuffers(1, new int[] {vbo}, 0);
        gl.glDeleteVertexArrays(1, new int[] {vao}, 0);

        // Delete shader
        gl.glDeleteProgram(Shader.program);

    }



    private final void createAndBindTexture(GL4 gl, BufferedImage image) {

        // Create texture
        int[] textureArray = new int[1];
        gl.glGenTextures(1, textureArray, 0);
        int texture = textureArray[0];
        
        gl.glBindTexture(GL4.GL_TEXTURE_2D, texture);

        // Set texture parameters
        gl.glTexParameteri(GL4.GL_TEXTURE_2D, GL4.GL_TEXTURE_WRAP_S, GL4.GL_REPEAT);
        gl.glTexParameteri(GL4.GL_TEXTURE_2D, GL4.GL_TEXTURE_WRAP_T, GL4.GL_REPEAT);
        gl.glTexParameteri(GL4.GL_TEXTURE_2D, GL4.GL_TEXTURE_MIN_FILTER, GL4.GL_NEAREST);
        gl.glTexParameteri(GL4.GL_TEXTURE_2D, GL4.GL_TEXTURE_MAG_FILTER, GL4.GL_NEAREST);

        // Pass image data to texture
        int width = image.getWidth();
        int height = image.getHeight();
        int[] pixels = new int[width * height];

        image.getRGB(0, 0, width, height, pixels, 0, width);

        ByteBuffer pixelBuffer = Buffers.newDirectByteBuffer(pixels.length * Integer.BYTES);

        pixelBuffer.asIntBuffer().put(pixels);

        gl.glTexImage2D(GL4.GL_TEXTURE_2D, 0, GL4.GL_RGBA, width, height, 0, GL4.GL_RGBA, GL4.GL_UNSIGNED_BYTE, 
            pixelBuffer);

        // Bind the texture
        gl.glBindTexture(GL4.GL_TEXTURE_2D, texture);

    }

}
