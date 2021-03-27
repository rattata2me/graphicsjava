package graphicsjava.d3;

import graphicsjava.Entity;
import graphicsjava.math.Matrix;
import static graphicsjava.math.Matrix.mul;
import graphicsjava.math.Mesh;
import graphicsjava.math.Vector;
import graphicsjava.math.Vector2;
import graphicsjava.program.Drawer;
import java.awt.Color;


public class EntityTriangles3d extends Entity{
    public Mesh mesh;
    
    public EntityTriangles3d(Mesh mesh){
        this.mesh = mesh;
    }

    @Override
    public void draw(Matrix worldTransform, Drawer drawer) {
        super.draw(worldTransform, drawer);
        int dx = drawer.p.getDimension()[0]/2;
        int dy = drawer.p.getDimension()[1]/2;
        
        int psize = mesh.points.size();
        Vector2[] vectors = new Vector2[psize];
        boolean[] drawable = new boolean[psize];
        for(int i = 0; i<psize; i++){
            Matrix r = Matrix.mul(worldTransform, transform.mul(mesh.points.get(i)));
            drawable[i] = (r.get(0, 2) >= 0);
            vectors[i] = new Vector2((r.get(0, 0)/r.get(0, 3))+dx, -(r.get(0, 1)/r.get(0, 3))+dy);
        }
        for(int[] connection : mesh.connections){
            boolean draw = true;
            int i = 0;
            while((i < connection.length) && (draw)){
                draw = drawable[connection[i]];
                i++;
            }
            if(draw)
                drawer.drawConnection(vectors, connection, Color.BLACK, 2);
        }
    }
    
}
