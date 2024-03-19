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
	private static boolean shutUp = true;

	public static void main(String[] args) {

		// Make the raylib window
		Raylib.SetConfigFlags(Raylib.FLAG_WINDOW_ALWAYS_RUN);
		Raylib.SetConfigFlags(Raylib.FLAG_WINDOW_RESIZABLE);
		Raylib.InitWindow(854, 480, "mpg");
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

		// Update and add new players
		PlayerHandler.update();
	}



	private static void render() {

		Raylib.BeginDrawing();
		Raylib.ClearBackground(new Color(0, 0, 255, 255));

		
		// Draw all the players and their information
		PlayerHandler.render();

		
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
