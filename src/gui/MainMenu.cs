using System.ComponentModel;
using System.Numerics;
using Raylib_cs;

class MainMenu
{
	private Font font;
	private Button hostGameButton;
	private Button joinGameButton;
	private Music backgroundMusic;

	public MainMenu()
	{
		// Load the font
		font = Raylib.LoadFontEx("./assets/font/Futura-Extra-Bold-Condensed.otf", 128, null, 0);

		// Create the buttons
		hostGameButton = new Button("Host Game", new Rectangle(100, 100, 100, 100), new Color(221, 55, 49, 255));
		joinGameButton = new Button("Join Game", new Rectangle(300, 100, 100, 100), new Color(221, 55, 49, 255));

		// Start to play the menu music
		backgroundMusic = Raylib.LoadMusicStream("./assets/audio/music/do-the-funky-strut.wav");
		Raylib.PlayMusicStream(backgroundMusic);

		// TODO: Make audio slider to change volume
		Raylib.SetMusicVolume(backgroundMusic, 0.3f);
	}

	// Render the menu
	public void Render()
	{
		// Set the background to a red-ish color
		Raylib.ClearBackground(new Color(221, 55, 49, 255));

		// Add the main game title text
		Ui.CentreText("MULTIPLAYER", font, 20, 130, 0);
		Ui.CentreText("PARTY GAME", font, 140, 100, -5);

		// Add the host and join game buttons
		hostGameButton.Render();
		joinGameButton.Render();
	}

	// Update menu logic
	public void Update()
	{
		// Update the buttons
		hostGameButton.Update();
		joinGameButton.Update();

		// Check for if the buttons are being clicked
		if (hostGameButton.BeingClicked()) Console.WriteLine("Host game clicked");
		if (joinGameButton.BeingClicked()) Console.WriteLine("Join game join");

		// Play the background music
		Raylib.UpdateMusicStream(backgroundMusic);

		// Check for if the background music has stopped, then play it again to loop
		if (Raylib.IsMusicStreamPlaying(backgroundMusic) == false)
		{
			// Go back to the start and play the music again
			Raylib.StopMusicStream(backgroundMusic);
			Raylib.SeekMusicStream(backgroundMusic, 0);
			Raylib.PlayMusicStream(backgroundMusic);
		}
	}
}