package event;

public class KeyInfo {
    
    public static boolean[] pressedKeys = new boolean[Short.MAX_VALUE];

    /**
     * Returns pressedKeys boolean value of index {@param keyCode}
     * 
     * @param keyCode
     * @return Boolean value of index {@param keyCode}
     */
    public static final boolean isKeyPressed(short keyCode) {

        return pressedKeys[keyCode];

    }

}
