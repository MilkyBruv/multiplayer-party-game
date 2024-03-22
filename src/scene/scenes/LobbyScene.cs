using System.Numerics;
using Raylib_cs;

class LobbyScene : Scene
{

	private Button readyUpButton;

	public override void Start()
	{
		// Make the ready up button
		//? Btw milky if you wanna call an Action with parameters and stuff put it in a lambda
		readyUpButton = new Button("Ready Up", StartNewGame, new Vector2(250, 150), new Vector2(300, 75), 50f);
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