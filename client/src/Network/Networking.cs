using System.Net;
using System.Net.Sockets;
using System.Text;

class Networking
{
	public static UdpClient Client { get; private set; }
	public static IPEndPoint Server { get; private set; }
	public static IPAddress ServerIp { get; set; }
	public static int ServerPort { get; set; }

	public static void ConnectToServer(string username, string pfpString)
	{
		// Get the server and client stuff
		Client = new UdpClient();
		Server = new IPEndPoint(ServerIp, ServerPort);

		// Make the connection packet, then send it
		Packet packet = new Packet();
		packet.AddPacket(PacketType.PLAYER_CONNECTION_REQUEST, username, pfpString);
		packet.Send();

		//TODO: Get the players UUID from response
	}
}