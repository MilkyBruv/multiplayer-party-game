package util;

import java.util.HashMap;
import java.util.Map;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Jaylib.Color;
import com.raylib.Jaylib.Rectangle;
import com.raylib.Raylib.Texture;
import com.raylib.Jaylib.Vector2;

import asset.Assets;

public abstract class TextUtils {

	// Lookup table for controller and its string counterpart
	private static final Map<String, Texture> controllerTextureMap = new HashMap<String, Texture>() {};
	
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
	// TODO: Color parameter
	public static void drawTextWithController(String text, Vector2 pos, int fontSize, Color color) {

		// Loop through every word in the text. Find the
		// words, and controller inputs and handle them.
		int x = (int) pos.x();
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
				int space = fontSize / 3;
				Rectangle source = new Rectangle(0, 0, controllerTexture.width(), controllerTexture.height());
				Rectangle destination = new Rectangle(x + space, pos.y(), fontSize, fontSize);
				Raylib.DrawTexturePro(controllerTexture, source, destination, new Vector2(0, 0), 0f, new Color(255, 255, 255, 255));

				// Increase the x value to add the width of the button
				x += space + fontSize + space;

				// Skip the current iteration because
				// we've already done all the work
				continue;
			}

			// Draw the word normally
			Raylib.DrawText(word, (int) x, (int) pos.y(), fontSize, color);

			// Add on the new x position
			x += Raylib.MeasureText(word, fontSize);
		}
	}

}
