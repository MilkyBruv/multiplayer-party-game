using Raylib_cs;

class LocalPlayer : Player
{
	public LocalPlayer(string username, string pfpPath)
	{
		// Set the username
		Username = username;

		// Get the pfp, and convert it to base64
		//! Assumes that pfp is 128x128
		// TODO: Make sure that the pfp is 128x128 or whatever the pfp size is
		// There are 5 possible ways that I see we could resize: (I think we should do 5)
		// 1) Use System.Drawing. It's very large, and would need to be another library imported. Also we only are going to be doing image manipulation like this a single time so it would be a waste
		// 2) Use a smaller, third-party image manipulation library
		// 3) Manually edit the raw bytes of the image to resize. Clyde said that its an extremely difficult process and advanced knowledge about the format and stuff needs to be known (i don't know)
		// 4) Use an external website/cloud thingy to resize using an API
		// 5) Create a "launcher" in something quick and simple like Python for both launching the game with required arguments, and resizing.
		byte[] pfpBytes = File.ReadAllBytes(pfpPath);
		PfpBase64 = Convert.ToBase64String(pfpBytes);
	}
}