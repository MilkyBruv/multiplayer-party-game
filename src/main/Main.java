package main;

import java.util.ArrayList;
import java.util.List;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Jaylib.Color;
import com.raylib.Jaylib.Rectangle;

import asset.Assets;
import asset.AssetManager;
import entity.player.Player;
import entity.player.PlayerHandler;

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
		AssetManager.loadAll();

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


		//! debug texture test thing
		Raylib.DrawTexture(Assets.controllerDownX, 0, 0, Jaylib.WHITE);
		Raylib.DrawTexture(Assets.controllerDownP, 0, 180, Jaylib.WHITE);


		Raylib.EndDrawing();
	}



	private static void cleanUp() {
		
		// Unload all the assets
		AssetManager.unloadAll();

		// Close the raylib window
		//! Do this last
		Raylib.CloseWindow();

	}
}
