package graphicsjava;

import graphicsjava.math.Matrix;
import graphicsjava.program.Drawer;

public interface GraphicalObject {
    
    public void draw(Matrix transform, Drawer drawer);
    public Matrix getTransform();
    public String getName();
    public void setName(String name);
    
}
