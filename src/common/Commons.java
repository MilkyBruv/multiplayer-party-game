package common;

public abstract class Commons {
    
    public static final boolean inRange(int val, int bottom, int top) {

        if (val >= bottom && val <= top) {

            return true;

        }

        return false;

    }

}
