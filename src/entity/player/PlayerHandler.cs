using System.Numerics;
using Raylib_cs;

class PlayerHandler
{
	public static Player[] Players;
	public static int PlayerCount;

	public static readonly int MaxPlayers = 4;
	private static bool[] connectedControllers;

	public static void Start()
	{
		// Store the players, and the connected
		// controllers and their indexes
		Players = new Player[MaxPlayers];
		connectedControllers = new bool[MaxPlayers];
	}

	public static void Update()
	{
		// Update all the players
		foreach (Player player in Players)
		{
			if (player == null) continue;
			player.Update();
		}
	}

	public static void Render()
	{
		// Render all the players
		foreach (Player player in Players)
		{
			if (player == null) continue;
			player.Render();
		}
	}


	// Check for if a new controller/player joins
	public static void ConnectNewPlayers()
	{
		// Loop through all the controller slots
		for (int i = 0; i < connectedControllers.Length; i++)
		{
			// Check for if there is a free slot
			if (connectedControllers[i] == true) continue;

			// Check for if there is an available
			// controller we can use.
			if (!Raylib.IsGamepadAvailable(i)) continue;

			// Check for if the controller presses
			// the start button
			// TODO: Maybe change the button
			if (!Raylib.IsGamepadButtonPressed(i, GamepadButton.RightFaceDown)) continue;

			// Make a new player for that controller
			// and increase the connected players counter
			connectedControllers[i] = true;
			Players[i] = new Player(i);
			PlayerCount++;
		}
	}
}