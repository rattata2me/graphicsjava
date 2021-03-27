package graphicsjava.math;

/**
 *
 * @author rattata
 */
public class Matrix4 extends Matrix{
    
    public Matrix4(float[][] data){
        super(4, 4, data);
    }
    public Matrix4() {
        super(4, 4);
    }
    
    public static Matrix4 projectionMatrix(float fov, float near, float far) { 
        float scale = (float)(1/Math.tan(fov * 0.5 * Math.PI / 180)); 
        float[][] data = {
            {scale, 0, 0, 0},
            {0, scale, 0, 0},
            {0, 0, -far / (far - near), -far * near / (far - near)},
            {0, 0, -1, 0}
        };
        return new Matrix4(data);
    }
    public static Matrix4 translationMatrix(float x, float y, float z){
        float[][] data = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {x, y, z, 1}
        };
        return new Matrix4(data);
    }
    public static Matrix4 roatationMatrix(float a, float b, float c){
        float cosa = (float)Math.cos(a), sina = (float)Math.sin(a);
        float cosb = (float)Math.cos(b), sinb = (float)Math.sin(b);
        float cosc = (float)Math.cos(c), sinc = (float)Math.sin(c);
        float[][] data = {
             {
                 cosa*cosb,
                 sina*cosb,
                 -sinb, 
                 0
             },
             {
                 cosa*sinb*sinc-sina*cosc,
                 sina*sinb*sinc+cosa*cosc,
                 cosb*sinc,
                 0
             },
             {
                 cosa*sinb*cosc+sina*sinc,
                 sina*sinb*cosc-cosa*sinc,
                 cosb*cosc,
                 0
             },
             {
                 0, 0, 0, 1
             }
        };
        return new Matrix4(data);
    }

    public static Matrix scale(Matrix a, float y){
        Matrix r = Matrix.scale(a, y);
        r.set(3, 3, 1);
        return r;
    }
}
