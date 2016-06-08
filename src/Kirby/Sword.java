package Kirby;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Sword extends MovingThing
{
	private int speed;
	private Image image;
	private int right = 1;
	private int left = 1;
	
	public Sword()
	{
		super(0,0);
		speed = 0;
	}

	public Sword(int x, int y)
	{
		super(x,y);
		speed = 0;
	}

	public Sword(int x, int y, String dir)
	{
		super(x,y);
		if(dir.equals("LEFT")){
		try
		{
			image = ImageIO.read(new File("src/Kirby/swordleft1.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		}
		if(dir.equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordright1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			}
	}
	
	public void changeright(){
		if(right == 1){
			right = 2;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordright2.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(right == 2){
			right = 3;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordright3.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(right == 3){
			right = 1;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordright1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordright1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	public void changeleft(){
		if(left == 1){
			left = 2;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordleft2.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(left == 2){
			left = 3;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordleft3.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(left == 3){
			left = 1;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordleft1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordleft1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY()-30,60,100,null);
	}
	
	
	public String toString()
	{
		return "The rocket is at ("+getX()+","+getY()+")";
	}
}
