﻿using System.Net;
using System.Net.Sockets;

class Program
{
	public static void Main(string[] args)
	{
		// Check for if the port was added as an argument
		if (args.Length <= 0)
		{
			Console.WriteLine("\n\nInsufficient arguments provided!\n");
			Console.WriteLine("arg1: port (uint)");
			Console.WriteLine("Example: Server.exe 12345");

			Console.WriteLine("\nPress any key to continue...");
			Console.ReadKey();
			return;
		}

		Start();
	}

	private static void Start()
	{
		// Create a thread for the networking stuff
		Thread networkThread = new Thread(Network.Listen);
		networkThread.Start();

		// Create a thread for the server logic stuff
		Thread updateThread = new Thread(Server.Update);
		updateThread.Start();
	}
}