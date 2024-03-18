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

        float invLength = VMath.fastInvSqrt(this.x * this.x + this.y * this.y);
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



    public final Vector2f sub(int val) {

        return new Vector2f(this.x - val, this.y - val);

    }



    public final Vector2f add(int val) {

        return new Vector2f(this.x + val, this.y + val);

    }



    public final Vector2f mul(int val) {

        return new Vector2f(this.x * val, this.y * val);

    }



    public final Vector2f div(int val) {

        return new Vector2f(this.x / val, this.y / val);

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



    public final Vector2f sub(double val) {

        return new Vector2f((int) Math.round(this.x - val), (int) Math.round(this.y - val));

    }



    public final Vector2f add(double val) {

        return new Vector2f((int) Math.round(this.x + val), (int) Math.round(this.y + val));

    }



    public final Vector2f mul(double val) {

        return new Vector2f((int) Math.round(this.x * val), (int) Math.round(this.y * val));

    }



    public final Vector2f div(double val) {

        return new Vector2f((int) Math.round(this.x / val), (int) Math.round(this.y / val));

    }



    public final Vector2f sub(long val) {

        return new Vector2f((int) Math.round(this.x - val), (int) Math.round(this.y - val));

    }



    public final Vector2f add(long val) {

        return new Vector2f((int) Math.round(this.x + val), (int) Math.round(this.y + val));

    }



    public final Vector2f mul(long val) {

        return new Vector2f((int) Math.round(this.x * val), (int) Math.round(this.y * val));

    }



    public final Vector2f div(long val) {

        return new Vector2f((int) Math.round(this.x / val), (int) Math.round(this.y / val));

    }

}