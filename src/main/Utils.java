package main;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Jaylib.Color;
import com.raylib.Raylib.Texture;

import asset.Assets;

public class Utils {
	
	// Print text that includes controller buttons
	// To use the buttons then put the button in angle brackets
	// use the location/direction, and an `x`, or `p` depending
	// on xbox or playstation.
	// Example for xbox: "Press <down_x> to jump"
	// Example for playstation: "Press <down_p> to jump"
	// TODO: Color parameter
	public static void DrawTextWithController(String text, int xPosition, int yPosition, int fontSize) {

		// Loop through every word in the text. Find the
		// words, and controller inputs and handle them.
		int x = xPosition;
		for (String word : text.split(" ")) {
			
			// Check for if the word has angle brackets
			// around it. If it has then its a controller input
			if (word.startsWith("<") && word.endsWith(">"))
			{
				// Get rid of the angle brackets, then
				// use switch statement of doom to find
				// what texture we need
				// TODO: Don't use switch statement of doom
				word = word.replace("<", "").replace(">", "");
				Texture controllerTexture;
				switch (word) {

					case "left_x":
						controllerTexture = Assets.controllerLeftX;
						break;

					case "right_x":
						controllerTexture = Assets.controllerRightX;
						break;

					case "up_x":
						controllerTexture = Assets.controllerUpX;
						break;

					case "down_x":
						controllerTexture = Assets.controllerDownX;
						break;



					case "left_p":
						controllerTexture = Assets.controllerLeftP;
						break;

					case "right_p":
						controllerTexture = Assets.controllerRightP;
						break;

					case "up_p":
						controllerTexture = Assets.controllerUpP;
						break;

					case "down_p":
						controllerTexture = Assets.controllerDownP;
						break;
					
					
				
					
					
					default:
						System.err.println("erhm there isnt a controller thing called " + word + " (stinky spelling mistake or smth idk)");
						continue;
				}

				// Draw the controller input texture


				// Skip the current iteration because
				// we've already done all the work
				continue;
			}

			// Draw the word normally
			Raylib.DrawText(word, xPosition, yPosition, fontSize, Jaylib.WHITE);

			// Add on the new x position
			x += Raylib.MeasureText(word, fontSize);
		}
	}

}
