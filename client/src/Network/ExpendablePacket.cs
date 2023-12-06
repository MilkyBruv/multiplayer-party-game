using System.Text;

class ExpendablePacket : Packet
{
	// Send the packet to the server
	public void Send()
	{
		// Encode the packet to bytes for sending
		byte[] packetBytes = Encoding.ASCII.GetBytes(packetString);

		// Send the packet to the client
		Networking.Client.Send(packetBytes, packetBytes.Length, Networking.Server);
		Console.WriteLine("ask server if can request fr (asking rn)");
	}
}