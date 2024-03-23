package main;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

import event.KeyEventListener;
import event.MouseEventListener;
import event.RenderEventListener;
import event.WindowEventListener;
import game.GameEventManager;

public final class Main implements Runnable {

    private static final int FPS = 60;
    public static double delta = 0;

    private static final GLProfile GL_PROFILE = GLProfile.get(GLProfile.GL4);
    private static final GLCapabilities GL_CAPABILITIES = new GLCapabilities(GL_PROFILE);
    private static final GLWindow GL_WINDOW = GLWindow.create(GL_CAPABILITIES);
    private static Thread thread;
    private static GameEventManager game;

    public static void main(String[] args) {

        init();

    }



    private static final void init() {

        setSystemProperties();

        game = new GameEventManager();
        game.init();

        initWindow();
        initThread();

    }



    private static final void setSystemProperties() {

        System.setProperty("sun.java2d.opengl", "true");
        System.setProperty("sun.awt.noerasebackground", "true");

    }



    private static final void initThread() {

        thread = new Thread(new Main());
        thread.start();

    }


    
    private static final void initWindow() {

        GL_WINDOW.setSize(640, 480);
        // GL_WINDOW.setFullscreen(true);
        GL_WINDOW.setTitle("Test GLWindow");
        GL_WINDOW.setUndecorated(false);

        GL_WINDOW.addGLEventListener(new RenderEventListener(game));
        GL_WINDOW.addWindowListener(new WindowEventListener(game));
        GL_WINDOW.addKeyListener(new KeyEventListener(game));
        GL_WINDOW.addMouseListener(new MouseEventListener(game));

        GL_WINDOW.setVisible(true);

    }


    
    private static final void update() {

        game.update();

    }


    
    private static final void draw() {

        GL_WINDOW.display();

    }


    
    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (thread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                // Update
                update();

                // Render
                draw();

                delta--;

            }

        }

    }

}
