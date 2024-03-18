package main;

import java.util.ArrayList;
import java.util.List;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Jaylib.Color;
import com.raylib.Jaylib.Rectangle;
import com.raylib.Jaylib.Vector2;
import com.raylib.Raylib.Texture;

import main.assets.Assets;

public class Main
{

	private static boolean isGamepad0Connected = false;
	private static boolean isGamepad1Connected = false;
	private static final List<Player> players = new ArrayList<Player>() {};

	private static boolean shutUp = true;

	public static void main(String[] args) {

		// Make the raylib window
		Raylib.SetConfigFlags(Raylib.FLAG_WINDOW_ALWAYS_RUN);
		Raylib.SetConfigFlags(Raylib.FLAG_WINDOW_RESIZABLE);
		Raylib.InitWindow(400, 300, "mpg");
		Raylib.InitAudioDevice();
		Raylib.SetTargetFPS(144);

		// Main game loop
		start();

		while (!Raylib.WindowShouldClose()) {
			
			update();
			render();
		}

		cleanUp();

	}



	private static void start() {

		// Load in all the assets
		Assets.loadAssets();

		// Music
		Raylib.PlayMusicStream(Assets.music);

		PlayerHandler.Start();
	}



	private static void update() {
		
		if (shutUp == false) Raylib.UpdateMusicStream(Assets.music);

		/*
		if (Raylib.IsGamepadAvailable(0) && !isGamepad0Connected) {

			if (Raylib.IsGamepadButtonDown(0, Raylib.GAMEPAD_BUTTON_RIGHT_FACE_DOWN)) {

				players.add(Player.initPlayer(Assets.player));
				isGamepad0Connected = true;

			}

		} if (Raylib.IsGamepadAvailable(1) && !isGamepad1Connected) {

			if (Raylib.IsGamepadButtonDown(1, Raylib.GAMEPAD_BUTTON_RIGHT_FACE_DOWN)) {

				players.add(Player.initPlayer(Assets.player));
				isGamepad1Connected = true;

			}
		}
		*/

		PlayerHandler.update();
	}



	private static void render() {

		Raylib.BeginDrawing();
		Raylib.ClearBackground(new Color(0, 0, 255, 255));

		PlayerHandler.render();

		Raylib.EndDrawing();

		// Join button
		// TODO: Don't do this
		int y = Raylib.GetScreenHeight() - 50;
		Rectangle source = new Rectangle(0, 0, 180, 180);

		// Raylib.DrawText("press", 20, y, 35, Jaylib.WHITE);
		// Raylib.DrawTexturePro(connectButtonXbox, source, new Rectangle(130, y, 35, 35), new Vector2(0, 0), 0, Jaylib.WHITE);
		// Raylib.DrawText("or", 180, y, 35, Jaylib.WHITE);
		// Raylib.DrawTexturePro(connectButtonPlayStation, source, new Rectangle(240, y, 35, 35), new Vector2(0, 0), 0, Jaylib.WHITE);
		// Raylib.DrawText("to join", 300, y, 35, Jaylib.WHITE);
	}



	private static void cleanUp() {
		
		// Unload all the assets
		Assets.unloadAssets();

		// Close the raylib window
		//! Do this last
		Raylib.CloseWindow();

	}
}