class Program
{
	public static string[] Arguments;

	public static void Main(string[] args)
	{
		// Check for if the username, and pfp path was added as arguments
		// TODO: Also check for server port and ip
		if (args.Length < 2)
		{
			Console.WriteLine("\n\nInsufficient arguments provided!\n");
			Console.WriteLine("arg1: Username (string)");
			Console.WriteLine("arg2: Profile Picture Path (string)");
			Console.WriteLine("Example: Client.exe Bob, ./pfp.png");

			Console.WriteLine("\nPress any ke to continue...");
			Console.ReadKey(false);
			return;
		}

		// TODO: Split up the args so specific stuff can be gotten. Example: Program.SuppliedUsername, etc...
		Arguments = args;
		Game.Run();
	}
}