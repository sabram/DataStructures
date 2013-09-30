package com.shaunabram.datastructures.dynamicprogramming.gridcounter;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        Coordinate c = (Coordinate)o;
        if (this.x == c.x && this.y == c.y) return true;
        return false;
    }

    public int hashCode() {
        int hc = 13;
        hc += x * 17;
        hc += x * 19;
        return hc;
    }
}
