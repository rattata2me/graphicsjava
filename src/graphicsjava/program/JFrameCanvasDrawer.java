/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicsjava.program;

import graphicsjava.d3.Material;
import graphicsjava.math.Vector2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameCanvasDrawer extends Drawer{

    
    private final JFrame frame;
    public Screen screen;
    public Graphics2D graphic2d;
    public ArrayList<BufferedImage> images;

    public JFrameCanvasDrawer(Program p) {
        super(p);
        frame = new JFrame(p.getName());
        screen = new Screen(this);
        frame.add(screen);
        int[] d = p.getDimension();
        frame.setSize(d[0], d[1]);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void updateDrawer() {
        screen.repaint();
    }

    public void clearScreen(Color color){
        Color t = graphic2d.getColor();
        graphic2d.setColor(color);
        
        graphic2d.fillRect(0, 0, p.getDimension()[0], p.getDimension()[1]);
        
        graphic2d.setColor(t);
    }
    
    @Override
    public void drawLine(int x, int y, int x2, int y2, Color color, int thickness) {
        if(screen.isOnDraw()){
            Color t = graphic2d.getColor();
            graphic2d.setColor(color);
            Stroke s = graphic2d.getStroke();
            graphic2d.setStroke(new BasicStroke(thickness));
            graphic2d.drawLine(x, y, x2, y2);
            graphic2d.setColor(t);
        }
    }

    @Override
    public void drawConnection(Vector2[] vectors, int[] connections, Color color, int thickness) {
        for(int i = 0; i < connections.length-1; i++){
            drawLine((int)(vectors[connections[i]].get(0, 0)), 
                    (int)(vectors[connections[i]].get(0, 1)),
                    (int)(vectors[connections[i+1]].get(0, 0)), 
                    (int)(vectors[connections[i+1]].get(0, 1)),color, thickness);
        }
        if(connections.length > 2){
            drawLine((int)(vectors[connections[0]].get(0, 0)), 
                    (int)(vectors[connections[0]].get(0, 1)),
                    (int)(vectors[connections[connections.length-1]].get(0, 0)), 
                    (int)(vectors[connections[connections.length-1]].get(0, 1)),color, thickness);
        }
    }

    @Override
    public void drawTexturedTriangle(Vector2[] points, Vector2[] uvs, Material.Texture texture) {
        
    }
    
    public class Screen extends JPanel{

        private JFrameCanvasDrawer c;
        private boolean drawing = false;
        public Screen(JFrameCanvasDrawer c){
            this.c = c;
        }
        @Override
        public void paint(Graphics g) {
            c.graphic2d = (Graphics2D) g;
            drawing = true;
            c.p.render();
            drawing = false;
        }
        public boolean isOnDraw(){ return drawing; }
    }
}

