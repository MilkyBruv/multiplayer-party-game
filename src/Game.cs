using Raylib_cs;

class Game
{
	public static void Run()
	{
		// Set up all the raylib stuff
		Raylib.SetConfigFlags(ConfigFlags.AlwaysRunWindow);
		Raylib.SetConfigFlags(ConfigFlags.ResizableWindow);
		Raylib.InitWindow(854, 480, "mpg restart 3");
		Raylib.InitAudioDevice();
		Raylib.SetTargetFPS(144);

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
		Assets.LoadAssets();

		PlayerHandler.Start();
	}

	private static void Update()
	{
		PlayerHandler.Update();
	}

	private static void Render()
	{
		Raylib.BeginDrawing();
		Raylib.ClearBackground(Color.Magenta);



		PlayerHandler.Render();



		Raylib.EndDrawing();
	}

	private static void CleanUp()
	{
		AssetManager.UnloadAssets();
		
		// Close the raylib window
		//! Make sure this is always done last
		Raylib.CloseWindow();
	}
}