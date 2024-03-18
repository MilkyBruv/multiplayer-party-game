package main;

import java.util.ArrayList;
import java.util.List;

import com.raylib.Raylib;
import com.raylib.Jaylib.Color;
import com.raylib.Raylib.Texture;

public class Main
{

    private static boolean isGamepad0Connected = false;
    private static boolean isGamepad1Connected = false;
    private static final List<Player> players = new ArrayList<Player>() {};
    private static Texture playerTexture = null;

    public static void main(String[] args) {

        // Make the raylib window
        Raylib.SetConfigFlags(Raylib.FLAG_WINDOW_ALWAYS_RUN);
        Raylib.SetConfigFlags(Raylib.FLAG_WINDOW_RESIZABLE);
        Raylib.InitWindow(400, 300, "mpg");
        Raylib.SetTargetFPS(144);

        playerTexture = Raylib.LoadTexture("./res/image.png");

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
        
        if (Raylib.IsGamepadAvailable(0) && !isGamepad0Connected) {

            if (Raylib.IsGamepadButtonDown(0, Raylib.GAMEPAD_BUTTON_RIGHT_FACE_DOWN)) {

                players.add(Player.initPlayer(playerTexture));
                isGamepad0Connected = true;

            }

        } if (Raylib.IsGamepadAvailable(1) && !isGamepad1Connected) {

            if (Raylib.IsGamepadButtonDown(1, Raylib.GAMEPAD_BUTTON_RIGHT_FACE_DOWN)) {

                players.add(Player.initPlayer(playerTexture));
                isGamepad1Connected = true;

            }

        }

        for (Player player : players) {
            
            player.update();

        }

    }



    private static void render() {

        Raylib.BeginDrawing();
        Raylib.ClearBackground(new Color(0, 0, 255, 255));

        for (Player player : players) {
            
            player.render();

        }

        Raylib.EndDrawing();

    }



    private static void cleanUp() {
        
        // Close the raylib window and unload content
        Raylib.UnloadTexture(playerTexture);
        //! Do this last
        Raylib.CloseWindow();

    }
}