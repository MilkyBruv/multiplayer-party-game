using System.Text;
using Raylib_cs;

class LocalPlayer : Player
{
	public LocalPlayer(string username, string pfpPath)
	{
		// Set the username
		Username = username;

		// Set the pfp
		PfpBytes = File.ReadAllBytes(pfpPath);
		string pfpString = Encoding.ASCII.GetString(PfpBytes);

		// Connect to the server
		Networking.ConnectToServer(username, pfpString);
	}
}