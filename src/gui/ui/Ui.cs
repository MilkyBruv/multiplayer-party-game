using System.Numerics;
using Raylib_cs;

class Ui
{
	// Draw text in the centre of the screen
	public static void CentreText(string text, Font font, float y, int fontSize, float spacing)
	{
		// Calculate where the the x of the text is
		Vector2 textSize = Raylib.MeasureTextEx(font, text, fontSize, 0);
		float x = (Raylib.GetScreenWidth() - textSize.X) / 2;

		// Draw the text in the centre of the screen
		Raylib.DrawTextEx(font, text, new Vector2(x, y), fontSize, spacing, Color.WHITE);
	}

	// Draw text in the centre of of a rectangle
	public static void CentreText(string text, Font font, Rectangle rectangle, float y, int fontSize, float spacing)
	{
		// Calculate where the the x of the text is
		Vector2 textSize = Raylib.MeasureTextEx(font, text, fontSize, 0);
		float x = (rectangle.width - textSize.X) / 2;

		// Draw the text in the centre of the screen
		Raylib.DrawTextEx(font, text, new Vector2(rectangle.x, y), fontSize, spacing, Color.WHITE);
	}
}