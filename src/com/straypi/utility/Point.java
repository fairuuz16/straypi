package com.straypi.utility;

public class Point {
    public int x, y;

    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void translate(int dX, int dY){
        this.x += dX;
        this.y += dY;
    }

    public void scale(int rX, int rY){
        this.x *= rX;
        this.y *= rY;
    }

    public Point scaled(int rX, int rY){
        Point p = new Point(this);
        p.scale(rX, rY);
        return p;
    }

    public double getDistance(Point p){
        double dX = (double)(this.x-p.x);
        double dY = (double)(this.y-p.y);
        return Math.sqrt(dX*dX + dY*dY);
    }

}
