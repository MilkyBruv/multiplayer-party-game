package mpg.src.shared;

// TODO: Split up stuff that the client sends and stuff that the server sends into different enums
public enum PacketType {
	
	// Client sends these to the server when they want to
	// connect or disconnect from the game.
	CLIENT_CONNECTING,
	CLIENT_DISCONNECTING,

	// Server sends these to the clients when a client has
	// connected or disconnected from the game.
	CLIENT_CONNECTED,
	CLIENT_DISCONNECTED
}