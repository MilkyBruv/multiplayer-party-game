class HighPriorityPacket : Packet
{
	public bool WaitingForResponse = false;
	public string Guid;

	// Send the packet
	public void Send()
	{
		// Get the packet a GUID so that it can be identified
		//? Only using the first part of the guid (time sent)
		//? If issues come from this then just use the whole guid
		// TODO: Rename Guid variable so that don't need to do System.Guid
		Guid = System.Guid.NewGuid().ToString().Split('-')[0];

		// Add the packet to a list of packets to be retransmitted
		PacketHandler.retransmissionPackets.Add(this);

		// Send the first request
		Retransmit();
		WaitingForResponse = true;
	}

	// Retransmit the packet until a response has been sent
	public void Retransmit()
	{

	}
}