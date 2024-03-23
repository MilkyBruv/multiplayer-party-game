package event;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

import game.GameEventManager;

public final class KeyEventListener implements KeyListener {

    private GameEventManager game;

    public KeyEventListener(GameEventManager game) {

        this.game = game;

    }




    @Override
    public synchronized void keyPressed(KeyEvent event) {

        // Set index of key code to true as key is pressed
        KeyInfo.pressedKeys[event.getKeyCode()] = true;

    }


    
    @Override
    public synchronized void keyReleased(KeyEvent event) {

        // Return after auto release for typing-style input reading to allow keys to be held properly
        if (event.isAutoRepeat()) {

            return;

        }

        // Set index of key code to false as key is released
        KeyInfo.pressedKeys[event.getKeyCode()] = false;

    }

}
