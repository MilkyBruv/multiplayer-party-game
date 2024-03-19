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

		player = AssetManager.loadTexture("player");

		raft0 = AssetManager.loadTexture("raft0");
		raft1 = AssetManager.loadTexture("raft1");
		raft2 = AssetManager.loadTexture("raft2");
		water = AssetManager.loadTexture("water");
		
		controllerLeftX = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "x_xbox");
		controllerRightX = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "b_xbox");
		controllerUpX = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "y_xbox");
		controllerDownX = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "a_xbox");

		controllerLeftP = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "square_ps");
		controllerRightP = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "circle_ps");
		controllerUpP = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "triangle_ps");
		controllerDownP = AssetManager.loadTexture(AssetManager.CONTROLLER_TEXTURE_PATH + "x_ps");
		
		music = AssetManager.loadMusic("music");

	}
}