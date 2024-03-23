package event;

import java.util.ArrayList;
import java.util.List;

import com.jogamp.newt.event.KeyEvent;

import controller.ControllerManager;
import gfx.Assets;
import gfx.ImageResource;
import gfx.Renderer;

public final class GameEventManager {

    public GameEventManager() {
        
        // 

    }


    
    public final void init() {

        Assets.loadAssets();

        ControllerManager.getControllers();

    }



    public final void update() {

        // 

    }



    public final void draw() {

        Renderer.clear(0x000000);
        
        Renderer.drawImage(Assets.spritesheet, 0, 0);

    }
    
}
