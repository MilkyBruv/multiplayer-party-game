package main.assets;

import com.raylib.Raylib;
import com.raylib.Raylib.Music;
import com.raylib.Raylib.Sound;
import com.raylib.Raylib.Texture;


public class Assets {
	
	public static Texture player;

	public static Texture raft0;
	public static Texture raft1;
	public static Texture raft2;
	public static Texture water;

	//? X for Xbox
	//? P for PlayStation
	public static Texture controllerLeftX;
	public static Texture controllerLeftP;

	public static Texture controllerRightX;
	public static Texture controllerRightP;

	public static Texture controllerUpX;
	public static Texture controllerUpP;

	public static Texture controllerDownX;
	public static Texture controllerDownP;

	public static Music music;

	// Load all the assets
	public static void loadAssets() {

		// Get the base path to the textures
		String textures = "./res/texture/";

		player = Raylib.LoadTexture(textures + "player.png");

		raft0 = Raylib.LoadTexture(textures + "raft0.png");
		raft1 = Raylib.LoadTexture(textures + "raft1.png");
		raft2 = Raylib.LoadTexture(textures + "raft2.png");
		water = Raylib.LoadTexture(textures + "water.png");

		// Controller textures
		String controllerTextures = "./res/texture/controller/";
		
		controllerLeftX = Raylib.LoadTexture(controllerTextures + "x_xbox.png");
		controllerRightX = Raylib.LoadTexture(controllerTextures + "b_xbox.png");
		controllerUpX = Raylib.LoadTexture(controllerTextures + "y_xbox.png");
		controllerDownX = Raylib.LoadTexture(controllerTextures + "a_xbox.png");

		controllerLeftP = Raylib.LoadTexture(controllerTextures + "square_ps.png");
		controllerRightP = Raylib.LoadTexture(controllerTextures + "circle_ps.png");
		controllerUpP = Raylib.LoadTexture(controllerTextures + "triangle_ps.png");
		controllerDownP = Raylib.LoadTexture(controllerTextures + "x_ps.png");

		// Get the base path to the audio
		String sound = "./res/sound/";
		
		music = Raylib.LoadMusicStream(sound + "music.wav");

	}

	// Unload all the assets
	public static void unloadAssets() {

		Raylib.UnloadTexture(player);
		Raylib.UnloadTexture(raft0);
		Raylib.UnloadTexture(raft1);
		Raylib.UnloadTexture(raft2);
		Raylib.UnloadTexture(water);
		Raylib.UnloadTexture(controllerLeftX);
		Raylib.UnloadTexture(controllerLeftP);
		Raylib.UnloadTexture(controllerRightX);
		Raylib.UnloadTexture(controllerRightP);
		Raylib.UnloadTexture(controllerUpX);
		Raylib.UnloadTexture(controllerUpP);
		Raylib.UnloadTexture(controllerDownX);
		Raylib.UnloadTexture(controllerDownP);
		Raylib.UnloadMusicStream(music);
	}
}