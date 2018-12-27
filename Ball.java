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
import java.io.File;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;



public class Ball extends JPanel  implements MouseListener{
private Color randColor;
private int X;
private int Y;
private int count;
private int X1;
private int Y1;
private int Width;
private int Height;
private double moveX;
private double moveY;
private int Dplus;
private int Dminus;
private double dilate;
private int mouseX;
private int mouseY;
private Color Colorget;
private int[] BhitboxX;
private int[] BhitboxY;
private int hitboxX;
private int hitboxY;
private int HP;
private int[] HeadshotX;
private int[] HeadshotY;
private Polygon BodyHitbox;
private Polygon Headshot;
private BufferedImage Bunny;


    public Ball(Color Col, int getX, int getY, int H, int W ,int speed,int Hitpoints) 
    {
    	Colorget = Col;
    	X = getX;
    	Y = getY;
    	Height = H;
    	Width = W;
    	moveX = speed;
    	moveY = speed;
    	setBackground(Color.BLACK);
    	setVisible(true);
    	dilate = 1;
    	HP = Hitpoints;
    	addMouseListener(this);
    	BhitboxX = new int[4];
    	BhitboxY = new int[4];
    	HeadshotX = new int[4];
    	HeadshotY = new int[4];
    	BufferedImage img = null;
		try 
			{	
    			Bunny = ImageIO.read(new File("Zombie Bunnie.png"));
			} 
			catch (IOException e) {
			}
    	//BodyHitbox = BH;
    }
    public int  getHeight()
    {
    	return Height;
    }
    
    public void Speed()
    {
    	
    }
    public int returnX()
    {
    	return X;
    }
    public int returnY()
    {
    	return Y;
    }
    public void drawCircle(Graphics window)
    {
    	
    
    	window.setColor(Colorget);
    	//window.fillOval(X,Y,(int)Width,(int)Height);
    	//window.fillOval(X,Y-50,(int)Width-10,(int)Height-10);
    	//window.drawImage(Bunny,X,Y,Width,Height,null);
    	
    	//hitbox
    	//window.setColor(Colorget);
    	
    	BhitboxX[0] = X+15;
        BhitboxX[1] = (X+Width)-20;
        BhitboxX[2] = (X+Width)-20;
        BhitboxX[3] = X+15;
        
        BhitboxY[0] = Y+10;
        BhitboxY[1] = Y+10;
        BhitboxY[2] = Y+Height-15;
        BhitboxY[3] = Y+Height-15;
        BodyHitbox = new Polygon(BhitboxX,BhitboxY,4);
        //window.fillPolygon(BodyHitbox);
        
        
        HeadshotX[0] = X+10;
        HeadshotX[1] = X+Width-25;
        HeadshotX[2] = X+Width-25;
        HeadshotX[3] = X+10;
        
        HeadshotY[0] = Y-40;
        HeadshotY[1] = Y-40;
        HeadshotY[2] = Y+Height-75;
        HeadshotY[3] = Y+Height-75;
        Headshot = new Polygon(HeadshotX,HeadshotY,4);
        //window.fillPolygon(Headshot);
        window.drawImage(Bunny,X,Y,Width,Height,null);
        
        
        
        
    	
    	if(HP>400)
    	{
    		window.setColor(Color.GREEN);
    		window.drawString("    " + HP, X+50,Y-30);
    	}
    	
    	else if(HP>=200 && HP<=400)
    	{
    		window.setColor(Color.YELLOW);
    		window.drawString("    " + HP, X+50,Y-30);
    	}
   
    	else
    	{
    		window.setColor(Color.RED);
    		window.drawString("    " + HP, X+50,Y-30);
    	}
    	
    	
    	
    }
    public Polygon getBHitbox()
    {
    	return BodyHitbox;
    }
    public Polygon getHeadshot()
    {
    	return Headshot;
    }
    public void Bodyshot()
    {
    	HP -= 100;
    }
    public void Headshot()
    {
    	HP = 0;
    }
    public void move(Graphics window)
    {
    	X+=moveX;
    	Y+=moveY;
    	if( X < 0)
    	{
    		X = 0;
    		moveX = -moveX;	
    	}
    	else if( X > 1000-Dplus)
    	{
    		X = 1000-Dplus;
    		moveX = -moveX;
    	}
    	 else if (Y < 0) 
    	 {                 
          	Y= 0;
          	moveY = -moveY;
         } 
         else if (Y > 900-Dminus) 
         { 
            Y=900-Dminus;
            moveY = -moveY;
        }

    	
    }
    public void dilate(Graphics window)
    {
    	Height+= dilate;
    	Width+= dilate;
    	if(Height == 500 && Width == 500)
    	{
    		dilate = -dilate;
    	}
    	if(Height == 30 && Width == 30)
    	{
    		dilate = -dilate;
    	}
    	
    }
    public double returnHeight()
    {
    	return Height;
    }
    public int returnHealth()
    {
    	return HP;
    }
    public void paint(Graphics window)
    {
    	super.paint(window);
   		drawCircle(window);
   		move(window);
   		dilate(window);
   		repaint();
    }
    public void mouseClicked(MouseEvent e)
    {
    	mouseX=e.getX();
		mouseY=e.getY();
    	System.out.println(mouseX + " " + mouseY);
    }
    public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
    
   
    
    	
    
    
    
}