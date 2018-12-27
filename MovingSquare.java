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



public class MovingSquare extends JPanel {
private int X;
private int Y;
private Color Colorget;
private int Height;
private int Weight;
private int moveX;
private int Health;
private int[]EdX = new int[4];
private int[]EdY = new int[4];
private Polygon EdSquare;
private BufferedImage RobotJ;
    public MovingSquare(Color col, int Start,int Base,int H, int W, int Heal)
    {
    	X = Start;
    	Y = Base;
    	Colorget = col;
    	Height = H;
    	Weight = W;
    	moveX = 20;
    	Health = Heal;
    	BufferedImage img = null;
		try 
			{	
    			RobotJ = ImageIO.read(new File("Johnny Gargano3.jpg"));
			} 
			catch (IOException e) {
			}
    }
    public void drawSquare(Graphics window)
    {
    	window.setColor(Colorget);
    	//window.fillRect(X,Y,Height,Weight);
    	EdX[0] = X;
    	EdX[1] = X + Weight;
    	EdX[2] = X + Weight;
    	EdX[3] = X;
    	
    	EdY[0] = Y;
    	EdY[1] = Y;
    	EdY[2] = Y + Height;
    	EdY[3] = Y + Height;
    	
    	EdSquare = new Polygon(EdX,EdY,4);
    	//window.fillPolygon(EdSquare);
    	window.drawImage(RobotJ,X,Y,Weight+50,Height+50,null);
    	
    }
    public void attacked()
    {
    	Health -= 100;
    }
    public int returnHealth()
    {
    	return Health;
    }
    public void increaseX()
    {
    	//if(Y == 0 || Y == 900)
    	//{
    		
    	
    	
    		
    	
    		X+=moveX;
    		//moveX++;
    		if(X > 1200)
    		{
    			X = 1200;
    			moveX = -moveX;
    		}
    		if(X < 0)
    		{
    			X = 0;
    			moveX = -moveX;
    		}
    	
    	//}
    }
    public void DecreaseX()
    {
    	//if(Y == 0 ||  Y == 900)
    	//{
    		
    	
    		X-=moveX;
    		//moveX--;
    		if(X > 1200)
    		{
    			X = 1200;
    		}
    		if(X < 0)
    		{
    			X = 0;
    		}
    	//}
    }
    
    public void increaseY()
    {
    	//if( X < 5 || X == 1200)
    	//{
    		//if(Y < 5 || Y <=900)
    		//{
    			
    			Y -= moveX;
    			//moveX--;
    			if(Y > 900)
    			{
    				Y = 900;
    				
    			}
    			if(Y<0)
    			{	
    	 			Y = 0;
    			}
    		//}
    	//}
    }
    public void decreaseY()
    {
    	//if( X < 5 || X == 1200)
    	//{
    		//if(Y < 5 || Y <=900)
    		//{	
    			Y+=moveX;
    			//moveX++;
    			if(Y > 900)
    			{
    				Y = 900;
    				moveX = -moveX;
    			}
    			if(Y<0)
    			{
    				Y = 0;
    				moveX = -moveX;
    			}
    		//}
    	//}
    }
    public int getX()
    {
    	return X;
    }
    public int getY()
    {
    	return Y;
    }
    public int returnWidth()
    {
    	return Weight;
    }
    public Polygon returnED()
    {
    	return EdSquare;
    }
    public void paint(Graphics window)
    {
    	super.paint(window);
    	drawSquare(window);
    	//increaseX();
    	//decreaseY();
    	//moveSquare(window);
    	repaint();
    }
    
		
    
    
}