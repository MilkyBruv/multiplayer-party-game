using System.Net;
using System.Text;

class Packet
{
	private string packetString;

	// Add another packet to the packet string
	public virtual void AddPacket(PacketType packetType, params string[] packet)
	{
		packetString += $"{(int)packetType}|+|{string.Join("|+|", packet)}|&|";
	}

	public virtual void Send(IPEndPoint client)
	{
		// Encode the packet to bytes for sending
		byte[] packetBytes = Encoding.ASCII.GetBytes(packetString);

		// Send the packet to the client
		Network.UdpServer.Send(packetBytes, packetBytes.Length, client);
		Logger.Log("Sent data to client");
	}
}