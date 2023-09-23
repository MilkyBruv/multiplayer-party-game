using Raylib_cs;

class Game
{
	
	public void Run()
	{
		int windowWidth = 1000;
		int windowHeight = 563;

		// Create the raylib window
		Raylib.InitWindow(windowWidth, windowHeight, "jjcloft@gmail.com");
		Raylib.SetTargetFPS(60);
		Raylib.InitAudioDevice();

		// Add an icon to the raylib window
		Image icon = Raylib.LoadImage("./assets/gui/icon.png");
		Raylib.SetWindowIcon(icon);


		// Test player for just testing out how the library works and whatnot
		// when we make the actual multiplayer stuff we will probably do it differently
		Player player = new Player();
		MainMenu menu = new MainMenu();
		

		// Main game loop
		while (!Raylib.WindowShouldClose())
		{
			// player.Update();
			menu.Update();

			Raylib.BeginDrawing();
			Raylib.ClearBackground(Color.MAGENTA);

			menu.Render();
			// player.Render();
			// Raylib.DrawText("C# (better than Java)", 25, 25, 50, Color.WHITE);

			Raylib.EndDrawing();
		}

		// Unload everything
		Raylib.UnloadImage(icon);
		player.Dispose();

		// Close the window
		Raylib.CloseWindow();
	}

}