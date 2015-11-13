package com.milad.api.utility.math.vectors.vector3D;

/**
 *
 * @author PC
 */
public class Vec3DMath {
    
    /**
     * 
     * @param vec1
     * @param vec2
     * @return vec1 + vec2
     */
    public static Vector3D summation(Vector3D vec1, Vector3D vec2){
        
        Vector3D newVec = new Vector3D();
        newVec.setxAxis(vec1.getxAxis() + vec2.getxAxis());
        newVec.setyAxis(vec1.getyAxis() + vec2.getyAxis());
        newVec.setzAxis(vec1.getzAxis() + vec2.getzAxis());
        return newVec;
    }
    
    /**
     * 
     * @param vec1
     * @param vec2
     * @return vec1 - vec2
     */
    public static Vector3D subtraction(Vector3D vec1, Vector3D vec2){
        Vector3D newVec = Vec3DMath.summation(vec1, Vec3DMath.multiplication(vec2, -1));
        return newVec;
    }
    
    /**
     * 
     * @param vec
     * @param scalar
     * @return vec * scalar
     */
    public static Vector3D multiplication(Vector3D vec, double scalar){
        Vector3D newVec = new Vector3D();
        newVec.setxAxis(vec.getxAxis() * scalar);
        newVec.setyAxis(vec.getyAxis() * scalar);
        newVec.setzAxis(vec.getzAxis() * scalar);
        return newVec;
    }
    
    /**
     * 
     * @param vec
     * @return |vec|
     */
    public static double value(Vector3D vec){
        return Math.sqrt(Math.pow(vec.getxAxis(), 2) + Math.pow(vec.getyAxis(), 2) + Math.pow(vec.getzAxis(), 2));
    }
    
    /**
     * Calculates the distance between two vectors
     * @param vec1
     * @param vec2
     * @return |Vec1Vec2|
     */
    public static double distance(Vector3D vec1, Vector3D vec2){
        return Math.sqrt(Math.pow((vec1.getxAxis() - vec2.getxAxis()), 2) + Math.pow((vec1.getyAxis() - vec2.getyAxis()), 2) + 
                Math.pow((vec1.getzAxis() - vec2.getzAxis()), 2));
    }
    
    /**
     * 
     * @param vec
     * @param scalar
     * @return vec / scalar
     */
    public static Vector3D division(Vector3D vec, double scalar){
        return Vec3DMath.multiplication(vec, (1 / scalar));
    }
    
    /**
     * 
     * @param vec
     * @return Direction vector of vec 
     */
    public static Vector3D directionVector(Vector3D vec){
        double value = Vec3DMath.value(vec);
        Vector3D newVec = new Vector3D();
        newVec.setxAxis(vec.getxAxis() / value);
        newVec.setyAxis(vec.getyAxis() / value);
        newVec.setzAxis(vec.getzAxis() / value);
        return newVec;
    }
    
    /**
     * Calculating dot Product of two vectors
     * @param vec1
     * @param vec2
     * @return vec1.vec2
     */
    public static double dotProduct(Vector3D vec1, Vector3D vec2){
        return (vec1.getxAxis() * vec2.getxAxis()) + (vec1.getyAxis() * vec2.getyAxis()) +
                (vec1.getzAxis() + vec2.getzAxis());
    }
    
    /**
     * Calculating Cross Product of two vectors
     * @param vec1
     * @param vec2
     * @return vec1 * vec2
     */
    public static Vector3D crossProduct(Vector3D vec1, Vector3D vec2){
        double x = (vec1.getyAxis() * vec2.getzAxis()) - (vec1.getzAxis() * vec2.getyAxis());
        double y = (vec1.getzAxis() * vec2.getxAxis()) - (vec1.getxAxis() * vec2.getzAxis());
        double z = (vec1.getxAxis() * vec2.getyAxis()) - (vec1.getyAxis() * vec2.getxAxis());
        Vector3D newVec = new Vector3D(x, y, z);
        return newVec;
    }
}

