using System.Numerics;
using Raylib_cs;

// TODO: Make image button class
class Button
{
	public bool Disabled { get; set; } = false;
	public bool Selected { get; set; } = false;

	private Rectangle shape;
	private Action onClick;
	private string text;
	private float fontSize;
	private Vector2 textPosition;

	// TODO: Add color support thing
	// TODO: Make a way to 'anchor' the button somewhere and make it responsive automatically. Enum with the direction. Anchor.BottomLeft or something idk
	public Button(string text, Action onClick, Vector2 position, Vector2 size, float fontSize)
	{
		// Set values
		shape = new Rectangle(position, size);
		this.onClick = onClick;
		this.text = text;
		this.fontSize = fontSize;

		// Calculate where the text position will be based
		// on the button shape
		Vector2 textSize = Raylib.MeasureTextEx(Raylib.GetFontDefault(), text, fontSize, (fontSize / 10));
		textPosition = new Vector2(
			shape.X + ((shape.Width - textSize.X) / 2),
			shape.Y + ((shape.Height - textSize.Y) / 2)
		);
	}

	public void Update()
	{
		// Don't do anything if the button is disabled
		if (Disabled) return;

		// Check for if the button is selected, and
		// if they press the select button, then run
		// the click method supplied in the constructor
		//? Selection isn't handled here because of the controller the layouts are different all the time. There isn't a mouse or anything that we're looking for
		if (Selected)
		{
			// Loop through every player and check for if
			// they press the button
			foreach (Player player in PlayerHandler.Players)
			{
				if (player == null) continue;
				if (Raylib.IsGamepadButtonPressed(player.ControllerIndex, GamepadButton.RightFaceDown)) onClick();
			}
		}
	}

	public void Render()
	{
		// Draw the button background thingy and
		// the buttons text
		// TODO: Put a border/outline on the button or something
		Raylib.DrawRectangleRec(shape, new Color(214, 79, 0, 255));
		Raylib.DrawTextEx(Raylib.GetFontDefault(), text, textPosition, fontSize, (fontSize / 10f), Color.White);

		// TODO: Make the button greyed out if its disabled

		// If the button is selected then draw a border around it
		if (Selected) Raylib.DrawRectangleLinesEx(shape, 5f, Color.Yellow);
	}
}