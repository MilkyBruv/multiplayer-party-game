enum PacketType
{
	// When a player would like to connect to the server
	PLAYER_CONNECTION_REQUEST,          // Server
	PLAYER_CONNECTION_REQUEST_ACCEPTED, // Server
	PLAYER_CONNECTION,                  // Client

	// When a player would like to disconnect from the server
	PLAYER_DISCONNECTION_REQUEST, // Server
	PLAYER_DISCONNECTION,         // Client
}

enum PacketPriority
{
	EXPENDABLE, // For when it doesn't matter if a packet is lost
	HIGH        // For when the data must get through 100% of the time
}