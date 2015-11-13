package com.milad.api.utility.math;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import com.milad.api.utility.math.vectors.vector2D.Vector2D;
import com.milad.api.utility.math.vectors.vector3D.Vector3D;

/**
 *
 * @author PC
 */
public class RandomUniqueVectorGenerator {

    private final static int randConst = 20;
    
    public static Vector2D[] getRandomInt2DVectors(int nums) {
        HashSet<Integer> xAxis = new HashSet<>();
        HashSet<Integer> yAxis = new HashSet<>();

        int xRand, yRand ,randBount = randConst * nums;
        for (int i = 0; i < nums; i++) {
            do {
                Random r = new Random();
                xRand = r.nextInt(randBount);                
            } while (xAxis.contains(xRand));
            xAxis.add(xRand);
            do {
                Random r = new Random();
                yRand = r.nextInt(randBount);
            } while (yAxis.contains(yRand));
            yAxis.add(yRand);
        }
        
        int[] x = new int[nums];        
        int i = 0;
        Iterator<Integer> xIt = xAxis.iterator();
        while(xIt.hasNext()){
            x[i] = xIt.next();            
            i++;
        }
        
        int[] y = new int[nums];
        i = 0;
        Iterator<Integer> yIt = yAxis.iterator();
        while(yIt.hasNext()){
            y[i] = yIt.next();            
            i++;
        }
        
        Vector2D[] vecs = new Vector2D[nums];
        for(i = 0; i < nums; i++){
            vecs[i] = new Vector2D(x[i], y[i]);            
        }
        
        return vecs;
    }

    public static Vector3D[] getRandomInt3DVectors(int nums) {
        HashSet<Integer> xAxis = new HashSet<>();
        HashSet<Integer> yAxis = new HashSet<>();
        HashSet<Integer> zAxis = new HashSet<>();
        
        int xRand, yRand, zRand ,randBount = randConst * nums;
        Iterator<Integer> iterator;
        for(int i=0; i < nums; i++){
            do{
                Random r = new Random();
                xRand = r.nextInt(randBount);
            }while(xAxis.contains(xRand));
            xAxis.add(xRand);
            
            do{
                Random r = new Random();
                yRand = r.nextInt(randBount);
            }while(yAxis.contains(yRand));
            yAxis.add(yRand);
            
            do{
                Random r = new Random();
                zRand = r.nextInt(randBount);
            }while(zAxis.contains(zRand));
            zAxis.add(zRand);
        }
        
        int[] x = new int[nums];
        int i = 0;
        iterator = xAxis.iterator();
        while(iterator.hasNext()){
            x[i] = iterator.next();
            i++;
        }
        
        int[] y = new int[nums];
        i = 0;
        iterator = yAxis.iterator();
        while(iterator.hasNext()){
            y[i] = iterator.next();
            i++;
        }
        
        int[] z = new int[nums];
        i = 0;
        iterator = zAxis.iterator();
        while(iterator.hasNext()){
            z[i] = iterator.next();
            i++;
        }
        
        Vector3D[] vecs = new Vector3D[nums];
        for(i = 0; i < nums; i++)
            vecs[i] = new Vector3D((Integer)x[i], (int)y[i], (int)z[i]);
        return vecs;
    }
}
