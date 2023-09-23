using System;
using System.Net;
using System.Net.Sockets;
using System.Text;

public class Server
{
    private const int port = 30814;
    private const string address = "101.100.136.126";

    public static void Run()
    {
        UdpClient server = new UdpClient(port);
        
        Console.WriteLine("Server Listening");

        IPEndPoint clientEndPoint = new IPEndPoint(IPAddress.Any, 0);

        while (true)
        {
            byte[] data = server.Receive(ref clientEndPoint);
            string message = Encoding.UTF8.GetString(data);

            Console.WriteLine($"Received from {clientEndPoint}: {message}");
        }
    }
}