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
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class Screen  extends JPanel implements MouseListener, KeyListener{
private Ball fred;
private boolean getHit;
private boolean gotHit;
private MovingSquare Ed;
private int X;
private Laser bed;
private int Y;
private int count;
private int clickX;
private int clickY;
private Graphics window;
private List<Ball> Pile = new ArrayList();
private Boolean Caught;
private int Coordinates[] = new int[20];
private int mousebutton;
private int level;
private int Startbunnies;
private int shots;
private String getName;
private BufferedImage Background;
private BufferedImage Background2;
private BufferedImage Background3;
private BossBunny ed;

    public Screen() 
    {
    	 Ed = new MovingSquare(Color.RED,1,900,50,50,500);
    	 Coordinates = new int[Pile.size()];
    	 requestFocus();
    	 setFocusable(true);
    	 setBackground(Color.WHITE);
    	 addMouseListener(this);
    	 addKeyListener(this);
    	 mousebutton = 0;
    	 getHit = false;
    	 gotHit = false;
    	 level = 1;
    	 Startbunnies = 4;
    	 shots = 10;
    	 //ed = new BossBunny((new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256))),5000,600,200,600,0);
    	 for(int i = 0; i<Startbunnies; i++)
    	 {
    	 	Pile.add(new Ball(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)),(int)(Math.random()*1000),(int)(Math.random()*1000),50,50,(int)(1),500));
    	 }
    	 BufferedImage img = null;
		try 
			{	
    			Background = ImageIO.read(new File("Background.png"));
    			Background2 = ImageIO.read(new File("Background 2.png"));
    			Background3 = ImageIO.read(new File("Background3.png"));
			} 
			catch (IOException e) {
			}
    }
    public void Caught()
    {
    	if(Caught == false)
    	{
    		count++;
    		repaint();
    	}		
    }
    public void newLevel()
    { 
    	 Startbunnies = Startbunnies + (int)(Math.sqrt(Startbunnies));
    	 for(int i = 0; i<Startbunnies; i++)
    	 {
    	 	Pile.add(new Ball(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)),(int)(Math.random()*1000),(int)(Math.random()*1000),50,50,2,500));
    	 }
    	 level++;	 
    }
    	
    
    public void paintHealthBar(Graphics window)
    {
    	window.setColor(Color.GREEN);
    	window.fillRect(0,5,Ed.returnHealth(),10);
    	
    }
    public void hit()
    {
    	for(Ball fred : Pile)
    	{
    		if(Ed.returnED().contains(fred.returnX(),fred.returnY()))
    		{
    			System.out.print(" Im hit! ");
    			gotHit = true;
    		}
    	}
    }
    public void paint(Graphics window)
    {	
    	
    		super.paint(window);
    		paintHealthBar(window);
    		//window.setColor(Color.WHITE);
    		//window.fillRect(0,850,1050,10);
    		window.setColor(Color.WHITE);
    		if(level < 4 ) 
    		{
    				window.drawImage(Background,0,0,1280,1050,null);
    		}
    		else if(level > 3 && level <6)
    		{
    			window.drawImage(Background2,0,0,1280,1050,null);
    		}
    		else
    		{
    			window.drawImage(Background3,0,0,1280,1050,null);
    		}
    		//ed.paint(window);
    		//ed.repaint();
    		window.drawString(" Current Level is ::" + level,900,100);
    		window.drawString( "Player 1 "+ "' s Score  " + count, 900, 50);
    		window.drawString("Bunnies Left " + Pile.size(), 900,150);
    		window.drawString("Health " + Ed.returnHealth(),900,200);
    		//window.drawString("X is ::" + Ed.getX(), 900,300);
    		//window.drawString("Y is ::" + Ed.getY(), 900,350);
    		if( shots > 0)
    		{
    			window.drawString("Ammo :: " + shots, 900,250);
    		}
    		else
    		{
    			window.drawString("Reload! ", 900,250);
    		}
    		Ed.paint(window);
    		for(int i = 0; i<Pile.size(); i++)
    		{
    				Pile.get(i).paint(window);
    				Pile.get(i).repaint();
    				repaint();
    				//Coordinates[i] = Pile.get(i).returnX();
    				//Arrays.toString(Coordinates);			
    		}
    		bed = new Laser(new Color((int) (Math.random()*256),(int) (Math.random()*256),(int) (Math.random()*256)),Ed.getX()+20,Ed.getY(),clickX,clickY);
    		if(getHit == true && shots>0)
    		{
    			bed.Paint(window);
    		}
    		if(Pile.size() == 0)
    		{
    			newLevel();
    		}
    		if(gotHit == true)
    		{
    			Ed.attacked();
    		}		  		
    }
     public void mouseClicked(MouseEvent e){}
     public void mouseEntered(MouseEvent e) { }
	 public void mouseExited(MouseEvent e) { }
	 public void mousePressed(MouseEvent e) 
	 {
	 	getHit = true;
	 	clickX = e.getX();
	 	clickY = e.getY();
	 	mousebutton = e.getButton();
	 	for(Ball fred : Pile)
	 	{
	 		if(fred.getBHitbox().contains(clickX,clickY) && shots > 0)
	 		{
	 			System.out.print("Hit");
	 			fred.Bodyshot();
	 		}
	 		if(fred.getHeadshot().contains(clickX,clickY) && shots > 0)
	 		{
	 			System.out.print("Hit");
	 			fred.Headshot();
	 		}
	 		if(fred.returnHealth() == 0)
	 		{
	 			Pile.remove(fred);
	 			count += 100;
	 		}
	 		if(fred.contains(Ed.getX()+Ed.returnWidth(),Ed.getY()))
	 		{
	 			Ed.attacked();
	 		}		
	 	}
	 	//System.out.print("clicked");
	 	repaint(); 
	 		
	 	
	 }
	 public void mouseReleased(MouseEvent e) 
	 {
	 	//System.out.print("released");
	 	getHit = false;
	 	shots --;
	 	if(shots < 0)
	 	{
	 		shots = 0;
	 	}
	 	repaint();
	 }
	 
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == e.VK_RIGHT || e.getKeyCode() == e.VK_D)
		{
			Ed.increaseX();
		}
		if(e.getKeyCode() == e.VK_LEFT || e.getKeyCode() == e.VK_A)
		{
			Ed.DecreaseX();
		}
		if(e.getKeyCode() == e.VK_UP || e.getKeyCode() == e.VK_W)
		{
			Ed.increaseY();
		}
		if(e.getKeyCode() == e.VK_DOWN || e.getKeyCode() == e.VK_S)
		{
			Ed.decreaseY();
		}
		if(e.getKeyCode() == e.VK_F)
		{
			//System.out.println(Ed.getX()+" "+Ed.getY());
			shots = 10;
		}
	}   
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
    
   
    
    
    
    
    
    
    
}