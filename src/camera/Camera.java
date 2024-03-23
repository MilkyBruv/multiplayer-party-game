package camera;

import entity.Entity;
import event.GameEventManager;
import gfx.Renderer;

public class Camera {
    
    private GameEventManager game;

    public int x;
    public int y;
    public Entity target;
    public int width = Renderer.FRAMEBUFFER_BASE_WIDTH;
    public int height = Renderer.FRAMEBUFFER_BASE_HEIGHT;

    public Camera(GameEventManager game, Entity target) {

        this.game = game;
        this.target = target;

    }



    public final void update() {

        this.x = (this.target.x + (this.target.width / 2)) - (this.width / 2);
        this.y = (this.target.y + (this.target.height / 2)) - (this.height / 2);

    }

}
