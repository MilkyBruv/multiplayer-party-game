package entity.player;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Raylib.Texture;
import com.raylib.Raylib.Vector2;

import asset.Assets;

public class Player {

	// Instance stuff
	public Vector2 position;
	public int width = 256;
	public int height = 256;
	public int controllerIndex;
	public final float speed = 5f;
	public Texture texture = null;

	public Player(int controller) {

		controllerIndex = controller;
		this.texture = Assets.player;
		this.texture.width(this.width);
		this.texture.height(this.height);
	}



	public final void getInput() {

		// Check for if the controller is avalible
		if (!Raylib.IsGamepadAvailable(controllerIndex)) return;

		// Get input
		// float xAxis = 
		// float yAxis = 

		// position += 1;

		// this.x += (this.speed * this.xAxis);
		// this.y += (this.speed * this.yAxis);


	}



	public final void update() {

		getInput();
	}



	public final void render() {

		Raylib.DrawTextureV(texture, position, Jaylib.WHITE);
	}

}
