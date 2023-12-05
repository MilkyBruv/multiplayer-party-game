using System.Text;

class PacketHandler
{
	public static Packet CreatePlayer(string[] packet)
	{
		// Generate a new UUID for the player
		string uuid = Guid.NewGuid().ToString();

		// Parse the username
		string username = packet[1];
		
		// Parse the pfp (in bytes)
		byte[] pfpBytes = Encoding.ASCII.GetBytes(packet[2]);

		// Create the player object for the server to interact with
		Player player = new Player(uuid, username, pfpBytes);
		Server.Players.Add(player);

		// Log that they have joined the game
		// TODO: Maybe put this in some other place
		Logger.Log($"{username} joined the game.");

		// Create the response packet that has the players new UUID
		Packet responsePacket = new Packet();
		responsePacket.AddPacket(PacketType.PLAYER_CONNECTION_REQUEST_ACCEPTED, uuid);

		// Loop through all of the currently connected online players and send their
		// Details so that the player can see all the other players
		// TODO: Split this up into multiple packets because the PFPs could get very large
		foreach (Player connectedPlayer in Server.Players)
		{
			// Add a player connection packet indicating that the player has already
			// been in the game (tells the client not to send a join message)
			responsePacket.AddPacket(PacketType.PLAYER_CONNECTION, connectedPlayer.Username, Encoding.ASCII.GetString(connectedPlayer.PfpBytes), "1");
		}
		return responsePacket;
	}
}