using System.Net;
using System.Text;

class Packet
{
	protected string packetString;

	// Add another packet to the packet string
	// TODO: Maybe don't do this for high-priority packets
	public virtual void AddPacket(PacketType packetType, params string[] packet)
	{
		packetString += $"{(int)packetType}|+|{string.Join("|+|", packet)}|&|";
	}

    public override string ToString()
    {
        return packetString.Replace("|+|", ", ").Replace("\n", "").Replace("|&|", "\n");
    }
}