import javax.swing.JFrame;
import java.util.Scanner;
import java.util.Scanner;
import static java.lang.System.*;

public class PacManRunner extends JFrame{
	
    private static final int WIDTH = 1280;
	private static final int HEIGHT = 1050;
   
    public PacManRunner() 
    {
    	
    	setSize(WIDTH,HEIGHT);
		getContentPane().add(new Screen());
		setVisible(true);
    }
    
    public static void main(String[] args) 
    {
    	Scanner fred = new Scanner(System.in);
    	Screen ned = new Screen();
        PacManRunner fred1 = new PacManRunner();
    }
}
