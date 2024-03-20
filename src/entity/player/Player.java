package entity.player;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Raylib.Texture;
import com.raylib.Raylib.Vector2;

import asset.Assets;
import main.Utils;
import vector.Vector2f;

public class Player {

	// Instance stuff
	public Vector2 position = new Vector2(0);
	public Vector2f movement = new Vector2f(0f, 0f);
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

		System.out.println("Adding a new player with controller index of " + controllerIndex);
	}



	public final void getInput() {

		// Check for if the controller is avalible
		if (!Raylib.IsGamepadAvailable(controllerIndex)) return;

		// Get input
		this.movement.set(

			Raylib.GetGamepadAxisMovement(this.controllerIndex, 0) * this.speed,
			Raylib.GetGamepadAxisMovement(this.controllerIndex, 1) * this.speed

		);

		this.position.x(this.position.x() + this.movement.x);
		this.position.y(this.position.y() + this.movement.y);

	}



	public final void update() {

		getInput();

		// System.out.println(this.position.x() + ", " + this.position.y());
		System.out.println(Raylib.GetGamepadAxisMovement(this.controllerIndex, 0) + ", " + Raylib.GetGamepadAxisMovement(this.controllerIndex, 1));

	}



	public final void render() {

		Raylib.DrawTextureV(this.texture, this.position, Jaylib.WHITE);

		// Utils.DrawTextWithController("Press <down_x> or <down_ps> to join", 10, 10, 35);
	}

}
