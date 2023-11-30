using System.Net;
using System.Net.Sockets;
using System.Text;

class Network
{
	public static UdpClient Server;
	public static IPEndPoint ClientEndPoint;

	public static void Listen(int port)
	{
		// Make the UDP server and listen for any request
		Server = new UdpClient(port);
		ClientEndPoint = new IPEndPoint(IPAddress.Any, 0);
		Logger.Log($"Server listening on port {port} for requests.");

		// All of this code is ran once when a packet is received. Ignore the loop part and just
		// think of it like some sort of async method
		// TODO: try/catch inside the loop
		while (true)
		{
			// If we have a client, then receive the packet and decode to string
			byte[] receivedPacketBytes = Server.Receive(ref ClientEndPoint);
			string receivedPacket = Encoding.ASCII.GetString(receivedPacketBytes);
			
			// Parse, and extract the packet type
			string[] packet = receivedPacket.Split(',');
			PacketType packetType = (PacketType)int.Parse(packet[0]);

			// TODO: Check for if its a fragmentation packet, or a regular packet
			// TODO: Maybe make all packets fragmentation packets.

			// Depending on the packet type, handle the packet
			// TODO: Split up all of this into derived packet classes
			string responsePacketString;
			switch (packetType)
			{
				// Client is requesting to join
				case PacketType.PLAYER_CONNECTION_REQUEST:
					// TODO: Do this somewhere else
					responsePacketString = CreatePlayer(packet);
					break;

				// Incorrect packet type
				default:
					Logger.LogWarn($"Unknown or unhandled packet type received ({packetType}) Ignoring");
					break;
			}

			// Gather needed information from the game update loop stuff,
			// then compile into a packet and send it back to the player

		}
	}






	// TODO: Do somewhere else
	private static string CreatePlayer(string[] packet)
	{
		// Generate a new UUID for the player
		string uuid = Guid.NewGuid().ToString();

		// Create the player object for the server to interact with
		//! Skipping pfp stuff for now, but will add later
		Player player = new Player(uuid, username, "");


		// Create the response packet
		string responsePacket = "";
		return responsePacket;
	}
}