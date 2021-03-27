package graphicsjava.math;

import java.util.Arrays;
/**
 * Class intended for Matrix handling.
 * Made with generality an abstraction in mind
 * with a considerable decrement in speed.
 */
public class Matrix {
    private float[][] data;
    private int cols, rows;
    
    /**
     * Creates a Matrix, data should be organised as a two dimensional 
     * array with dimension [cols][rows].
    */
    public Matrix(int cols, int rows, float[][] data){
        this.data = data.clone();
        this.cols = cols;
        this.rows = rows;
    }
    
    /**
     * Generates an empty Matrix.
     */
    public Matrix(int cols, int rows){
        this(cols, rows, new float[cols][rows]);
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
    
    public float get(int x, int y){
        return this.data[x][y];
    }
    public void set(int x, int y, float value){
        this.data[x][y] = value;
    }

    public Matrix add(Matrix b){
        return Matrix.add(this, b);
    }
    public Matrix mul(Matrix b){
        return Matrix.mul(this, b);
    }
    
    @Override
    public String toString() {
        String r = "{";
        for(int i = 0; i<data.length-1; i++){
            r = r+Arrays.toString(data[i])+", ";
        }
        r = r+Arrays.toString(data[data.length-1])+"}";
        return ("Cols: "+this.cols+" Rows: "+this.rows+" "+r);
    }
    
    public static Matrix add(Matrix a, Matrix b){
        Matrix r;
        if((a.getCols() == b.getCols())&&(a.getRows() == b.getRows())){
            r = new Matrix(b.getCols(), a.getRows());
            for(int k = 0; k < b.getCols(); k++){
                for(int i = 0; i < a.getRows(); i++){
                    r.set(k, i, a.get(k, i)+b.get(k, i));
                }
            }
        }else{
            r = a;
        }
        return r;
    }
    
    public static Matrix scale(Matrix a, float y){
        Matrix r = new Matrix(a.getCols(), a.getRows());
        for(int k = 0; k < a.getCols(); k++){
            for(int i = 0; i < a.getRows(); i++){
                r.set(k, i, a.get(k, i)*y);
            }
        }
        return r;
    }
    
    public static Matrix mul(Matrix a, Matrix b){
        Matrix r;
        if(a.getCols() == b.getRows()){
            r = new Matrix(b.getCols(), a.getRows());
        
            for(int k = 0; k < b.getCols(); k++){
                for(int i = 0; i < a.getRows(); i++){
                    float sum = 0f;
                    for(int j = 0; j < b.getRows(); j++){
                        sum += b.get(k, j)*a.get(j, i);
                    }
                    r.set(k, i, sum);
                }
            }
        }else{
            r = a;
        }
        return r;
    }
}
