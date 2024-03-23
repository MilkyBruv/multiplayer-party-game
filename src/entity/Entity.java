package entity;

import java.awt.Rectangle;

import event.GameEventManager;
import gfx.ImageResource;

public abstract class Entity {
    
    protected GameEventManager game;

    public int x;
    public int y;
    public int drawX;
    public int drawY;
    public int width;
    public int height;
    public ImageResource image;
    public Rectangle rect;

    public Entity(int x, int y, GameEventManager game) {

        this.game = game;
        this.x = x;
        this.y = y;
        this.drawX = this.x;
        this.drawX = this.y;
        this.width = 8;
        this.height = 8;

    }



    public abstract void update();

}
