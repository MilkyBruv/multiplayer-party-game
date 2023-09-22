using System.ComponentModel;
using System.Numerics;
using Raylib_cs;

class Player
{
	public float X { get; set; }
	public float Y { get; set; }
	public float Speed { get; set; } = 200f;

	private Texture2D sprite;


	public Player()
	{
		// Load the player sprite
		sprite = Raylib.LoadTexture("./assets/gui/logo.png");
	}

	public void Dispose()
	{
		// Unload the player sprite
		Raylib.UnloadTexture(sprite);
	}





	// Update the player logic and whatnot
	public void Update()
	{
		Movement();
	}

	// Render the player 
	public void Render()
	{
		// Draw the player (0.7x scale)
		Raylib.DrawTexturePro(
			sprite,
			new Rectangle(0, 0, sprite.width, sprite.height),
			new Rectangle(X, Y, (sprite.width / 7), (sprite.height / 7)),
			new Vector2(0, 0),
			0,
			Color.WHITE
		);
	}




	private void Movement()
	{
		// Calculate the players new movement
		float newX = X;
		float newY = Y;
		float movement = Speed * Raylib.GetFrameTime();

		// Get player movement input
		if (Raylib.IsKeyDown(KeyboardKey.KEY_LEFT)) newX -= movement;
		if (Raylib.IsKeyDown(KeyboardKey.KEY_RIGHT)) newX += movement;
		if (Raylib.IsKeyDown(KeyboardKey.KEY_UP)) newY -= movement;
		if (Raylib.IsKeyDown(KeyboardKey.KEY_DOWN)) newY += movement;

		// Move the player
		X = newX;
		Y = newY;
	}
}