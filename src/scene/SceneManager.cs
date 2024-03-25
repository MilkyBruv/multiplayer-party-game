using System.Numerics;
using Raylib_cs;

class SceneManager
{
	public static Scene CurrentScene { get; private set; }
	private static RenderTexture2D renderTexture;

	public static void SetScene(Scene scene)
	{
		// Run the previous scenes clean method
		//? question mark just does a null check
		CurrentScene?.CleanUp();

		// Set the new scene and run its start method
		CurrentScene = scene;
		CurrentScene.Start();
	}

	public static void Start()
	{
		// Make the render texture so that
		// everything is the same size
		renderTexture = Raylib.LoadRenderTexture(Game.Width, Game.Height);
	}

	public static void Update()
	{
		CurrentScene.Update();
	}

	public static void Render()
	{
		// Render the scene to a render texture
		// so that it can be displayed as the
		// same size no matter the window size
		// TODO: Don't stretch
		Raylib.BeginTextureMode(renderTexture);
		CurrentScene.Render();
		Raylib.EndTextureMode();

		// Draw the render texture output
		Rectangle source = new Rectangle(0f, 0f, Game.Width, -Game.Height);
		Rectangle destination = new Rectangle(0f, 0f, Raylib.GetScreenWidth(), Raylib.GetScreenHeight());
		Raylib.DrawTexturePro(renderTexture.Texture, source, destination, Vector2.Zero, 0f, Color.White);
	}

	public static void CleanUp()
	{
		// Unload the render texture
		Raylib.UnloadRenderTexture(renderTexture);
	}
}