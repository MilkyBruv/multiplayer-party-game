package vector;

public final class Vector2f {
    
    public float x;
    public float y;

    public Vector2f() { }

    public Vector2f(float x, float y) {

        this.x = x;
        this.y = y;

    }

    public Vector2f(Vector2f vec) {

        this.x = vec.x;
        this.y = vec.y;

    }

    public final float get(int i) {

        float[] xy = {this.x, this.y};

        return xy[i];

    }

    public final void zero() {

        this.x = 0;
        this.y = 0;

    }

    public final void set(float x, float y) {

        this.x = x;
        this.y = y;

    }

    public final void set(Vector2f vec) {

        this.x = vec.x;
        this.y = vec.y;

    }

    public final float length() {

        return (float) Math.sqrt(this.lengthSquared());

    }

    public final Vector2f normalize(Vector2f dest) {

        float l = this.length();

        if (dest == null) {

            dest = new Vector2f(this.x / l, this.y / l);

        } else {

            dest.set(x / l, y / l);

        }

        return dest;

    }



    public final Vector2f normalize() {

        float invLength = Vector2f.fastInvSqrt(this.x * this.x + this.y * this.y);
        this.x = this.x * invLength;
        this.y = this.y * invLength;

        return this;

    }



    public final float dot(Vector2f vec) {

        return this.x * vec.x + this.y * vec.y;

    }



    public final float lengthSquared() {

        return this.x * this.x + this.y * this.y;

    }



    public final Vector2f sub(Vector2f vec) {

        return new Vector2f(this.x - vec.x, this.y - vec.y);

    }



    public final Vector2f add(Vector2f vec) {

        return new Vector2f(this.x + vec.x, this.y + vec.y);

    }



    public final Vector2f mul(Vector2f vec) {

        return new Vector2f(this.x * vec.x, this.y * vec.y);

    }



    public final Vector2f div(Vector2f vec) {

        return new Vector2f(this.x / vec.x, this.y / vec.y);

    }



    public final Vector2f sub(float val) {

        return new Vector2f(Math.round(this.x - val), Math.round(this.y - val));

    }



    public final Vector2f add(float val) {

        return new Vector2f(Math.round(this.x + val), Math.round(this.y + val));

    }



    public final Vector2f mul(float val) {

        return new Vector2f(Math.round(this.x * val), Math.round(this.y * val));

    }



    public final Vector2f div(float val) {

        return new Vector2f(Math.round(this.x / val), Math.round(this.y / val));

    }



    public final Vector2f sub(float x, float y) {

        return new Vector2f(Math.round(this.x - x), Math.round(this.y - y));

    }



    public final Vector2f add(float x, float y) {

        return new Vector2f(Math.round(this.x + x), Math.round(this.y + y));

    }



    public final Vector2f mul(float x, float y) {

        return new Vector2f(Math.round(this.x * x), Math.round(this.y * y));

    }



    public final Vector2f div(float x, float y) {

        return new Vector2f(Math.round(this.x / x), Math.round(this.y / y));

    }



    public static final float fastInvSqrt(float n) {

        float nhalf = 0.5f * n;
        int i = Float.floatToIntBits(n);

        i = 0x5f3759df - (i >> 1);
        n = Float.intBitsToFloat(i);
        n *= (1.5f - nhalf * n * n);

        return n;

    }



    public final void rotateAroundVector(Vector2f cent, float angle) {

        Vector2f c = cent;
        float a = (float) Math.toRadians(angle);

        Vector2f newVec = new Vector2f(

            (int) Math.round(((this.x - c.x) * Math.cos(a)) - ((c.y - this.y) * Math.sin(a)) + c.x),
            (int) Math.round(((c.y - this.y) * Math.cos(a)) + ((this.x - c.x) * Math.sin(a)) + c.y)

        );

        this.set(newVec.x, newVec.y);

    }

}