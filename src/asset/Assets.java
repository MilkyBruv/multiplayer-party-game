package asset;

import com.raylib.Raylib.Music;
import com.raylib.Raylib.Sound;
import com.raylib.Raylib.Texture;


public abstract class Assets {
	
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
	protected static final void loadAssets() {

		player = AssetManager.loadTexture("player.png");

		raft0 = AssetManager.loadTexture("raft0.png");
		raft1 = AssetManager.loadTexture("raft1.png");
		raft2 = AssetManager.loadTexture("raft2.png");
		water = AssetManager.loadTexture("water.png");
		
		controllerLeftX = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "x_xbox.png");
		controllerRightX = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "b_xbox.png");
		controllerUpX = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "y_xbox.png");
		controllerDownX = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "a_xbox.png");

		controllerLeftP = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "square_ps.png");
		controllerRightP = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "circle_ps.png");
		controllerUpP = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "triangle_ps.png");
		controllerDownP = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "x_ps.png");
		
		music = AssetManager.loadMusic("music.wav");

	}
}