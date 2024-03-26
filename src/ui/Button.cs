using System.Numerics;
using Raylib_cs;

// TODO: This whole class kinda useless because controller so maybe remove

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
	}

	public void Render()
	{
		// Draw the button background thingy and
		// the buttons text
		// TODO: Put a border/outline on the button or something
		Raylib.DrawRectangleRec(shape, new Color(214, 79, 0, 255));
		TextUtils.DrawTextWithControllerInputs(text, textPosition, (int)fontSize, Color.White);

		// Make the button greyed out if its disabled
		// TODO: Make this look half decent
		Raylib.DrawRectangleRec(shape, new Color(255, 255, 255, 128));

		// If the button is selected then draw a border around it
		if (Selected) Raylib.DrawRectangleLinesEx(shape, 5f, Color.Yellow);
	}

	// TODO: Don't do this
	public void Click()
	{
		onClick();
	}
}