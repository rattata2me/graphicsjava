package graphicsjava.program;

import graphicsjava.Entity;
import graphicsjava.d3.EntityTriangles3d;
import graphicsjava.math.Matrix;
import graphicsjava.math.Matrix4;
import graphicsjava.math.Mesh;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GraphicsJavaTestProgram extends Program{

    public GraphicsJavaTestProgram(ProgramConfig config) {
        super(config);
    }
    
    public static float[][] cube_points = {
        {0, 0, 0, 1}, {1, 0, 0, 1}, {0, 1, 0, 1}, {1, 1, 0, 1},
        {0, 0, 1, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}
    };
    public static int[][] cube_faces = {
        {0, 4, 5}, {0, 1, 5}, {2, 6, 7}, {2, 3, 7},
        {0, 2, 3}, {0, 1, 3}, {1, 3, 7}, {1, 5, 7},
        {5, 7, 6}, {5, 4, 6}, {4, 6, 2}, {4, 0, 2}
    };

    private Matrix worldTransform;
    private Matrix4 projectionTransform;
    private Matrix4 translationTransform;
    private Matrix4 linearTransform;
    Entity cube;
    @Override
    public void onStart() {
        linearTransform = Matrix4.roatationMatrix(0, 0, 0);
        System.out.println(linearTransform);
        translationTransform =  Matrix4.translationMatrix( 0, 0, -4f);
        projectionTransform = Matrix4.projectionMatrix(45, 0.004f, 50);
        worldTransform = projectionTransform.mul(translationTransform.mul(linearTransform));
        Mesh cubeMesh = new Mesh(cube_points, cube_faces);
        System.out.println(worldTransform.mul(cubeMesh.points.get(1)));
        cube = new EntityTriangles3d(cubeMesh);
    }

    
    int time = 0;
    @Override
    public void update() {
        time++;
        cube.transform = Matrix4.roatationMatrix(0, time/100f, 0).mul(Matrix4.translationMatrix( -0.5f, -0.5f, -0.5f));
        worldTransform = projectionTransform.mul(linearTransform.mul(translationTransform));
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(GraphicsJavaTestProgram.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void render() {
        drawer.clearScreen(Color.yellow);

        cube.draw(worldTransform, drawer);
    }

    
    
    
    public static void main(String[] args){
        ProgramConfig c = (new ProgramConfig()).name("Demo").dimensions(720, 480);
        GraphicsJavaTestProgram p = new GraphicsJavaTestProgram(c);
        p.start();
        p.run();
        p.end();
    }

    
    
}
