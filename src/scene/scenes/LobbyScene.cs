using Raylib_cs;

class LobbyScene : Scene
{

	public override void Update()
	{
		// Check for if a new controller/player joins
		PlayerHandler.ConnectNewPlayers();
	}

	public override void Render()
	{
		Raylib.DrawText("Lobby", 150, 150, 16, Color.White);
	}
}