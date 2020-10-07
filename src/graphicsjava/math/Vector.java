package graphicsjava.math;

public class Vector extends Matrix{

    public Vector(int n) {
        super(1, n);
    }
    
    public Vector(int n, float[][] data) {
        super(1, n, data);
    }
    
    
}
