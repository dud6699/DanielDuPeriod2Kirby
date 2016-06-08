package Kirby;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class SwordKnight extends MovingThing
{
	private int speed;
	private Image image;
	private int right = 1;
	private int left = 1;

	public SwordKnight()
	{
		this(0,0,0);
	}

	public SwordKnight(int x, int y)
	{
		this(x,y,0);
	}

	public SwordKnight(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/Kirby/swordstandright.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO ALIEN!!!!!!!!!!!!!!!!!!");
		}
	}

	public void fly(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordjumpleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordjumpright.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	public void fall(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordfallleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordfallright.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}	
	
	public void leftfire(){
		try
		{
			image = ImageIO.read(new File("src/Kirby/swordstandleft.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
	
	public void changeright(){
	if(right == 1){
		right = 2;
		try
		{
			image = ImageIO.read(new File("src/Kirby/swordwalkright2.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
	else if(right == 2){
		right = 1;
		try
		{
			image = ImageIO.read(new File("src/Kirby/swordwalkright1.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
	else{
		try
		{
			image = ImageIO.read(new File("src/Kirby/swordwalkright2.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
	}

	public void land(){
		try
		{
			image = ImageIO.read(new File("src/Kirby/swordstandright.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
	
	public void changeleft(){
		if(left == 1){
			left = 2;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordwalkleft2.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(left == 2){
			left = 1;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordwalkleft1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordwalkleft2.gif"));
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
   	window.drawImage(image,getX(),getY(),60,50,null);
	}

	public String toString()
	{
		return "The alien is at ("+getX()+","+getY()+")";
	}
}
