package com.milad.api.utility.math.vectors.vector2D;

/**
 *
 * @author PC
 */
public class Vector2D {
    
    private double xAxis;
    private double yAxis;
    
    public Vector2D() {
        this.xAxis = 0;
        this.yAxis = 0;
    }

    public Vector2D(double xAxis, double yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Vector2D(int xAxis, int yAxis){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
    public double getxAxis() {
        return xAxis;
    }

    public void setxAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getyAxis() {
        return yAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    
    
    
}
