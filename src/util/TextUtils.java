package util;

import java.util.HashMap;
import java.util.Map;

import com.raylib.Raylib;
import com.raylib.Jaylib.Color;
import com.raylib.Jaylib.Rectangle;
import com.raylib.Raylib.Texture;
import com.raylib.Jaylib.Vector2;

import asset.Assets;

public abstract class TextUtils {

	// Lookup table for controller and its string counterpart
	private static final Map<String, Texture> controllerTextureMap = new HashMap<String, Texture>();
	
	// Map all the controller thingys
	static {

		controllerTextureMap.put("up_x", Assets.controllerUpX);
		controllerTextureMap.put("up_p", Assets.controllerUpP);
		controllerTextureMap.put("left_x", Assets.controllerLeftX);
		controllerTextureMap.put("left_p", Assets.controllerLeftP);
		controllerTextureMap.put("down_x", Assets.controllerDownX);
		controllerTextureMap.put("down_p", Assets.controllerDownP);
		controllerTextureMap.put("right_x", Assets.controllerRightX);
		controllerTextureMap.put("right_p", Assets.controllerRightP);

	}
	
	// Print text that includes controller buttons
	// To use the buttons then put the button in angle brackets
	// use the location/direction, and an `x`, or `p` depending
	// on xbox or playstation.
	// Example for xbox: "Press <down_x> to jump"
	// Example for playstation: "Press <down_p> to jump"
	// TODO: Support newlines (startwith or endswith) x = pos.x;
	public static void drawTextWithController(String text, Vector2 position, int fontSize, Color color) {

		// Get the width of a space
		int spaceWidth = Raylib.MeasureText(" ", fontSize);

		// Loop through every word in the text. Find the
		// words, and controller inputs and handle them.
		int x = (int) position.x();
		for (String word : text.split(" ")) {
			
			// Check for if the word has angle brackets
			// around it. If it has then its a controller input
			if (word.startsWith("<") && word.endsWith(">"))
			{
				// Get rid of the angle brackets, then use
				// the lookup table to get the corresponding
				// texture to the word
				word = word.replace("<", "").replace(">", "");
				Texture controllerTexture = controllerTextureMap.get(word);
				
				// Draw the controller input texture
				Rectangle source = new Rectangle(0, 0, controllerTexture.width(), controllerTexture.height());
				Rectangle destination = new Rectangle(x, position.y(), fontSize, fontSize);
				Raylib.DrawTexturePro(controllerTexture, source, destination, new Vector2(0, 0), 0f, new Color(255, 255, 255, 255));

				// Increase the x value to add the width of the button
				x += fontSize;

			} else {

				// Draw the word normally
				Raylib.DrawText(word, (int) x, (int) position.y(), fontSize, color);

				// Add on the new x position
				x += Raylib.MeasureText(word, fontSize);
			}

			// Add a space onto the end of the word
			// (assuming every word has a space after it)
			// TODO: Preserve spaces
			x += spaceWidth;
		}
	}

}
