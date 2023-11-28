class Logger
{
	public static void Log(object message)
	{
		// Get the time that the log was sent
		string time = DateTime.Now.ToString("HH:mm:ss.fff");

		// Print the message
		// TODO: Add colors
		Console.WriteLine($"[{time}]\t\t{message.ToString()}");
	}
}