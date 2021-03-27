package graphicsjava.d3;

import graphicsjava.math.Vector2;
import java.util.ArrayList;

public class Material {
    public ArrayList<Vector2> uv;
    public Texture texture;

    public Material(ArrayList<Vector2> uv, Texture texture) {
        this.uv = uv;
        this.texture = texture;
    }
    
    public static class Texture{

        private int id;
        public Texture(int id) {
            this.id = id;
        }
    }
}
