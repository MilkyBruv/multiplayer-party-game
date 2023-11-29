# Multiplayer Party Game *(MPG)*
Collection of party games that are multiplayer (its a multiplayer party game)

## Feature Ideas:
- Make a multiplayer party game🤬🤬
- Some sort of account system to keep track of stats
- Custom color themes
- Don't make a game longer than a few minutes
- Only one player eliminated each game

## TODO (client)
- [x] make repo🤗

## TODO (server)
- [x] make repo🤗
- [ ] Robust packet creation system
- [ ] Robust packet parsing system
- [ ] Packet sending system
- [ ] Packet receiving system
- [ ] Add packet fragmentation for sending large packets like base64 for pfp


## Wireframes and concept art

## Game ideas
1. **Tag**. One of the players is set to be the tagger, and the other players must escape them. A top-down, or side-scrolling map could work for this, and there could be different abilities that could be acquired by doing tasks. Possible features could be secret doors/teleports, weapons, and other stuff. There will be a time-limit, maybe something short like 45-60seconds and whoever is tagged when the timer ends gets eliminated.

2. **Prop hunt**. Can also be top-down or side-scrolling. If you're found then you get eliminated. If the seeker can't find anyone after 1 minute or something then they are eliminated.

3. **Hide and seek**. The map could be dark, and the seeker gets a torch. When a hider gets hit by the torch, they get out, and like the other games the seeker gets out if they don't find anyone within a time-limit.

4. **Glass Bridge**. Glass bridge game from Squid games. Have a time-limit. More jumps you do more points you get.


## Development notes
- Client should only be reasonable for getting input, rendering, and playing sounds. Everything else will be done on the server side.
- Packet order is not guaranteed, so on high priority packets a timestamp may be needed to be sent in-order to establish connection properly.

## Discord server
You can join the [Discord server](https://discord.gg/kE2F89e9UD) for updates and whatnot.