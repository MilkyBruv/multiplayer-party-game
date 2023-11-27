package mpg.src.shared;

public enum PacketSendType {

	// Stuff where it doesn't really matter if it gets lost
	// because its happening a lot (example is movement)
	EXPENDABLE,

	// Stuff that normally only happens once and can't be skipped
	// (example is a player joining/leaving or a chat message)
	HIGH_PRIORITY
}
