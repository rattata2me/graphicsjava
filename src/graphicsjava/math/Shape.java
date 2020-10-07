/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicsjava.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rattata
 */
public class Shape {
    
    public ArrayList<Vector> points;
    public ArrayList<int[]> connections;
    public final int connectionsDim;
    
    public Shape(ArrayList<Vector> points, ArrayList<int[]> connections, int connectionsDim){
        this.points = (ArrayList<Vector>) points.clone();
        this.connections = (ArrayList<int[]>) connections.clone();
        this.connectionsDim = connectionsDim;
    }
    
    public Shape(float[][] points, int[][] connections, int connectionsDim){
        this.points = new ArrayList<Vector>();
        this.connections = new ArrayList<int[]>();
        for (float[] point : points){
            float[][] data = new float[1][point.length];
            System.arraycopy(point, 0, data[0], 0, point.length);
            Vector v = new Vector(point.length, data);
            this.points.add(v);
        }
        this.connectionsDim = connectionsDim;
        this.connections.addAll(Arrays.asList(connections));
    }
    
}
