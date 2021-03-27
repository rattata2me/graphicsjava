package graphicsjava.math;

import java.util.ArrayList;

/**
 *
 * @author rattata
 */
public class Mesh extends Shape{
    
    public Mesh(ArrayList<Vector> points, ArrayList<int[]> connections) {
        super(points, connections, 3);
    }

    public Mesh(float[][] points, int[][] connections) {
        super(points, connections, 3);
    }
    
}
