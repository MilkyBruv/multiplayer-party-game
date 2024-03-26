using System.Numerics;
using Raylib_cs;

class LobbyScene : Scene
{
	private int playersReadiedUp = 0;

	public override void Start()
	{


		base.Start();
	}

	public override void Update()
	{
		// Check for if a new controller/player joins
		PlayerHandler.ConnectNewPlayers();


		// Check for if everyone has readied up. If they
		// all have then start a new game
		if (PlayerHandler.PlayerCount >= 2 && playersReadiedUp == PlayerHandler.PlayerCount)
		{
			Console.WriteLine("Starting new game rn");
			SceneManager.SetScene(new GameScene());
		}
	}

	public override void Render()
	{
		Raylib.BeginMode2D(camera);


		// Draw the lobby background
		Raylib.DrawTexture(Assets.LobbyBackground, 0, 0, Color.White);

		// Draw all the players in the lobby
		Vector2 position = Vector2.Zero;
		float scale = 1f;
		foreach (Player player in PlayerHandler.Players)
		{
			if (player == null) continue;

			// Get the position and scale
			// TODO: Don't hardcode
			// switch (player.ControllerIndex)
			switch (player.ControllerIndex)
			{
				case 0:
					position = new Vector2(350, 430 - player.Texture.Height);
					scale = 1;
					break;
				
				case 1:
					position = new Vector2(470, 430 - player.Texture.Height);
					scale = 0.8f;
					break;

				case 2:
					position = new Vector2(255, 435 - player.Texture.Height);
					scale = 0.8f;
					break;
				
				case 3:
					position = new Vector2(570, 470 - player.Texture.Height);
					scale = 0.6f;
					break;
			}
		
			// Draw the player
			Raylib.DrawTextureEx(player.Texture, position, 0f, scale, Color.White);
		}


		// Show a connection prompt if there is still
		// a space left for a player to join
		if (PlayerHandler.PlayerCount < PlayerHandler.MaxPlayers)
		{
			TextUtils.DrawTextWithControllerInputs("Press <down_x> or <down_p> to join", new Vector2(10, Game.Height - 10 - 25), 25, Color.White);
		}



		Raylib.EndMode2D();
	}
}