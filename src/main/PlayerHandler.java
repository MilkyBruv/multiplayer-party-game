package main;

import com.raylib.Jaylib;
import com.raylib.Raylib;

public class PlayerHandler {
	
	private static final int maxPlayers = 4;
	private static int connectedPlayers = 0;
	public static Player[] players;

	public static void Start() {

		// Make the array to store the players
		players = new Player[maxPlayers];
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

		// Show the connected players
		Raylib.DrawText((connectedPlayers + "/" + maxPlayers + " connected"), 10, 10, 25, Jaylib.WHITE);

		if (connectedPlayers < maxPlayers)
		{
			// TODO: Show the button to press to join
		}
	}



	private static void ConnectNewPlayers()
	{
		// Loop through all players that aren't connected
		for (int i = 0; i < maxPlayers - connectedPlayers; i++) {
			
			// Check for if the controller is
			// avalible to connect to and they press
			// the a/x button.
			// TODO: Don't put if statement on a single line
			if (Raylib.IsGamepadAvailable(i) && Raylib.IsGamepadButtonPressed(i, Raylib.GAMEPAD_BUTTON_RIGHT_FACE_DOWN)) {

				// Make them a new player
				Player player = new Player(i);
				players[i] = player;
			}
		}
	}
}
