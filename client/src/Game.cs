using System.Net;
using Raylib_cs;

class Game
{
	public static LocalPlayer Player;
	
	private static bool paused = false;

	// Network stuff
	// TODO: I think we can decrease TPS quite a bit and still get good performance
	private const float NetworkTPS = 20; 
	private const float NetworkInterval = 1 / NetworkTPS;
	private static float networkTimeElapsed = 0;

	public static void Run()
	{
		// Initial window dimensions
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
		// Set the server ip and port
		Networking.ServerIp = IPAddress.Parse(Program.Arguments[2]);
		Networking.ServerPort = int.Parse(Program.Arguments[3]);

		// Make a new local player (the client)
		Player = new LocalPlayer(Program.Arguments[0], Program.Arguments[1]);
	}

	private static void Update()
	{
		// Update stuff that can't be paused

		// Update network dependant on the tps (ticks per second)
		networkTimeElapsed += Raylib.GetFrameTime();
		if (networkTimeElapsed >= NetworkInterval)
		{
			Console.WriteLine("Networking");
			networkTimeElapsed -= NetworkInterval;
		}

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