package com.milad.api.utility.math.vectors.vector2D;

/**
 *
 * @author PC
 */
public class Vec2DMath {
    
    /**
     * 
     * @param vec1 First Vector
     * @param vec2 Second Vector
     * @return vec1 + vec2
     */
    public static Vector2D summation(Vector2D vec1, Vector2D vec2){        
        
        Vector2D newVec = new Vector2D();
        newVec.setxAxis(vec1.getxAxis() + vec2.getxAxis());
        newVec.setyAxis(vec1.getyAxis() + vec2.getyAxis());
        return newVec;
    }
    
    /**
     * 
     * @param vec1
     * @param vec2
     * @return vec1 + (-1 * vec2)
     */
    public static Vector2D subtraction(Vector2D vec1, Vector2D vec2){
        
        Vector2D newVec = Vec2DMath.summation(vec1, Vec2DMath.multiplication(vec2, -1));
        return newVec;
    }
    
    /**
     * 
     * @param vec
     * @param scalar
     * @return vec * scalar
     */
    public static Vector2D multiplication(Vector2D vec, double scalar){
       
        Vector2D newVec = new Vector2D();
        newVec.setxAxis(vec.getxAxis() * scalar);
        newVec.setyAxis(vec.getyAxis() * scalar);
        return newVec;
    }
    
    /**
     * Calculates square root of (vec.x ^ 2) + (vec.y ^ 2)
     * @param vec
     * @return |vec|
     */
    public static double value(Vector2D vec){
        return Math.sqrt((Math.pow(vec.getxAxis(), 2)) + (Math.pow(vec.getyAxis(), 2)));
    }
    
    /**
     * Calculates the distance between two vectors
     * @param vec1
     * @param vec2
     * @return |Vec1Vec2|
     */
    public static double distance(Vector2D vec1, Vector2D vec2){
        return Math.sqrt(Math.pow(vec1.getxAxis() - vec2.getxAxis(), 2) + Math.pow(vec1.getyAxis() - vec2.getyAxis(), 2));
    }
    
    /**
     * 
     * @param vec
     * @param scalar
     * @return vec / scalar
     */
    public static Vector2D division(Vector2D vec ,double scalar){
        Vector2D newVec = Vec2DMath.multiplication(vec, (1/scalar));
        return newVec;
    }
    
    /**
     * 
     * @param vec
     * @return Direction vector of vec 
     */
    public static Vector2D directionVector(Vector2D vec){
        double value = Vec2DMath.value(vec);
        Vector2D newVec = new Vector2D();
        newVec.setxAxis(vec.getxAxis() / value);
        newVec.setyAxis(vec.getyAxis() / value);
        return newVec;
    }
    
    /**
     * 
     * @param vec1
     * @param vec2
     * @return vec1.vec2
     */
    public static double dotProduct(Vector2D vec1, Vector2D vec2){
        return (vec1.getxAxis() * vec2.getxAxis()) + (vec1.getyAxis() * vec2.getyAxis());
    }
    
}
