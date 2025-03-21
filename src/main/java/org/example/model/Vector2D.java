package org.example.model;

public class Vector2D extends Object {

    private double x;
    private double y;
    private Double abs;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
        this.abs = null;
    }

    public double getAbs() {
        if (abs == null) {
            abs = Math.sqrt(x * x + y * y);
        }
        return abs;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + this.y + ")";
    }

    // A subset B subset C
    // boolean equals(C b)
    // a.equals(a)

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vector2D vector2D = (Vector2D) o;
        return Double.compare(getX(), vector2D.getX()) == 0 && Double.compare(getY(), vector2D.getY()) == 0;
    }
}
