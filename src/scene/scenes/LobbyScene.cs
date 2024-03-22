using System.Numerics;
using Raylib_cs;

class LobbyScene : Scene
{

	private Button readyUpButton;

	public override void Start()
	{
		// Make the ready up button and have it automatically
		// selected because this is the only UI element in the scene
		readyUpButton = new Button("Ready Up", StartNewGame, new Vector2(250, 150), new Vector2(300, 75), 50f);
		readyUpButton.Selected = true;
		readyUpButton.Disabled = true;
	}

	public override void Update()
	{
		// Check for if a new controller/player joins
		PlayerHandler.ConnectNewPlayers();

		// Update UI
		readyUpButton.Update();
	}

	public override void Render()
	{
		Raylib.DrawText("Lobby", 150, 150, 16, Color.White);

		// Render UI
		readyUpButton.Render();
	}

	private void StartNewGame()
	{
		Console.WriteLine("Starting new game rn");
		SceneManager.SetScene(new GameScene());
	}
}