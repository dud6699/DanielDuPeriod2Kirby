package Kirby;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Kirby extends MovingThing
{
	private int speed;
	private Image image;
	private int right = 1;
	private int left = 1;

	public Kirby()
	{
		this(0,0,0);
	}

	public Kirby(int x, int y)
	{
		this(x,y,0);
	}

	public Kirby(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/Kirby/kirbystand.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}

	public void fly(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/kirbyjumpleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/kirbyjumpright.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	public void firefly(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/firekirbyjumpleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/firekirbyjumpright.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	public void swordfly(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordkirbyjumpleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordkirbyjumpright.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	public void beamfly(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamkirbyjumpleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamkirbyjumpright.gif"));
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
				image = ImageIO.read(new File("src/Kirby/kirbyfallleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/kirbyfallright.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	public void firefall(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/firekirbyfallleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/firekirbyfallright.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	public void swordfall(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordkirbyfallleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordkirbyfallright.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	public void beamfall(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamkirbyfallleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else if(getDirection().equals("RIGHT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamkirbyfallright.gif"));
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
			image = ImageIO.read(new File("src/Kirby/kirbystand.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
	
	public void fireland(){
		try
		{
			image = ImageIO.read(new File("src/Kirby/firekirbystand.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
	
	public void swordland(){
		try
		{
			image = ImageIO.read(new File("src/Kirby/swordkirbystand.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
	
	public void beamland(){
		try
		{
			image = ImageIO.read(new File("src/Kirby/beamkirbystand.gif"));
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
					image = ImageIO.read(new File("src/Kirby/kirbyright2.gif"));
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
					image = ImageIO.read(new File("src/Kirby/kirbyright1.gif"));
				}
				catch(Exception e)
				{
					System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
			}
			else{
				try
				{
					image = ImageIO.read(new File("src/Kirby/kirbyright2.gif"));
				}
				catch(Exception e)
				{
					System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
			}
	}
	
	public void firechangeright(){
		if(right == 1){
			right = 2;
			try
			{
				image = ImageIO.read(new File("src/Kirby/firekirbyright2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/firekirbyright1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/firekirbyright2.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
}
	
	public void swordchangeright(){
		if(right == 1){
			right = 2;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordkirbyright2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/swordkirbyright1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordkirbyright2.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
}
	
	public void beamchangeright(){
		if(right == 1){
			right = 2;
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamkirbyright2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/beamkirbyright1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamkirbyright2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/kirbyleft2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/kirbyleft1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/kirbyleft2.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
}
	
	public void firechangeleft(){
		if(left == 1){
			left = 2;
			try
			{
				image = ImageIO.read(new File("src/Kirby/firekirbyleft2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/firekirbyleft1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/firekirbyleft2.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
}
	
	public void swordchangeleft(){
		if(left == 1){
			left = 2;
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordkirbyleft2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/swordkirbyleft1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordkirbyleft2.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
}
	
	public void beamchangeleft(){
		if(left == 1){
			left = 2;
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamkirbyleft2.gif"));
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
				image = ImageIO.read(new File("src/Kirby/beamkirbyleft1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamkirbyleft2.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
}
	
	public void suck(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/kirbysuckingleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
				try
				{
					image = ImageIO.read(new File("src/Kirby/kirbysuckingright.gif"));
				}
				catch(Exception e)
				{
					System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
			}
	}
	
	public void fire(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/firekirbyfireleft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
				try
				{
					image = ImageIO.read(new File("src/Kirby/firekirbyfireright.gif"));
				}
				catch(Exception e)
				{
					System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
			}
	}
	
	public void slash(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/swordkirbystableft.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
				try
				{
					image = ImageIO.read(new File("src/Kirby/swordkirbystabright.gif"));
				}
				catch(Exception e)
				{
					System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
			}
	}
	
	public void beam(){
		if(getDirection().equals("LEFT")){
			try
			{
				image = ImageIO.read(new File("src/Kirby/beamkirbyleft1.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
				try
				{
					image = ImageIO.read(new File("src/Kirby/beamkirbyright1.gif"));
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
   	window.drawImage(image,getX(),getY(),50,50,null);
	}
	
	public void drawfire(Graphics window){
	   	window.drawImage(image,getX(),getY()-20,70,70,null);
	}
	
	public void drawsword(Graphics window){
	   	window.drawImage(image,getX(),getY()-30,80,80,null);
	}
	public void drawwadd(Graphics window){
	   	window.drawImage(image,getX(),getY()-30,80,80,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
