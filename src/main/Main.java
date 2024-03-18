package main;

import java.util.ArrayList;
import java.util.List;

import com.raylib.Raylib;
import com.raylib.Jaylib.Color;

public class Main
{

    private static boolean isGamepad0Connected = false;
    private static boolean isGamepad1Connected = false;
    private static final List<Player> players = new ArrayList<Player>() {};

    public static void main(String[] args) {

        // Make the raylib window
        Raylib.SetConfigFlags(Raylib.FLAG_WINDOW_ALWAYS_RUN);
        Raylib.SetConfigFlags(Raylib.FLAG_WINDOW_RESIZABLE);
        Raylib.InitWindow(400, 300, "mpg");
        Raylib.SetTargetFPS(144);

        // Main game loop
        start();

        while (!Raylib.WindowShouldClose()) {
            
            update();
            render();

        }

        cleanUp();

    }



    private static void start() {

        // 

    }



    private static void update() {
        
        if (Raylib.IsGamepadAvailable(0)) {

            if (Raylib.IsGamepadButtonDown(0, Raylib.GAMEPAD_BUTTON_RIGHT_FACE_DOWN) && !isGamepad0Connected) {

                players.add(Player.initPlayer(null));
                isGamepad0Connected = true;

            }

        } if (Raylib.IsGamepadAvailable(1)) {

            if (Raylib.IsGamepadButtonDown(1, Raylib.GAMEPAD_BUTTON_RIGHT_FACE_DOWN) && !isGamepad1Connected) {

                players.add(Player.initPlayer(null));
                isGamepad1Connected = true;

            }

        }

    }



    private static void render() {

        Raylib.BeginDrawing();
        Raylib.ClearBackground(new Color(0, 255, 0, 255));

        for (Player player : players) {
            
            player.render();

        }

        Raylib.EndDrawing();

    }



    private static void cleanUp() {
        
        // Close the raylib window
        //! Do this last
        Raylib.CloseWindow();

    }
}