package graphicsjava.program;

/**
 *
 * @author rattata
 */
public class GraphicsJavaTestProgram {

    
    public static void main(String[] args){
        ProgramConfig c = (new ProgramConfig()).name("Demo").dimensions(500, 500);
        TestProgram p = new TestProgram(c);
        p.start();
        p.run();
        p.end();
    }
    
}
