#include <iostream>
#include "../lib/raylib/include/raylib.h"

int main(void)
{
    const int screenWidth = 800;
    const int screenHeight = 600;

    InitWindow(screenWidth, screenHeight, "Test Window");
    SetTargetFPS(60);

    while (!WindowShouldClose())
    {
        BeginDrawing();
        {
            ClearBackground(RAYWHITE);
            DrawText("chur blud", 20, 20, 20, BLACK);
        }
        EndDrawing();
    }

    CloseWindow();

    return 0;
}