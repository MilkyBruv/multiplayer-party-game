using Raylib_cs;

class GameScene : Scene
{

	public override void Update()
	{
		// Update all the players
		PlayerHandler.Update();
		
	}

	public override void Render()
	{
		Raylib.DrawText("Game", 150, 150, 16, Color.White);
	}
}