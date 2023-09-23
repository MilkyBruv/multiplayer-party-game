using System;
using System.Net;
using System.Net.Sockets;
using System.Text;

public class UdpClientApp
{
    private const int serverPort = 30814;
    private const string serverAddress = "101.100.136.126";

    public static void Main()
    {
        UdpClient udpClient = new UdpClient();
        IPEndPoint serverEP = new IPEndPoint(IPAddress.Parse(serverAddress), serverPort);

        string message = "chur blud";

        byte[] data = Encoding.UTF8.GetBytes(message);

        udpClient.Send(data, data.Length, serverEP);

        Console.WriteLine("Message sent to server.");

        udpClient.Close();
    }
}
