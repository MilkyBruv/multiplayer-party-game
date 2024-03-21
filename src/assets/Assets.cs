using Raylib_cs;

class Assets
{
	public static Texture2D Player { get; private set; }

	public static Texture2D Raft0 { get; private set; }
	public static Texture2D Raft1 { get; private set; }
	public static Texture2D Raft2 { get; private set; }
	public static Texture2D Water { get; private set; }

	//? x for xbox
	public static Texture2D ControllerLeftX { get; private set; }
	public static Texture2D ControllerRightX { get; private set; }
	public static Texture2D ControllerUpX { get; private set; }
	public static Texture2D ControllerDownX { get; private set; }

	//? p for playstation
	public static Texture2D ControllerLeftP { get; private set; }
	public static Texture2D ControllerRightP { get; private set; }
	public static Texture2D ControllerUpP { get; private set; }
	public static Texture2D ControllerDownP { get; private set; }

	// TODO: Put this in AssetManager class, and just have
	// TODO: this for keeping the variables. Bit weird rn using
	// TODO: Assets.LoadAssets and AssetManager.UnloadAssets
	public static void LoadAssets()
	{
		// Player texture(s)
		Player = AssetManager.LoadTexture(AssetManager.TexturePath, "player");

		// Environmental textures
		Raft0 = AssetManager.LoadTexture(AssetManager.TexturePath, "raft0");
		Raft1 = AssetManager.LoadTexture(AssetManager.TexturePath, "raft1");
		Raft2 = AssetManager.LoadTexture(AssetManager.TexturePath, "raft2");
		Water = AssetManager.LoadTexture(AssetManager.TexturePath, "water");

		// Xbox controller textures
		ControllerLeftX = AssetManager.LoadTexture(AssetManager.ControllerTexturePath, "left_x");
		ControllerRightX = AssetManager.LoadTexture(AssetManager.ControllerTexturePath, "right_x");
		ControllerUpX = AssetManager.LoadTexture(AssetManager.ControllerTexturePath, "up_x");
		ControllerDownX = AssetManager.LoadTexture(AssetManager.ControllerTexturePath, "down_x");

		// PlayStation controller textures
		ControllerLeftP = AssetManager.LoadTexture(AssetManager.ControllerTexturePath, "left_p");
		ControllerRightP = AssetManager.LoadTexture(AssetManager.ControllerTexturePath, "right_p");
		ControllerUpP = AssetManager.LoadTexture(AssetManager.ControllerTexturePath, "up_p");
		ControllerDownP = AssetManager.LoadTexture(AssetManager.ControllerTexturePath, "down_p");
	}
}