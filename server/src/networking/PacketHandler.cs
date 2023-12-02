using System.Text;

class PacketHandler
{
	public static string CreatePlayer(string[] packet)
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

		// Create the response packet
		string responsePacket = $"+{1},{uuid}";
		return responsePacket;
	}
}