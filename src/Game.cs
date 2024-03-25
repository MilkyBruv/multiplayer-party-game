using Raylib_cs;

class Game
{
	public static readonly int Width = 854;
	public static readonly int Height = 480;

	public static void Run()
	{
		// Set up all the raylib stuff
		Raylib.SetConfigFlags(ConfigFlags.AlwaysRunWindow);
		Raylib.SetConfigFlags(ConfigFlags.ResizableWindow);
		Raylib.InitWindow(Width, Height, "mpg restart 3");
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
		// Setup type stuff
		Assets.LoadAssets();
		SceneManager.Start();
		PlayerHandler.Start();

		// Start the game off in the lobby
		SceneManager.SetScene(new LobbyScene());
	}

	private static void Update()
	{
		SceneManager.Update();
	}

	private static void Render()
	{
		Raylib.BeginDrawing();
		Raylib.ClearBackground(Color.Magenta);


		SceneManager.Render();


		Raylib.EndDrawing();
	}

	private static void CleanUp()
	{
		SceneManager.CleanUp();
		AssetManager.UnloadAssets();
		
		// Close the raylib window
		//! Make sure this is always done last
		Raylib.CloseWindow();
	}
}