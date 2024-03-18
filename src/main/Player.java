package main;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Raylib.Texture;

public class Player {
    
    // Static stuff
    public static final int[] _usedNums = new int[] {-1, -1, -1, -1};
    public static int _playerCount = 0;

    public static final Player initPlayer(Texture _texture) {

        for (int i : _usedNums) {
            
            if (i == -1) {

                _playerCount++;

                //? Minus 1 as raylib gamepads start at 0
                i = _playerCount - 1;
                return new Player(_playerCount - 1, _texture);

            }

        }

        return null;

    }



    // Instance stuff
    public int x = 0;
    public int y = 0;
    public int width = 64;
    public int height = 64;
    public int num;
    public final float speed = 2f;
    public Texture texture = null;

    private float xAxis = 0f;
    private float yAxis = 0f;

    public Player(int num, Texture texture) {

        this.num = num;
        this.texture.width(this.width);
        this.texture.height(this.height);

    }



    public final void getInput() {

        if (Raylib.IsGamepadAvailable(this.num)) {

            this.xAxis = Raylib.GetGamepadAxisMovement(this.num, 0);
            this.yAxis = Raylib.GetGamepadAxisMovement(this.num, 1);

        }

        this.x += this.speed * this.xAxis * Raylib.GetFrameTime();
        this.y += this.speed * this.yAxis * Raylib.GetFrameTime();

    }



    public final void update() {

        this.getInput();

    }



    public final void render() {

        if (this.texture != null) { Raylib.DrawTexture(this.texture, this.x, this.y, Jaylib.WHITE); }

    }

}
