using Raylib_cs;

class Game
{
	public static LocalPlayer Player;
	
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

		// Set the icon
		// TODO: Add resource manager for automatic loading and unloading
		Image icon = Raylib.LoadImage("./assets/icon.png");
		Raylib.SetWindowIcon(icon);

		// Main game loop
		Start();
		while (!Raylib.WindowShouldClose())
		{
			Update();
			Render();
		}
		CleanUp();

		// TODO: Add resource manager for automatic loading and unloading
		// TODO: also unload in cleanup()
		Raylib.UnloadImage(icon);
	}

	private static void Start()
	{
		// Make a new local player (the client)
		Player = new LocalPlayer(Program.Arguments[0], Program.Arguments[1]);
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