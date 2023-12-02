using System.Numerics;

class Player
{
	public string Name { get; private set; }
	public string Uuid { get; private set; }
	public byte[] PfpBytes { get; private set; }
	public Vector2 Position { get; set; }
	public int Score { get; set; }

	// Create a new player
	public Player(string uuid, string name, byte[] pfpBytes)
	{
		// Set variables
		Uuid = uuid;
		Name = name;
		PfpBytes = pfpBytes;
		Score = 0;
	}
}

