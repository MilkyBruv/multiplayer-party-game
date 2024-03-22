// TODO: Put this all in Game.cs because this not really doing anything

class SceneManager
{
	public static Scene CurrentScene { get; set; }

	public static void Update()
	{
		CurrentScene.Update();
	}

	public static void Render()
	{
		CurrentScene.Render();
	}
}