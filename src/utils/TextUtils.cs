using System.Numerics;
using Raylib_cs;

class TextUtils
{
	// Lookup table for controller and its string counterpart
	private static readonly Dictionary<string, Texture2D> controllerTextureTable = new Dictionary<string, Texture2D>()
	{
		// Xbox
		{ "left_x", Assets.ControllerLeftX },
		{ "right_x", Assets.ControllerRightX },
		{ "up_x", Assets.ControllerUpX },
		{ "down_x", Assets.ControllerDownX },

		// PlayStation
		{ "left_p", Assets.ControllerLeftP },
		{ "right_p", Assets.ControllerRightP },
		{ "up_p", Assets.ControllerUpP },
		{ "down_p", Assets.ControllerDownP }
	};

	// Draw text with controller buttons.
	// To draw a controller button, put the location.direction, then either _x or _p (xbox/playstation)
	// Example for xbox: "Press <down_x> to jump"
	// Example for playstation: "Press <down_p> to jump"
	public static void DrawTextWithControllerInputs(string text, Vector2 position, int fontSize, Color color)
	{
		// Get the width of a space
		float spaceWidth = Raylib.MeasureText(" ", fontSize);

		// Loop through every word in the text
		float x = position.X;
		foreach (string word in text.Split(" "))
		{
			// Check for if the word has angle
			// brackets around it. If it has, then
			// its a controller input
			if (word.StartsWith('<') && word.EndsWith('>'))
			{
				// Use the lookup table to get the
				// strings corresponding texture
				string key = word.Replace("<", "").Replace(">", "");
				Texture2D controllerTexture = controllerTextureTable[key];
		
				// Draw the controller input texture
				// TODO: Maybe make the texture a little smaller if its being pressed
				Rectangle source = new Rectangle(0f, 0f, controllerTexture.Width, controllerTexture.Height);
				Rectangle destination = new Rectangle(x, position.Y, fontSize, fontSize);
				Raylib.DrawTexturePro(controllerTexture, source, destination, Vector2.Zero, 0f, Color.White);

				// Increase the x value to add the width of the button
				x += fontSize;
			}
			else
			{
				// Draw the word normally
				Raylib.DrawText(word, (int)x, (int)position.Y, fontSize, color);

				// Increase the x value to add the mew text
				x += Raylib.MeasureText(word, fontSize);
			}

			// Add a space onto the end of the word
			// (assuming every word has a space after it)
			// TODO: Preserve spaces correctly
			x += spaceWidth;
		}
	}
}