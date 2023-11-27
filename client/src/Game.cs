using Raylib_cs;

class Game
{
	
	private static bool paused = false;

	public static void Run()
	{
		// Initial dimensions
		const int initial_width = 600;
		const int initial_height = 500;

		// Make raylib window
		Raylib.InitWindow(initial_width, initial_height, "Client 0.0 | Multiplayer Party Game");
		Raylib.SetWindowState(ConfigFlags.FLAG_WINDOW_RESIZABLE);
		Raylib.SetExitKey(KeyboardKey.KEY_NULL);
		Raylib.SetTargetFPS(60);

		// Main game loop
		Start();
		while (!Raylib.WindowShouldClose())
		{
			Update();
			Render();
		}
		CleanUp();
	}

	private static void Start()
	{

	}

	private static void Update()
	{
		// Update stuff that can't be paused

		// Update stuff that can be paused
		if (paused) return;
	}

	private static void Render()
	{
		Raylib.BeginDrawing();
		Raylib.ClearBackground(Color.MAGENTA);

		Raylib.DrawText("Multiplayer party game", 10, 10, 30, Color.WHITE);

		Raylib.EndDrawing();
	}

	private static void CleanUp()
	{
		Raylib.CloseWindow();
	}

}