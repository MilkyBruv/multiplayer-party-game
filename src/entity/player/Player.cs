using System.Numerics;
using Raylib_cs;

class Player
{
	public int ControllerIndex { get; private set; }
	public Vector2 Position { get; set; }

	private readonly float speed = 200f;
	private Texture2D texture;

	public Player(int controllerIndex)
	{
		// Assign a heap of stuff
		// TODO: Use asset manager
		ControllerIndex = controllerIndex;
		texture = Assets.Player;

		Console.WriteLine($"Player with controller index {ControllerIndex} registered!!");
	}

	public void Update()
	{
		Movement();
	}

	public void Render()
	{
		Raylib.DrawTextureV(texture, Position, Color.White);
	}





	private void Movement()
	{
		// Check for if the controller is available
		if (!Raylib.IsGamepadAvailable(ControllerIndex)) return;

		// Get the input input from the analog stick
		float xAxis = Raylib.GetGamepadAxisMovement(ControllerIndex, GamepadAxis.LeftX);
		float yAxis = Raylib.GetGamepadAxisMovement(ControllerIndex, GamepadAxis.LeftY);

		// Apply speed and delta time
		Vector2 movement = new Vector2(xAxis, yAxis) * speed * Raylib.GetFrameTime();

		// Update the players position
		Position += movement;
	}
}