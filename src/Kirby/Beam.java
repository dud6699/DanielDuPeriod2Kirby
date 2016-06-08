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

public class Beam extends MovingThing
{
	private int speed;
	private Image image;
	private int right = 1;
	private int left = 1;
	
	public Beam()
	{
		super(0,0);
		speed = 0;
	}

	public Beam(int x, int y)
	{
		super(x,y);
		speed = 0;
	}

	public Beam(int x, int y, String dir)
	{
		super(x,y);
		if(dir.equals("LEFT")){
		try
		{
			image = ImageIO.read(new File("src/Kirby/beamleft1.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		}
		if(dir.equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamright1.gif"));
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
				image = ImageIO.read(new File("src/Kirby/beamright2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/beamright3.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(right == 3){
			right = 4;
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamright4.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(right == 4){
			right = 5;
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamright5.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(right == 5){
			right = 1;
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamright1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamright1.gif"));
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
				image = ImageIO.read(new File("src/Kirby/beamleft2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/beamleft3.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(left == 3){
			left = 4;
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamleft4.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(left == 4){
			left = 5;
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamleft5.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(left == 5){
			left = 1;
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamleft1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamleft1.gif"));
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
		window.drawImage(image,getX(),getY()-60,140,120,null);
	}
	
	
	public String toString()
	{
		return "The rocket is at ("+getX()+","+getY()+")";
	}
}
