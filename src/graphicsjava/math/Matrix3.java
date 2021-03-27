/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicsjava.math;

/**
 *  3x3 Matrix, mainly for 2D affine transformations.
 */
public class Matrix3 extends Matrix{
    
    public Matrix3(float[][] data){
        super(2, 2, data);
    }
    public Matrix3() {
        super(2, 2);
    }
    
    /**
     *  Returns the 2d rotation matrix linked with an angle in radians.
     */
    public static Matrix3 rotationMatrix(float angle){
        float[][] data = {
            {(float)Math.cos(angle), (float)Math.sin(angle), 0}, 
            {-(float)Math.sin(angle), (float)Math.cos(angle), 0},
            { 0, 0, 1}
        };
        return new Matrix3(data);
    }
    
}
