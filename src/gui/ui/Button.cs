using System.Text;
using Raylib_cs;

class Button
{
	private string text;
	private Rectangle rectangle;
	private Color backgroundColor;
	private Color backgroundColorHover;
	private Color currentColor;
	private Font font;


	// Create a new button
	public Button(string text, Rectangle rectangle, Color backgroundColor)
	{
		// Set values
		this.text = text;
		this.rectangle = rectangle;
		this.backgroundColor = backgroundColor;

		// Set the hovered background color to be a little darker
		int darken = 20;
		backgroundColorHover = new Color(Math.Clamp(backgroundColor.r - darken, 0, 255), Math.Clamp(backgroundColor.g - darken, 0, 255), Math.Clamp(backgroundColor.b - darken, 0, 255), 255);

		// Load the font
		// TODO: Make asset manager to load all this stuff
		font = Raylib.LoadFontEx("./assets/font/Futura-Extra-Bold-Condensed.otf", 128, null, 0);
	}

	// Render the button
	public void Render()
	{
		// Draw the background and outline
		Raylib.DrawRectangle((int)rectangle.x, (int)rectangle.y, (int)rectangle.width, (int)rectangle.height, currentColor);
		Raylib.DrawRectangleLinesEx(rectangle, 5f, Color.WHITE);

		// Draw the text in the buttons
		// string[] textLines = text.Split(" ");
		// Ui.CentreText(textLines[0]);
	}

	// Update button logic
	public void Update()
	{
		// Check for if the user is hovering over the button and change the background color
		if (Raylib.CheckCollisionPointRec(Raylib.GetMousePosition(), rectangle))
		{
			currentColor = backgroundColorHover;

		} else currentColor = backgroundColor;
	}

	// Check for if the button is clicked
	public bool BeingClicked()
	{
		// Check for if the user is clicking, and their mouse is within the button's bounds
		if (Raylib.IsMouseButtonDown(MouseButton.MOUSE_BUTTON_LEFT))
		{
			return Raylib.CheckCollisionPointRec(Raylib.GetMousePosition(), rectangle);
		}

		// Wasn't clicking
		return false;
	}

}