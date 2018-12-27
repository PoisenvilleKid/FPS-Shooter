import java.util.*;
import static java.lang.System.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.util.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.Polygon;
import java.*;
public class Laser extends JPanel {
private Color getCOl;
private int setX;
private int setY;
private int endX;
private int endY;
private int[] LaserX;
private int[] LaserY;
private int size;
    public Laser()
    {
    	
    }
    public Laser(Color setCOL,int SX, int SY, int EX, int EY)
    {
    	getCOl = setCOL;
    	setX = SX;
    	setY = SY;
    	endX = EX;
    	endY = EY;
    	LaserX = new int[4];
    	LaserY = new int[4];
    	size = 10;	
    }
    public boolean LaserOut()
    {
    	return true;
    }
    public void Paint(Graphics window)
    {
    	super.paint(window);
    	window.setColor(getCOl);
    	//window.drawLine(setX,setY,endX,endY);
    	//window.drawRect(endX,endY,50,50);
    	LaserX[0] = setX;
    	LaserX[1] = endX;
    	LaserX[2] = endX+size;
    	LaserX[3] = setX+size;
    	
    	LaserY[0] = setY;
    	LaserY[1] = endY;
    	LaserY[2] = endY;
    	LaserY[3] = setY;
    	
    	window.fillPolygon(LaserX,LaserY,4);
    	
    	
    }
    
    
}