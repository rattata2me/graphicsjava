package graphicsjava.program;

/**
 *
 * @author rattata
 */
public class ProgramConfig {
    public String n;
    public int w, h;
    
    public ProgramConfig name(String n){
        this.n = n;
        return this;
    }
    public ProgramConfig dimensions(int w, int h){
        this.w = w;
        this.h = h;
        return this;
    }
    
}
