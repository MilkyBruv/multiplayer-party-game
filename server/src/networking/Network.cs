using System.Net;
using System.Net.Sockets;
using System.Text;

class Network
{
	public static UdpClient UdpServer;
	public static IPEndPoint ClientEndPoint;

	public static void Listen(int port)
	{
		// Make the UDP server and listen for any request
		UdpServer = new UdpClient(port);
		ClientEndPoint = new IPEndPoint(IPAddress.Any, 0);
		Logger.Log($"Server listening on port {port} for requests.");

		// All of this code is ran once when a packet is received. Ignore the loop part and just
		// think of it like some sort of async method
		// TODO: try/catch inside the loop
		while (true)
		{
			// If we have a client, then receive the packet and decode to string
			byte[] receivedPacketBytes = UdpServer.Receive(ref ClientEndPoint);
			string receivedPacket = Encoding.ASCII.GetString(receivedPacketBytes);
			
			// Parse, and extract the packet type
			string[] packet = receivedPacket.Split(',');
			PacketType packetType = (PacketType)int.Parse(packet[0]);

			Logger.Log($"Received packet: {string.Join(',', receivedPacket)}");

			// TODO: Check for if its a fragmentation packet, or a regular packet
			// TODO: Maybe make all packets fragmentation packets.
			// TODO: Make no packets fragmentation packets if possible

			// Depending on the packet type, handle the packet
			// TODO: Split up all of this into derived packet classes
			string responsePacketString;
			switch (packetType)
			{
				// Client is requesting to join
				case PacketType.PLAYER_CONNECTION_REQUEST:
					// TODO: Do this somewhere else
					responsePacketString = PacketHandler.CreatePlayer(packet);
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
}