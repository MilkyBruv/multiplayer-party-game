#include <iostream>
#include <raylib.h>

// Free mind crat 2012

int main()
{
	std::cout << "running rn" << std::endl;

	const int screenWidth = 800;
	const int screenHeight = 600;

	InitWindow(screenWidth, screenHeight, "mising semicolon line 3");
	SetTargetFPS(60);

	// Set the window icon
	Image icon = LoadImage("./assets/gui/logo.png");
	SetWindowIcon(icon);

	while (!WindowShouldClose())
	{
		BeginDrawing();
		ClearBackground(PINK);

		DrawText("yeah buddy...", 20, 20, 40, WHITE);

		EndDrawing();
	}

	CloseWindow();

	// Get rid of the icon
	UnloadImage(icon);

	return 0;
}