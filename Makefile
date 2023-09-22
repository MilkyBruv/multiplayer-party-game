build:
	g++ -c src/*.cpp
	g++ -o src/game *.o -L./ -llib/raylib
	.\src\game