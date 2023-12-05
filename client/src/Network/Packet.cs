using System.Net;
using System.Text;

class Packet
{
	private string packetString;

	// Add another packet to the packet string
	public virtual void AddPacket(PacketType packetType, params string[] packet)
	{
		packetString += $"{(int)packetType}|+|{string.Join("|+|", packet)}|&|";
		Console.WriteLine(packetString);
	}

	// Send the packet to the server
	public virtual void Send()
	{
		// Encode the packet to bytes for sending
		byte[] packetBytes = Encoding.ASCII.GetBytes(packetString);

		// Send the packet to the client
		Networking.Client.Send(packetBytes, packetBytes.Length, Networking.Server);
		Console.WriteLine("ask server if can request fr (asking rn)");
	}
}