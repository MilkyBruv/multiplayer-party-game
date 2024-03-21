using Raylib_cs;

class AssetManager
{
	// Paths
	public static readonly string RootPath = "./assets/";
	public static readonly string TexturePath = RootPath + "texture/";
	public static readonly string AudioPath = RootPath + "sound/";
	public static readonly string ControllerTexturePath = TexturePath + "controller/";

	// File extensions
	private static readonly string textureExtension = ".png";
	private static readonly string audioExtension = ".wav";

	// Lists of assets to be unloaded
	private static List<Texture2D> textures = new List<Texture2D>();
	private static List<Sound> sounds = new List<Sound>();
	private static List<Music> songs = new List<Music>();


	public static Texture2D LoadTexture(string path, string assetName)
	{
		// Load in the texture
		Texture2D texture = Raylib.LoadTexture(path + assetName + textureExtension);

		// Add it to a list of loaded textures so it
		// can be programmatically unloaded
		textures.Add(texture);

		// Return the texture
		return texture;
	}

	public static Sound LoadSound(string path, string assetName)
	{
		// Load in the sound
		Sound sound = Raylib.LoadSound(path + assetName + audioExtension);

		// Add it to a list of loaded sounds so it
		// can be programmatically unloaded
		sounds.Add(sound);

		// Return the sound
		return sound;
	}

	public static Music LoadMusic(string path, string assetName)
	{
		// Load in the music
		Music music = Raylib.LoadMusicStream(path + assetName + audioExtension);

		// Add it to a list of loaded songs so it
		// can be programmatically unloaded
		songs.Add(music);

		// Return the music
		return music;
	}

	public static void UnloadAssets()
	{
		// Loop through every texture and unload it
		foreach (Texture2D texture in textures)
		{
			Raylib.UnloadTexture(texture);
		}

		// Loop through every sound and unload it
		foreach (Sound sound in sounds)
		{
			Raylib.UnloadSound(sound);
		}

		// Loop through every bit of music and unload it
		foreach (Music music in songs)
		{
			Raylib.UnloadMusicStream(music);
		}
	}
}