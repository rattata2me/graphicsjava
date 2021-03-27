/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicsjava.program;

import java.awt.Graphics2D;
import javax.swing.JFrame;

/**
 *
 * @author rattata
 */
public class Program{

    private String name;
    private int width, height;
    private boolean running;
    public JFrame frame;
    public Drawer drawer;
    public Program(ProgramConfig config) {
        name = config.n;
        width = config.w;
        height = config.h;
    }

    public String getName() {
        return name;
    }
    public int[] getDimension(){
        int[] d = {width, height};
        return d;
    }
    
    public void terminate(){
        running = false;
    }
    public void start(){
        running = true;
        drawer = new JFrameCanvasDrawer(this);
        onStart();
    }
    public void run(){
        while(running){
            update();
            drawer.updateDrawer();
        }
    }
    public void end(){
        onEnd();
    }
    public void onStart(){}
    public void update(){}
    public void render(){}
    public void onEnd(){}
}
