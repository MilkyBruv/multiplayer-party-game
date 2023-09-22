using Raylib_cs;

class Game
{
	
	public void Run()
	{
		int windowWidth = 800;
		int windowHeight = 600;

		// Create the raylib window
		Raylib.InitWindow(windowWidth, windowHeight, "jjcloft@gmail.com");
		Raylib.SetWindowState(ConfigFlags.FLAG_WINDOW_RESIZABLE);
		Raylib.SetTargetFPS(60);

		// Add an icon to the raylib window
		Image icon = Raylib.LoadImage("./assets/gui/icon.png");
		Raylib.SetWindowIcon(icon);


		// Test player for just testing out how the library works and whatnot
		// when we make the actual multiplayer stuff we will probably do it differently
		Player player = new Player();
		

		// Main game loop
		while (!Raylib.WindowShouldClose())
		{
			player.Update();

			Raylib.BeginDrawing();
			Raylib.ClearBackground(Color.MAGENTA);

			player.Render();
			Raylib.DrawText("C# (better than Java)", 25, 25, 50, Color.WHITE);

			Raylib.EndDrawing();
		}

		// Unload everything
		Raylib.UnloadImage(icon);
		player.Dispose();

		// Close the window
		Raylib.CloseWindow();

	}

}