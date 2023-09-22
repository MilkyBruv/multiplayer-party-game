using Raylib_cs;

class Game
{
	
	public void Run()
	{
		// Create the raylib window
		Raylib.InitWindow(800, 480, "jjcloft@gmail.com");

		// Main game loop
		while (!Raylib.WindowShouldClose())
		{
			Raylib.BeginDrawing();

			Raylib.ClearBackground(Color.MAGENTA);
			Raylib.DrawText("C# (better than Java)", 25, 25, 50, Color.WHITE);

			Raylib.EndDrawing();
		}

		// Close the window
		Raylib.CloseWindow();
	}

}