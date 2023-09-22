#include <iostream>
#include <raylib.h>

int main()
{
    std::cout << "running rn" << std::endl;

    const int screenWidth = 800;
    const int screenHeight = 600;


    InitWindow(screenWidth, screenHeight, "mising semicolon line 3");
    SetTargetFPS(60);

    while (!WindowShouldClose())
    {
        BeginDrawing();
        ClearBackground(PINK);

        DrawText("yeah buddy...", 20, 20, 40, WHITE);

        EndDrawing();
    }

    CloseWindow();
    return 0;
}