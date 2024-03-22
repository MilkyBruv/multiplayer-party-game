class SceneManager
{
	public static Scene CurrentScene { get; private set; }

	public static void SetScene(Scene scene)
	{
		// Run the previous scenes clean method
		//? question mark just does a null check
		CurrentScene?.CleanUp();

		// Set the new scene and run its start method
		CurrentScene = scene;
		CurrentScene.Start();
	}



	public static void Update()
	{
		CurrentScene.Update();
	}

	public static void Render()
	{
		CurrentScene.Render();
	}
}