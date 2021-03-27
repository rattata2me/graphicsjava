package graphicsjava.math;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph extends Shape{

    public Graph(float[][] points, int[][] lines) {
        super(points, lines, 2);
    }

    public Graph(ArrayList<Vector> points, ArrayList<int[]> lines) {
        super(points, lines, 2);
    }

}
