using System.Net;
using System.Net.Sockets;
using System.Text;

class Networking
{
	private static UdpClient Client;
	private static IPEndPoint ServerEndPoint;

	private static void ConnectToServer(string username, string pfpBase64, int port, string address)
	{
		Client = new UdpClient();
		ServerEndPoint = new IPEndPoint(IPAddress.Parse(address), port);

		//! DEBUG: Send a random request thingy
		string message = "yeah im legit the client (connecting me rn)";
		byte[] messageBytes = Encoding.ASCII.GetBytes(message);
		Client.Send(messageBytes, messageBytes.Length, ServerEndPoint);
	}
}