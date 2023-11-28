class Network
{
	public static void Listen()
	{
		Logger.Log("Begin listening rn");

		//! debug
		FragmentationPacket fragmentationPacket = new FragmentationPacket();
		fragmentationPacket.Send();

		while (true)
		{
			Logger.Log("currently networking");
		}
	}
}