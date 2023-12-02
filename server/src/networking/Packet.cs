using System.Net;
using System.Text;

class Packet
{
	private string packetString;

	// Add another packet to the packet string
	public virtual void AddPacket(string packet)
	{
		packetString += '+' + packetString.Trim();
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


/*
class FragmentationPacket : Packet
{
	// Max recommended bytes to be sent is 1500, however something like 512 is faster
	// and more stable. Using 1024 to get a decent mix. An additional 41 bytes is removed
	// from the total so that a UUID, and index (up to 999) can be provided to the packet
	// to ensure the fragments arrive in an ordered way. All packets will most likey be 
	// a few bytes under the max size, depending on how many fragments the packet
	// is broken into.
	private const uint reservedSpaceSize = 41;
	private const uint maxFragmentSize = 1024;
	private const uint maxDataSize = maxFragmentSize - reservedSpaceSize;

	List<Byte[]> fragments;

	//! temp packet string (base64 of pfp thats 256x256)
	// TODO: Make pfps 64x64 or maybe something smaller idk
	// TODO: Remember to add `data:image/png;base64,` at the front (client can do this)
	private string packetString = "";

	public override void Send()
	{
		// Generate a UUID for the packet
		string uuid = Guid.NewGuid().ToString();

		// Turn the packet into bytes, then split it up into multiple different "fragments"
		fragments = new List<byte[]>();
		byte[] packetBytes = Encoding.ASCII.GetBytes(packetString);
		for (int i = 0; i < packetBytes.Length / maxDataSize; i++)
		{
			// Generate the identifier to keep track of the fragment
			byte[] identifier = Encoding.ASCII.GetBytes($"{uuid},{i},");

			// Generate the data from the fragment
			byte[] data = new byte[maxDataSize];
			Array.Copy(packetBytes, i * maxDataSize, data, 0, maxDataSize);

			// Stick everything together then add the fragment
			// to the total list of fragments for sending
			byte[] fragment = identifier.Concat(data).ToArray();
			fragments.Add(fragment);
		}
	}
}*/