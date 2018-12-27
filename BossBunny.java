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
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class BossBunny extends JPanel{
private BufferedImage Bossbunny;
private int[]Laser1X = new int[4];
private int[]Laser1Y = new int[4];
private int[]Laser2X = new int[4];
private int[]Laser2Y = new int[4];
private int Health;
private int setX;
private int setY;
private int endX;
private int endY;
private int size;
private int moveX;
private int moveY;
private Color getCol;
    public BossBunny(Color setCol, int H, int s1X, int s1Y, int E1X, int E1Y) 
    {
    	BufferedImage img = null;
		try 
			{	
    			Bossbunny = ImageIO.read(new File("BossBunny.png"));
			} 
			catch (IOException e) {
			}
		Health = H;
		setX = s1X;
		setY = s1Y;
		endX = E1X;
		endY = E1Y;
		moveX = 1;
		moveY = 1;
		size = 20;
		getCol = setCol;
    }
    
    public void drawBunny(Graphics window)
    {
    	window.drawImage(Bossbunny,250,100,750,750,null);
    	Laser1X[0] = setX;
    	Laser1X[1] = endX;
    	Laser1X[2] = endX+size;
    	Laser1X[3] = setX+size;
    	
    	Laser1Y[0] = setY;
    	Laser1Y[1] = endY;
    	Laser1Y[2] = endY;
    	Laser1Y[3] = setY;
    	
    	window.setColor(getCol);
    	window.fillPolygon(Laser1X,Laser1Y,4);
    }
    
    public void moveLaser()
    {
    	if(endX > 0 && endX <1280 && endY == 0)
    	{
    		endX += moveX;
    	}
    	if(endX == 1280 && endY >= 0 && endY<1050)
    	{
    		endY += moveX;
    	}
    	if(endY == 1050 && endX <=1280 && endX > 600)
    	{
    		endX -=moveX;
    	}
    	
    }
    public void paint(Graphics window)
    {
    	super.paint(window);
    	drawBunny(window);
    	moveLaser();
    	System.out.print("" + endX + "   " + endY);
    }
    
    
    
    
}