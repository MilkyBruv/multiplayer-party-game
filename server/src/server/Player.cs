using System.Numerics;

class Player
{
	public string Name { get; private set; }
	public string PfpBase64 { get; private set; }
	public string Uuid { get; private set; }
	public Vector2 Position { get; set; }
	public int Score { get; set; }

	public Player(string uuid, string name, string pfpBase64)
	{
		// Set variables
		Uuid = uuid;
		Name = name;
		PfpBase64 = pfpBase64;
		Score = 0;
	}
}

