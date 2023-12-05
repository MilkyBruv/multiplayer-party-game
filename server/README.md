# Networki
Packets are "chunks" of information that can be sent between the server, and the client. Normally, the client sends a packet to the server, where it is then re-distributed to all connected clients.

# Packet Structure
All packets are strings, however they can contain stringified bytes. Multiple packets can be stringed together. To do this, they are separated with the string `"|&|"`. Individual elements of a packet are split using this string: `"|+|"`.

---

### Client wants to connect
`Client -> Server`
This is sent by a client to the server when a new client wants to connect.
| Packet Type | Username | Profile Picture (64x64) |
|-------------|----------|-------------------------|
| uint | string | stringified bytes (string) |
| 0 | Bob | ?PNG ??? IHDR??? ??? ???szz????sRGB???????g etc...|

---

### Client connection request accepted
`Server -> Client`
This is sent back to the client to tell them that they have been added to the server. Following this, [Client connection](#Client-is-connecting) will be sent for all the already online players.
| Packet Type | New UUID |
|-------------|----------|
| uint | string |
| 1    | f16d6f6b-1ecd-4208-8702-082348eb9c12 |

---

### Client is connecting
`Server -> Client`
Sent when a new client is connecting.
| Packet Type | Username | Profile Picture (64x64) | Was previously in the game |
|-------------|----------|-------------------------|----------------------------|
| uint | string | stringified bytes (string) | uint-ified bool |
| 2 | Bob | ?PNG ??? IHDR??? ??? ???szz????sRGB???????g etc...| 0 |

---

### Client is requesting to leave
`Client -> Server`
This request can never be denied, however the player will have to wait for their disconnection packet to get through or they will get a timed out packet. Reasons below:
| Packet Type | UUID that wants to disconnect |
|-------------|-------------------------------|
| uint | string |
| 3 | f16d6f6b-1ecd-4208-8702-082348eb9c12 |

---

### Client has disconnected
`Server - Client`
This is sent to tell the clients that a client has disconnected. Below are the reasons:

0. Player disconnected themselves
1. Player was timed out (connection issues)
2. Forcefully kicked

| Packet Type | UUID of player that disconnected | Reason |
|-------------|----------------------------------|--------|
| uint | string | uint |
| 4 | f16d6f6b-1ecd-4208-8702-082348eb9c12 | 0 |