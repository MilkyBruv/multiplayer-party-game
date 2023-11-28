# Networki
Packets are "chunks" of information that can be sent between the server, and the client. Normally, the client sends a packet to the server, where it is then re-distributed to all connected clients.

# Packet Structure
All packets must follow this format:
```py
<PacketType - uint>,<PacketStatus - uint>,<data>,<data>,<data>,<etc...>
```