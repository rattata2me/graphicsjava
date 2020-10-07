package graphicsjava.math;

public class Vector2 extends Matrix{
    
    public Vector2(float x, float y) {
        super(1, 2, Vector2.d(x, y));
    }
    private static float[][] d(float x, float y){
        float[][] data = {{x, y}};
        return data;
    }
    
}
