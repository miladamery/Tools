package com.milad.api.utility.math.vectors.vector3D;

/**
 *
 * @author PC
 */
public class Vector3D {
    
    private double xAxis;
    private double yAxis;
    private double zAxis;
    
    public Vector3D(){ 
         this.xAxis = 0;
         this.yAxis = 0;
         this.zAxis = 0;
    }

    public Vector3D(double xAxis, double yAxis, double zAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
    }

    public Vector3D(int xAxis, int yAxis, int zAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
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

    public double getzAxis() {
        return zAxis;
    }

    public void setzAxis(double zAxis) {
        this.zAxis = zAxis;
    }

    
    
    
}
