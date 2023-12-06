class PacketHandler
{
	public static List<HighPriorityPacket> retransmissionPackets = new List<HighPriorityPacket>();

	public static void RetransmitPackets()
	{
		// Loop through all retransmission packets and check for if there is a
		// packet that needs resending
		foreach (HighPriorityPacket packet in retransmissionPackets)
		{
			
		}
	}

}