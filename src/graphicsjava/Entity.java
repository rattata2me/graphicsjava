package graphicsjava;

import graphicsjava.math.Matrix;
import graphicsjava.program.Drawer;

public class Entity implements GraphicalObject {
    
    public Matrix transform;
    protected String name = "";

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void draw(Matrix transform, Drawer drawer) {}
    
    
}
