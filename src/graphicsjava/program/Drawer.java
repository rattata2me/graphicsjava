/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicsjava.program;

import graphicsjava.d3.Material.Texture;
import graphicsjava.math.Shape;
import graphicsjava.math.Vector2;
import java.awt.Color;

/**
 *
 * @author rattata
 */
public class Drawer {
    public Program p;
    
    public Drawer(Program p){
        this.p = p;
    }
    
    public void updateDrawer(){}

    public void clearScreen(Color color){}
    public void drawLine(int x, int y, int x2, int y2, Color color, int thickness) {}
    public void drawConnection(Vector2[] vectors, int[] connections, Color color, int thickness) {}
    public void drawTexturedTriangle(Vector2[] points, Vector2[] uvs, Texture texture){}
}
