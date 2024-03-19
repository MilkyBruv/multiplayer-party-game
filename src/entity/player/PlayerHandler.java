package entity.player;

import com.raylib.Jaylib;
import com.raylib.Raylib;

public class PlayerHandler {
	
	private static final int maxPlayers = 4;
	public static Player[] players;
	private static boolean[] connectedControllers;

	public static void Start() {

		// Make the array to store the players
		// and controller status
		players = new Player[maxPlayers];
		connectedControllers = new boolean[maxPlayers];
	}

	public static void update() {

		// Check for if a new player joins
		ConnectNewPlayers();

		// Update all the players
		for (Player player : players) {
			
			if (player == null) continue;
			player.update();

		}

	}

	public static void render() {

		// Draw all the players
		for (Player player : players) {
			
			if (player == null) continue;
			player.render();

		}

		// Show a connection prompt
		// TODO: Use button images
		Raylib.DrawText("Press A/X to connect", 10, 10, 35, Jaylib.WHITE);
		
	}



	private static void ConnectNewPlayers()
	{
		// Loop through all the controller slots
		for (int i = 0; i < connectedControllers.length; i++) {
			
			// Check for if there is a free slot
			if (connectedControllers[i] == true) continue;

			// Check for if there is an available
			// controller we can use.
			if (!Raylib.IsGamepadAvailable(i)) continue;

			// Check for if the controller presses
			// the start button
			// TODO: Maybe change the button
			if (!Raylib.IsGamepadButtonPressed(i, Raylib.GAMEPAD_BUTTON_RIGHT_FACE_DOWN)) continue;

			// Make a new player for that controller
			connectedControllers[i] = true;
			players[i] = new Player(i);
		}
	}
}
