package Kirby;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static java.lang.Character.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class Game extends Canvas implements KeyListener, Runnable
{
	private Kirby kirby;
	private Fire leofire;
	private Beam waddfire;
	private Fire kirbyfire;
	private Sword sksword;
	private Sword kirbysword;
	private Beam kirbybeam;
	private int jump = 0;
	private int right = 30;
	private int walkingright = 0;
	private int left = 30;
	private int walkingleft = 0;
	private int suck = 0;
	private BurningLeo leo;
	private SwordKnight sk;
	private WaddleDu wadd;
	private int leoact;
	private int leochange = 50;
	private int leoright = 30;
	private int leojump = 0;
	private int leoleft = 30;
	private int leowalkingright = 0;
	private int leowalkingleft = 0;
	private int leofireon = 0;
	private int waddact;
	private int waddchange = 50;
	private int waddright = 30;
	private int waddjump = 0;
	private int waddleft = 30;
	private int waddwalkingright = 0;
	private int waddwalkingleft = 0;
	private int waddfireon = 0;
	private int skact;
	private int skchange = 50;
	private int skright = 30;
	private int skjump = 0;
	private int skleft = 30;
	private int skwalkingright = 0;
	private int skwalkingleft = 0;
	private int skfireon = 0;
	private int kirbyfireon = 0;
	private int leogone = 0;
	private int leospawn = 0;
	private int waddgone = 0;
	private int waddspawn = 0;
	private int skgone = 0;
	private int skspawn = 0;
	private int kirbypower = 0;
	private int kirbyswordon = 0;
	private int kirbybeamon = 0;
	private int waddlife = 250;
	private int leolife = 250;
	private int sklife = 250;
	private int score = 0;
	private Image image;
	private Fire shot;
	private Image heart;
	private Image wood;
	private Image apple;
	private ArrayList<Image> wind = new ArrayList<Image>();
	private int kirbylife = 5;
	private int kirbyinv = 0;
	private int wait = 100;
	private int treechange;
	private int treeact;
	private int blow=0;
	private int apples =0;
	private int windblow = 0;
	private int appleX;
	private int appleY;
	private int menu = 1;
	private Image menupage;
	
	/*
	private ArrayList<Ammo> shots;
	*/

	private boolean[] keys;
	private BufferedImage back;

	public Game()
	{
		//setBackground(Color.black);
		try
		{
			image = ImageIO.read(new File("src/Kirby/thetree.png"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		try
		{
			menupage = ImageIO.read(new File("src/Kirby/menu.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		try
		{
			apple = ImageIO.read(new File("src/Kirby/apple.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		try
		{
			heart = ImageIO.read(new File("src/Kirby/kirbyheart.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		try
		{
			wood = ImageIO.read(new File("src/Kirby/woodsstill.gif"));
		}
		catch(Exception e)
		{
			System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		for(int a = 0; a<3; a++){
			try
			{
				wind.add(ImageIO.read(new File("src/Kirby/wind.gif")));
			}
			catch(Exception e)
			{
				System.out.println("NO wind!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}	
		}
		keys = new boolean[5];
		leofire = new Fire(100,100,"LEFT");
		waddfire = new Beam(100,100,"LEFT");
		sksword = new Sword(100,100,"LEFT");
		kirbyfire = new Fire(100,100,"LEFT");
		kirbysword = new Sword(100,100,"LEFT");
		kirbybeam = new Beam(100,100,"LEFT");
		kirby = new Kirby(370,470,2);
		leo = new BurningLeo(200,470,1);
		sk = new SwordKnight(40, 200, 1);
		wadd = new WaddleDu(400, 200, 1);
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
	   if(menu==0){
	   if(kirbypower ==0){
	   kirby.draw(window);
	   }
	   else if(kirbypower ==1){
		   kirby.drawfire(window);
	   }
	   else if(kirbypower ==2){
		   kirby.drawsword(window);
	   }
	   else if(kirbypower ==3){
		   kirby.drawwadd(window);
	   }
	   if(kirbyfireon == 1){
		   kirbyfire.draw(window);
	   }
	   if(kirbyswordon == 1){
		   kirbysword.draw(window);
	   }
	   if(kirbybeamon == 1){
		   kirbybeam.draw(window);
	   }
	   if(leofireon == 1&&leogone < 70){
	   leofire.draw(window);
	   }
	   if(leogone < 70){
	   leo.draw(window);
	   }
	   if(skfireon == 1&&skgone < 70){
		   sksword.draw(window);
	   }
	   if(skgone < 70){
		   sk.draw(window);
	   }
	   if(waddfireon == 1&&waddgone < 70){
		   waddfire.draw(window);
	   }
	   if(waddgone < 70){
		   wadd.draw(window);
	   }
	   }
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;
		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		
		if(menu == 1){
			window.drawImage(menupage, 0, 0, 800, 600, null);
			if(keys[4] == true){
				menu = 0;
			}
		}
		else{
		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		graphToBack.drawImage(image,-96,-72,896,672,null);
		graphToBack.drawImage(wood, 320, -230, 471, 795, null);
		graphToBack.setColor(new Color(236,219,73));
		graphToBack.fillRect(0, 430, 400, 30);
		graphToBack.fillRect(300, 330, 300, 30);
		graphToBack.fillRect(0, 230, 200, 30);
		graphToBack.fillRect(500, 230, 300, 30);
		graphToBack.fillRect(300, 130, 200, 30);
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawRect(0, 430, 400, 30);
		graphToBack.drawRect(300, 330, 300, 30);
		graphToBack.drawRect(0, 230, 200, 30);
		graphToBack.drawRect(500, 230, 300, 30);
		graphToBack.drawRect(300, 130, 200, 30);
		if(kirbylife == 0){
			graphToBack.setColor(Color.RED);
			Font font = new Font("serif", Font.PLAIN, 40);
			graphToBack.setFont(font);
			graphToBack.drawString("GAME OVER", 240, 260);
			graphToBack.drawString("Press Space To Restart", 200, 310);
			if(wait>0){
				wait--;
			}
			if(keys[4] == true&&wait==0){
				kirbylife = 5;
				score = 0;
				wait = 100;
			}
		}
		else{
		
		if(kirbylife>0){
			graphToBack.drawImage(heart,10,10,50,50,null);
		}
		if(kirbylife>1){
			graphToBack.drawImage(heart,70,10,50,50,null);
		}
		if(kirbylife>2){
			graphToBack.drawImage(heart,130,10,50,50,null);
		}
		if(kirbylife>3){
			graphToBack.drawImage(heart,190,10,50,50,null);
		}
		if(kirbylife>4){
			graphToBack.drawImage(heart,250,10,50,50,null);
		}
		
		Color lightblue = new Color(101,237,253);
		//graphToBack.setColor(lightblue);
		//graphToBack.fillRect(0,0,800,600);
		//graphToBack.setColor(Color.BLUE);
		//graphToBack.drawString("StarFighter ", 15, 30 );
		//graphToBack.setColor(Color.GREEN);
		//graphToBack.fillRect(0, 530, 800, 40);
		graphToBack.setColor(new Color(236,219,73));
		graphToBack.fillRect(0, 430, 400, 30);
		graphToBack.fillRect(300, 330, 300, 30);
		graphToBack.fillRect(0, 230, 200, 30);
		graphToBack.fillRect(500, 230, 300, 30);
		graphToBack.fillRect(300, 130, 200, 30);
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawRect(0, 430, 400, 30);
		graphToBack.drawRect(300, 330, 300, 30);
		graphToBack.drawRect(0, 230, 200, 30);
		graphToBack.drawRect(500, 230, 300, 30);
		graphToBack.drawRect(300, 130, 200, 30);
		graphToBack.setColor(Color.WHITE);
		Font font = new Font("serif", Font.PLAIN, 40);
		graphToBack.setFont(font);
		graphToBack.drawString(String.valueOf(score), 380, 40);
		
		if(kirbyinv>0){
			kirbyinv--;
		}
		if(leolife <=0){
			leogone = 71;
		}
		if(sklife <=0){
			skgone = 71;
		}
		if(waddlife <=0){
			waddgone = 71;
		}
		
		//TREE
		if(treechange==1000){
			treeact = (int)(Math.random()*5);
			if(treeact==1){
				try
				{
					wood = ImageIO.read(new File("src/Kirby/woodsapple.gif"));
				}
				catch(Exception e)
				{
					System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
				appleX=(int)(Math.random()*800);
				appleY = (int)(Math.random()*50);
				apples = 2000;
			}
			else if(treeact==2||treeact==3){
				try
				{
					wood = ImageIO.read(new File("src/Kirby/woodssuck.gif"));
				}
				catch(Exception e)
				{
					System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
				blow = 100;
			}
			treechange = 0;
		}
		treechange++;
		if(blow>0){
			blow--;
		}
		if(blow == 1){
			try
			{
				wood = ImageIO.read(new File("src/Kirby/woodsblow.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			windblow = 200;
		}
		if(windblow == 200){
			for(Image winds:wind){
				graphToBack.drawImage(winds, 800, (int)(Math.random()*600), 50, 50, null);
			}
		}
		if(windblow>0){
			for(Image winds:wind){
				graphToBack.drawImage(winds, 4*windblow, (int)(Math.random()*600), 50, 50, null);
			}
			kirby.move("LEFT");
			if(kirby.getX()<10){
				kirby.setX(770);
			}
			leo.move("LEFT");
			if(leo.getX()<10){
				leo.setX(770);
			}
			sk.move("LEFT");
			if(sk.getX()<10){
				sk.setX(770);
			}
			wadd.move("LEFT");
			if(wadd.getX()<10){
				wadd.setX(770);
			}
		}
		if(windblow==0&&apples<1800){
			try
			{
				wood = ImageIO.read(new File("src/Kirby/woodsstill.gif"));
			}
			catch(Exception e)
			{
				System.out.println("NO SHIP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		if(apples<=2000&&apples>1800){
			graphToBack.drawImage(apple, appleX, appleY, 50,50,null);
		}
		if(apples<=1800&&apples>0){
			if(appleX>300&&appleX<=500){
				if(appleY<100){
				appleY++;
			}
			}
			else if(appleX>500){
				if(appleY<200){
					appleY++;
				}
			}
			else if(appleX<200){
				if(appleY<200){
					appleY++;
				}
			}
			else{
				if(appleY<400){
					appleY++;
				}
			}
			graphToBack.drawImage(apple, appleX, appleY, 50,50,null);
		}
		if(apples>0){
			if(((appleX<=kirby.getX()+50&&
					appleX+50>kirby.getX()+50)||
					(appleX<=kirby.getX()&&
					appleX+50>kirby.getX()))&&
					((appleY<=kirby.getY()+50)&&
					appleY+50>=kirby.getY()-5)){
				if(kirbylife<5){
				kirbylife++;
				}
				apples = 0;
			}
			}
		if(windblow>0){
		windblow--;
		}
		if(apples>0){
			apples--;
		}
		
		
		
		
		
		
		
		//LEO
		if(leochange == 50){
		leoact = (int)(Math.random()*20);
		leochange = 0;
		}
		if(leogone<69&&leogone>0){
		leogone--;
		}
		if(leogone>69){
			leospawn++;
			if(leospawn == 1){
				score++;
			}
			if(leospawn ==1){
				leolife = 250;
			}
			if(leospawn>500){
				leo.setX((int)(Math.random()*400)+200);
				leo.setY((int)(Math.random()*300)+200);
				leogone = 0;
				leospawn = 0;
			}
		}
		if(leofireon == 1){
			if(leo.getDirection().equals("LEFT")){
				leofire.changeleft();
			}
			else{
			leofire.changeright();
			}
		}	
		leofireon = 0;
		skfireon = 0;
		waddfireon = 0;
		//
		
		//WADDLE
		if(waddchange == 50){
			waddact = (int)(Math.random()*20);
			waddchange = 0;
			}
			if(waddgone<69&&waddgone>0){
			waddgone--;
			}
			if(waddgone>69){
				waddspawn++;
				if(waddspawn == 1){
					waddlife = 250;
					score++;
				}
				if(waddspawn>500){
					wadd.setX((int)(Math.random()*400)+200);
					wadd.setY((int)(Math.random()*300)+200);
					waddgone = 0;
					waddspawn = 0;
				}
			}
			if(waddfireon == 1){
				if(wadd.getDirection().equals("LEFT")){
					waddfire.changeleft();
				}
				else{
				waddfire.changeright();
				}
			}
		
		//SWORD KNIGHT
		if(skchange == 50){
			skact = (int)(Math.random()*20);
			skchange = 0;
		}
		if(skgone<69&&skgone>0){
		skgone--;
		}
		if(skgone>69){
			skspawn++;
			if(skspawn == 1){
				sklife = 250;
				score++;
			}
			if(skspawn>500){
				sk.setX((int)(Math.random()*400)+200);
				sk.setY((int)(Math.random()*300)+200);
				skgone = 0;
				skspawn = 0;
			}
		}
			if(skfireon == 1){
				if(sk.getDirection().equals("LEFT")){
					sksword.changeleft();
				}
				else{
				sksword.changeright();
				}
			}
		skfireon = 0;
		//
			
			
		
		kirbyfireon = 0;
		kirbyswordon = 0;
		kirbybeamon = 0;
		leochange++;
		skchange++;
		waddchange++;
		
		
		//KIRBY
		if(kirby.getY()>500||
				(kirby.getY()<400&&kirby.getY()>390&&kirby.getX()<400)||
				(kirby.getY()<300&&kirby.getY()>290&&kirby.getX()<600&&kirby.getX()>250)||
				(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()<200)||
				(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()>450)||
				(kirby.getY()<100&&kirby.getY()>90&&kirby.getX()<500&&kirby.getX()>250)){
			
		}
		else{
			kirby.move("DOWN");
		}
		if((kirby.getY()>490||
				(kirby.getY()<400&&kirby.getY()>390&&kirby.getX()<400)||
				(kirby.getY()<300&&kirby.getY()>290&&kirby.getX()<600&&kirby.getX()>250)||
				(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()<200)||
				(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()>450)||
				(kirby.getY()<100&&kirby.getY()>90&&kirby.getX()<500&&kirby.getX()>250))&&
			(walkingright == 0&&walkingleft == 0)){
			if(kirbypower == 0){
				kirby.land();
			}
			else if(kirbypower == 1){
				kirby.fireland();
			}
			else if(kirbypower == 2){
				kirby.swordland();
			}
			else if(kirbypower == 3){
				kirby.beamland();
			}
		}
		else{
			if(jump==0&&kirby.getY()<490){
				if(kirbypower == 0){
					kirby.fall();
				}
				else if(kirbypower == 1){
					kirby.firefall();
				}
				else if(kirbypower == 2){
					kirby.swordfall();
				} 
				else if(kirbypower == 3){
					kirby.beamfall();
				} 
			}
		}
		
		if(jump>0){
			jump--;
		}
		//
		
		//LEO
		if(leo.getDirection().equals("LEFT")){
			leofire.changeleft();
			leowalkingleft = 1;
		}
		else{
			leofire.changeright();
			leowalkingright = 1;
		}
		if((leo.getY()>500)||
		(leo.getY()<400&&leo.getY()>390&&leo.getX()<400)||
		(leo.getY()<300&&leo.getY()>290&&leo.getX()<600&&leo.getX()>250)||
		(leo.getY()<200&&leo.getY()>190&&leo.getX()<200)||
		(leo.getY()<200&&leo.getY()>190&&leo.getX()>450)||
		(leo.getY()<100&&leo.getY()>90&&leo.getX()<500&&leo.getX()>250)){
			
		}
		else{
			leo.move("DOWN");
		}
		if(((leo.getY()>490)||
				(leo.getY()<400&&leo.getY()>390&&leo.getX()<400)||
				(leo.getY()<300&&leo.getY()>290&&leo.getX()<600&&leo.getX()>250)||
				(leo.getY()<200&&leo.getY()>190&&leo.getX()<200)||
				(leo.getY()<200&&leo.getY()>190&&leo.getX()>450)||
				(leo.getY()<100&&leo.getY()>90&&leo.getX()<500&&leo.getX()>250))
			&&(leowalkingright==0&&leowalkingleft==0)){
			leo.land();
		}
		else{
			if(leojump==0&&(leo.getY()<490)||
			(leo.getY()<400&&leo.getY()>390&&leo.getX()<400)||
			(leo.getY()<300&&leo.getY()>290&&leo.getX()<600&&leo.getX()>250)||
			(leo.getY()<200&&leo.getY()>190&&leo.getX()<200)||
			(leo.getY()<200&&leo.getY()>190&&leo.getX()>450)||
			(leo.getY()<100&&leo.getY()>90&&leo.getX()<500&&leo.getX()>250)){
			leo.fall();
			}
		}
		if(leojump>0){
			leojump--;
		}
		leowalkingright = 0;
		leowalkingleft = 0;
		if(leoact>=0&&leoact<=4){
			if(leo.getX()>750-leo.getSpeed()){
				leo.setX(-40);
			}
			else{
			leo.move("RIGHT");
			if(leoright>=30&&(leo.getY()>490)||
			(leo.getY()<400&&leo.getY()>390&&leo.getX()<400)||
			(leo.getY()<300&&leo.getY()>290&&leo.getX()<600&&leo.getX()>250)||
			(leo.getY()<200&&leo.getY()>190&&leo.getX()<200)||
			(leo.getY()<200&&leo.getY()>190&&leo.getX()>450)||
			(leo.getY()<100&&leo.getY()>90&&leo.getX()<500&&leo.getX()>250)){
				leo.changeright();
				leoright = 0;
			}
			}
			leoright++;
			leowalkingright++;
		}
		else if(leoact>4&&leoact<=8){
			if(leo.getX()<-15+leo.getSpeed()){
				leo.setX(770);
			}
			else{
			leo.move("LEFT");
			if(leoleft>=30&&(leo.getY()>490)||
					(leo.getY()<400&&leo.getY()>390&&leo.getX()<400)||
					(leo.getY()<300&&leo.getY()>290&&leo.getX()<600&&leo.getX()>250)||
					(leo.getY()<200&&leo.getY()>190&&leo.getX()<200)||
					(leo.getY()<200&&leo.getY()>190&&leo.getX()>450)||
					(leo.getY()<100&&leo.getY()>90&&leo.getX()<500&&leo.getX()>250)){
				leo.changeleft();
				leoleft = 0;
			}
			}
			leoleft++;
			leowalkingleft++;
		}
		else if(leoact>8&&leoact<=10){
			if(leo.getY()<30+leo.getSpeed()||leojump>0){
				
			}
			else{
			leojump = 50;
			leo.fly();
			for(int a = 0; a<150; a++){
				leo.move("UP");
			}
		}
		}
		else if(leoact>10&&leoact<=17){
			
		}
		else if(leoact>17&&leoact<=20){
			if(leo.getDirection().equals("LEFT")){
				leo.leftfire();
				leofire.changeleft();
				leofire.setPos(leo.getX()-90, leo.getY());
			}
			else{
				leofire.changeright();
				leofire.setPos(leo.getX()+50, leo.getY());
			 }
			leofireon = 1;
		}
		//
		
		//WADDLE
		if(wadd.getDirection().equals("LEFT")){
			waddfire.changeleft();
			waddwalkingleft = 1;
		}
		else{
			waddfire.changeright();
			waddwalkingright = 1;
		}
		if((wadd.getY()>500)||
		(wadd.getY()<400&&wadd.getY()>390&&wadd.getX()<400)||
		(wadd.getY()<300&&wadd.getY()>290&&wadd.getX()<600&&wadd.getX()>250)||
		(wadd.getY()<200&&wadd.getY()>190&&wadd.getX()<200)||
		(wadd.getY()<200&&wadd.getY()>190&&wadd.getX()>450)||
		(wadd.getY()<100&&wadd.getY()>90&&wadd.getX()<500&&wadd.getX()>250)){
			
		}
		else{
			wadd.move("DOWN");
		}
		if(((wadd.getY()>490)||
				(wadd.getY()<401&&wadd.getY()>389&&wadd.getX()<400)||
				(wadd.getY()<301&&wadd.getY()>289&&wadd.getX()<600&&wadd.getX()>250)||
				(wadd.getY()<201&&wadd.getY()>189&&wadd.getX()<200)||
				(wadd.getY()<201&&wadd.getY()>189&&wadd.getX()>450)||
				(wadd.getY()<101&&wadd.getY()>89&&wadd.getX()<500&&wadd.getX()>250))
			&&(waddwalkingright==0&&waddwalkingleft==0)){
			wadd.land();
		}
		else{
			if(waddjump==0&&(wadd.getY()<490)||
			(wadd.getY()<400&&wadd.getY()>390&&wadd.getX()<400)||
			(wadd.getY()<300&&wadd.getY()>290&&wadd.getX()<600&&wadd.getX()>250)||
			(wadd.getY()<200&&wadd.getY()>190&&wadd.getX()<200)||
			(wadd.getY()<200&&wadd.getY()>190&&wadd.getX()>450)||
			(wadd.getY()<100&&wadd.getY()>90&&wadd.getX()<500&&wadd.getX()>250)){
				wadd.fall();
			}
		}
		if(waddjump>0){
			waddjump--;
		}
		waddwalkingright = 0;
		waddwalkingleft = 0;
		if(waddact>=0&&waddact<=5){
			if(wadd.getX()>750-wadd.getSpeed()){
				wadd.setX(-40);
			}
			else{
				wadd.move("RIGHT");
			if(waddright>=30&&(wadd.getY()>490)||
			(wadd.getY()<400&&wadd.getY()>390&&wadd.getX()<400)||
			(wadd.getY()<300&&wadd.getY()>290&&wadd.getX()<600&&wadd.getX()>250)||
			(wadd.getY()<200&&wadd.getY()>190&&wadd.getX()<200)||
			(wadd.getY()<200&&wadd.getY()>190&&wadd.getX()>450)||
			(wadd.getY()<100&&wadd.getY()>90&&wadd.getX()<500&&wadd.getX()>250)){
				wadd.changeright();
				waddright = 0;
			}
			}
			waddright++;
			waddwalkingright++;
		}
		else if(waddact>5&&waddact<=10){
			if(wadd.getX()<-15+wadd.getSpeed()){
				wadd.setX(770);
			}
			else{
				wadd.move("LEFT");
			if(waddleft>=30&&(wadd.getY()>490)||
					(wadd.getY()<400&&wadd.getY()>390&&wadd.getX()<400)||
					(wadd.getY()<300&&wadd.getY()>290&&wadd.getX()<600&&wadd.getX()>250)||
					(wadd.getY()<200&&wadd.getY()>190&&wadd.getX()<200)||
					(wadd.getY()<200&&wadd.getY()>190&&wadd.getX()>450)||
					(wadd.getY()<100&&wadd.getY()>90&&wadd.getX()<500&&wadd.getX()>250)){
				wadd.changeleft();
				waddleft = 0;
			}
			}
			waddleft++;
			waddwalkingleft++;
		}
		else if(waddact>10&&waddact<=14){
			if(wadd.getY()<30+wadd.getSpeed()||waddjump>0){
				
			}
			else{
				waddjump = 50;
				wadd.fly();
			for(int a = 0; a<150; a++){
				wadd.move("UP");
			}
		}
		}
		else if(waddact>14&&waddact<=18){
			
		}
		else if(waddact>18&&waddact<=20){
			if(wadd.getDirection().equals("LEFT")){
				wadd.fire();
				waddfire.changeleft();
				waddfire.setPos(wadd.getX()-130, wadd.getY()-10);
			}
			else{
				wadd.fire();
				waddfire.changeright();
				waddfire.setPos(wadd.getX()+60, wadd.getY()-10);
			 }
			waddfireon = 1;
		}
		//
		
		//SWORD KNIGHT
		if(sk.getDirection().equals("LEFT")){
			sksword.changeleft();
			skwalkingleft = 1;
		}
		else{
			sksword.changeright();
			skwalkingright = 1;
		}
		if((sk.getY()>500)||
		(sk.getY()<400&&sk.getY()>390&&sk.getX()<400)||
		(sk.getY()<300&&sk.getY()>290&&sk.getX()<600&&sk.getX()>250)||
		(sk.getY()<200&&sk.getY()>190&&sk.getX()<200)||
		(sk.getY()<200&&sk.getY()>190&&sk.getX()>450)||
		(sk.getY()<100&&sk.getY()>90&&sk.getX()<500&&sk.getX()>250)){
			
		}
		else{
			sk.move("DOWN");
		}
		if(((sk.getY()>490)||
				(sk.getY()<400&&sk.getY()>390&&sk.getX()<400)||
				(sk.getY()<300&&sk.getY()>290&&sk.getX()<600&&sk.getX()>250)||
				(sk.getY()<200&&sk.getY()>190&&sk.getX()<200)||
				(sk.getY()<200&&sk.getY()>190&&sk.getX()>450)||
				(sk.getY()<100&&sk.getY()>90&&sk.getX()<500&&sk.getX()>250))
			&&(skwalkingright==0&&skwalkingleft==0)){
			sk.land();
		}
		else{
			if(skjump==0&&(sk.getY()<490)||
			(sk.getY()<400&&sk.getY()>390&&sk.getX()<400)||
			(sk.getY()<300&&sk.getY()>290&&sk.getX()<600&&sk.getX()>250)||
			(sk.getY()<200&&sk.getY()>190&&sk.getX()<200)||
			(sk.getY()<200&&sk.getY()>190&&sk.getX()>450)||
			(sk.getY()<100&&sk.getY()>90&&sk.getX()<500&&sk.getX()>250)){
			sk.fall();
			}
		}
		if(skjump>0){
			skjump--;
		}
		skwalkingright = 0;
		skwalkingleft = 0;
		if(skact>=0&&skact<=4){
			if(sk.getX()>750-sk.getSpeed()){
				sk.setX(-40);
			}
			else{
			sk.move("RIGHT");
			if(skright>=30&&(sk.getY()>490)||
			(sk.getY()<400&&sk.getY()>390&&sk.getX()<400)||
			(sk.getY()<300&&sk.getY()>290&&sk.getX()<600&&sk.getX()>250)||
			(sk.getY()<200&&sk.getY()>190&&sk.getX()<200)||
			(sk.getY()<200&&sk.getY()>190&&sk.getX()>450)||
			(sk.getY()<100&&sk.getY()>90&&sk.getX()<500&&sk.getX()>250)){
				sk.changeright();
				skright = 0;
			}
			}
			skright++;
			skwalkingright++;
		}
		else if(skact>4&&skact<=8){
			if(sk.getX()<-15+sk.getSpeed()){
				sk.setX(770);
			}
			else{
			sk.move("LEFT");
			if(skleft>=30&&(sk.getY()>490)||
					(sk.getY()<400&&sk.getY()>390&&sk.getX()<400)||
					(sk.getY()<300&&sk.getY()>290&&sk.getX()<600&&sk.getX()>250)||
					(sk.getY()<200&&sk.getY()>190&&sk.getX()<200)||
					(sk.getY()<200&&sk.getY()>190&&sk.getX()>450)||
					(sk.getY()<100&&sk.getY()>90&&sk.getX()<500&&sk.getX()>250)){
				sk.changeleft();
				skleft = 0;
			}
			}
			skleft++;
			skwalkingleft++;
		}
		else if(skact>8&&skact<=10){
			if(sk.getY()<30+sk.getSpeed()||skjump>0){
				
			}
			else{
			skjump = 50;
			sk.fly();
			for(int a = 0; a<150; a++){
				sk.move("UP");
			}
		}
		}
		else if(skact>10&&skact<=14){
			
		}
		else if(skact>14&&skact<=20){
			if(sk.getDirection().equals("LEFT")){
				sk.leftfire();
				sksword.changeleft();
				sksword.setPos(sk.getX()-50, sk.getY());
			}
			else{
				sksword.changeright();
				sksword.setPos(sk.getX()+50, sk.getY());
			 }
			skfireon = 1;
		}
//
		
		
		
		if(walkingright>0){
			walkingright=0;
		}
		if(walkingleft>0){
			walkingleft=0;
		}
		
		
		//LEO
		if(leofireon==1&&leogone < 69&&kirbyinv==0){
		if(((leofire.getX()<=kirby.getX()+50&&
				leofire.getX()+90>kirby.getX()+50)||
				(leofire.getX()<=kirby.getX()&&
				leofire.getX()+90>kirby.getX()))&&
				((leofire.getY()<=kirby.getY()+40)&&
				leofire.getY()+40>=kirby.getY()-5)){
			if(kirbypower == 0){
				kirbylife--;
			}
			kirbypower = 0;
			graphToBack.drawString("HIT", 100, 100);
			kirbyinv = 200;
		}
		}
		//
		
		//WADDLE
				if(waddfireon==1&&waddgone < 69&&kirbyinv==0){
				if(((waddfire.getX()<=kirby.getX()+50&&
						waddfire.getX()+130>kirby.getX()+50)||
						(waddfire.getX()<=kirby.getX()&&
							waddfire.getX()+140>kirby.getX()))&&
						((waddfire.getY()<=kirby.getY()+40)&&
						waddfire.getY()+100>=kirby.getY()-5)){
					if(kirbypower == 0){
						kirbylife--;
					}
					kirbypower = 0;
					graphToBack.drawString("HIT", 100, 100);
					kirbyinv=200;
				}
				}
				//
		
		
		//SWORDKNIGHT
		if(skfireon==1 &&skgone<69&&kirbyinv==0){
			if(((sksword.getX()<=kirby.getX()+50&&
					sksword.getX()+60>kirby.getX()+50)||
					(sksword.getX()<=kirby.getX()&&
					sksword.getX()+60>kirby.getX()))&&
					((sksword.getY()<=kirby.getY()+40)&&
					sksword.getY()+100>=kirby.getY()-5)){
				if(kirbypower == 0){
					kirbylife--;
				}
				kirbypower = 0;
				graphToBack.drawString("HIT", 100, 100);
				kirbyinv=200;
			}
			}
		//
		
		//KIRBY
		if(kirbyfireon == 1){
			if(kirby.getDirection().equals("LEFT")){
				kirbyfire.changeleft();
			}
			else{
			kirbyfire.changeright();
			}
		}
		if(kirbyswordon == 1){
			if(kirby.getDirection().equals("LEFT")){
				kirbysword.changeleft();
			}
			else{
			kirbysword.changeright();
			}
		}if(kirbybeamon == 1){
			if(kirby.getDirection().equals("LEFT")){
				kirbybeam.changeleft();
			}
			else{
			kirbybeam.changeright();
			}
		}
		if(keys[0] == true&&suck==0)
		{
			if(kirby.getX()<-15+kirby.getSpeed()){
				kirby.setX(770);
			}
			else{
			kirby.move("LEFT");
			if((left>=30&&kirby.getY()>490)||
			(kirby.getY()<400&&kirby.getY()>390&&kirby.getX()<400)||
			(kirby.getY()<300&&kirby.getY()>290&&kirby.getX()<600&&kirby.getX()>250)||
			(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()<200)||
			(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()>450)||
			(kirby.getY()<100&&kirby.getY()>90&&kirby.getX()<500&&kirby.getX()>250)){
				if(kirbypower == 0){
				kirby.changeleft();
				}
				else if(kirbypower == 1){
					kirby.firechangeleft();
				}
				else if(kirbypower == 2){
					kirby.swordchangeleft();
				}
				else if(kirbypower == 3){
					kirby.beamchangeleft();
				}
				left = 0;
			}
			}
			walkingleft++;
			left++;
		}
		else if(keys[1] == true&&suck==0)
		{
			if(kirby.getX()>720-kirby.getSpeed()){
				kirby.setX(-80);
			}
			else{
			kirby.move("RIGHT");
			if(right>=30&&(kirby.getY()>490)||
			(kirby.getY()<400&&kirby.getY()>390&&kirby.getX()<400)||
			(kirby.getY()<300&&kirby.getY()>290&&kirby.getX()<600&&kirby.getX()>250)||
			(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()<200)||
			(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()>450)||
			(kirby.getY()<100&&kirby.getY()>90&&kirby.getX()<500&&kirby.getX()>250)){
				if(kirbypower == 0){
				kirby.changeright();
				}
				else if(kirbypower == 1){
					kirby.firechangeright();
				}
				else if(kirbypower == 2){
					kirby.swordchangeright();
				}
				else if(kirbypower == 3){
					kirby.beamchangeright();
				}
				right = 0;
			}
			}
			walkingright++;
			right++;
		}
		
		suck = 0;
		
		if(keys[2] == true)
		{
			if(kirby.getY()<30+kirby.getSpeed()||jump>0){
				
			}
			else{
			jump = 50;
			if(kirbypower == 0){
			kirby.fly();
			}
			else if(kirbypower == 1){
				kirby.firefly();
			}
			else if(kirbypower == 2){
				kirby.swordfly();
			}
			else if(kirbypower == 3){
				kirby.beamfly();
			}
			for(int a = 0; a<75; a++){
				kirby.move("UP");
			}
			}
		}
		/*else if(keys[3] == true)
		{
			if(ship.getY()>480-ship.getSpeed()){
				
			}
			else{
			ship.move("DOWN");
			}
		}*/
		if(keys[4] == true){
			if(kirbypower == 0){
			if((kirby.getY()>490)||
					(kirby.getY()<400&&kirby.getY()>390&&kirby.getX()<400)||
					(kirby.getY()<300&&kirby.getY()>290&&kirby.getX()<600&&kirby.getX()>250)||
					(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()<200)||
					(kirby.getY()<200&&kirby.getY()>190&&kirby.getX()>450)||
					(kirby.getY()<100&&kirby.getY()>90&&kirby.getX()<500&&kirby.getX()>250)){
			kirby.suck();
			suck++;
			if(kirby.getDirection().equals("LEFT")){
				if(leo.getX()<kirby.getX()+50&&leo.getX()>kirby.getX()-150&&leo.getY()<kirby.getY()+30&&leo.getY()>kirby.getY()-20){
					leogone += 2;
					leo.move("RIGHT");
					if(leogone>69){
						kirbypower = 1;
					}
				}
			}
			else{
				if(leo.getX()<kirby.getX()+150&&leo.getX()>kirby.getX()-50&&leo.getY()<kirby.getY()+30&&leo.getY()>kirby.getY()-20){
					leogone += 2;
					leo.move("LEFT");
					if(leogone>69){
						kirbypower = 1;
					}
				}
			}
			if(kirby.getDirection().equals("LEFT")){
				if(wadd.getX()<kirby.getX()+50&&wadd.getX()>kirby.getX()-150&&wadd.getY()<kirby.getY()+30&&wadd.getY()>kirby.getY()-20){
					waddgone += 2;
					wadd.move("RIGHT");
					if(waddgone>69){
						kirbypower = 3;
					}
				}
			}
			else{
				if(wadd.getX()<kirby.getX()+150&&wadd.getX()>kirby.getX()-50&&wadd.getY()<kirby.getY()+30&&wadd.getY()>kirby.getY()-20){
					waddgone += 2;
					wadd.move("LEFT");
					if(waddgone>69){
						kirbypower = 3;
					}
				}
			}
			if(kirby.getDirection().equals("LEFT")){
				if(sk.getX()<kirby.getX()+50&&sk.getX()>kirby.getX()-150&&sk.getY()<kirby.getY()+30&&sk.getY()>kirby.getY()-20){
					skgone += 2;
					sk.move("RIGHT");
					if(skgone>69){
						kirbypower = 2;
					}
				}
			}
			else{
				if(sk.getX()<kirby.getX()+150&&sk.getX()>kirby.getX()-50&&sk.getY()<kirby.getY()+30&&sk.getY()>kirby.getY()-20){
					skgone += 2;
					sk.move("LEFT");
					if(skgone>69){
						kirbypower = 2;
					}
				}
				
			}
			}
		}
		else if(kirbypower == 1){
			suck++;
			if(kirby.getDirection().equals("LEFT")){
				kirbyfire.changeleft();
				kirbyfire.setPos(kirby.getX()-90, kirby.getY());
				kirby.fire();
				if(((kirbyfire.getX()<=leo.getX()+50&&
						kirbyfire.getX()+90>leo.getX()+50)||
						(kirbyfire.getX()<=leo.getX()&&
						kirbyfire.getX()+90>leo.getX()))&&
						((kirbyfire.getY()<=leo.getY()+40)&&
						kirbyfire.getY()+40>=leo.getY()-5)){
					if(leogone<70){
					leolife-=3;
					}
				}
				if(((kirbyfire.getX()<=sk.getX()+50&&
						kirbyfire.getX()+90>sk.getX()+50)||
						(kirbyfire.getX()<=sk.getX()&&
						kirbyfire.getX()+90>sk.getX()))&&
						((kirbyfire.getY()<=sk.getY()+40)&&
						kirbyfire.getY()+40>=sk.getY()-5)){
					if(skgone<70){
					sklife-=3;
					}
				}
				if(((kirbyfire.getX()<=wadd.getX()+50&&
						kirbyfire.getX()+90>wadd.getX()+50)||
						(kirbyfire.getX()<=wadd.getX()&&
						kirbyfire.getX()+90>wadd.getX()))&&
						((kirbyfire.getY()<=wadd.getY()+40)&&
						kirbyfire.getY()+40>=wadd.getY()-5)){
					if(waddgone<70){
					waddlife-=3;
					}
				}
			}
			else{
				kirbyfire.changeright();
				kirbyfire.setPos(kirby.getX()+70, kirby.getY());
				kirby.fire();
				if(((kirbyfire.getX()<=leo.getX()+50&&
						kirbyfire.getX()+90>leo.getX()+50)||
						(kirbyfire.getX()<=leo.getX()&&
						kirbyfire.getX()+90>leo.getX()))&&
						((kirbyfire.getY()<=leo.getY()+40)&&
						kirbyfire.getY()+40>=leo.getY()-5)){
					if(leogone<70){
					leolife-=3;
					}
				}
				if(((kirbyfire.getX()<=sk.getX()+50&&
						kirbyfire.getX()+90>sk.getX()+50)||
						(kirbyfire.getX()<=sk.getX()&&
						kirbyfire.getX()+90>sk.getX()))&&
						((kirbyfire.getY()<=sk.getY()+40)&&
						kirbyfire.getY()+40>=sk.getY()-5)){
					
					if(skgone<70){
					sklife-=3;
					}
				}
				if(((kirbyfire.getX()<=wadd.getX()+50&&
						kirbyfire.getX()+90>wadd.getX()+50)||
						(kirbyfire.getX()<=wadd.getX()&&
						kirbyfire.getX()+90>wadd.getX()))&&
						((kirbyfire.getY()<=wadd.getY()+40)&&
						kirbyfire.getY()+40>=wadd.getY()-5)){
					if(waddgone<70){
					waddlife-=3;
					}
				}
			 }
			kirbyfireon = 1;

		}
		else if(kirbypower == 2){
			suck++;
			if(kirby.getDirection().equals("LEFT")){
				kirbysword.changeleft();
				kirbysword.setPos(kirby.getX()-50, kirby.getY()+15);
				kirby.slash();
				if(((kirbysword.getX()<=leo.getX()+50&&
						kirbysword.getX()+60>leo.getX()+50)||
						(kirbysword.getX()<=leo.getX()&&
								kirbysword.getX()+60>leo.getX()))&&
						((kirbysword.getY()<=leo.getY()+40)&&
								kirbysword.getY()+100>=leo.getY()-5)){
					if(leogone<70){
					leolife-=5;
					}
				}
				if(((kirbysword.getX()<=sk.getX()+50&&
						kirbysword.getX()+60>sk.getX()+50)||
						(kirbysword.getX()<=sk.getX()&&
								kirbysword.getX()+60>sk.getX()))&&
						((kirbysword.getY()<=sk.getY()+40)&&
								kirbysword.getY()+100>=sk.getY()-5)){
					if(skgone<70){
					sklife-=5;
					}
				}
				if(((kirbysword.getX()<=wadd.getX()+50&&
						kirbysword.getX()+60>wadd.getX()+50)||
						(kirbysword.getX()<=wadd.getX()&&
								kirbysword.getX()+60>wadd.getX()))&&
						((kirbysword.getY()<=wadd.getY()+40)&&
								kirbysword.getY()+100>=wadd.getY()-5)){
					if(waddgone<70){
					waddlife-=5;
					}
				}
			}
			else{
				kirbysword.changeright();
				kirbysword.setPos(kirby.getX()+70, kirby.getY()+15);
				kirby.slash();
				if(((kirbysword.getX()<=leo.getX()+50&&
						kirbysword.getX()+60>leo.getX()+50)||
						(kirbysword.getX()<=leo.getX()&&
								kirbysword.getX()+60>leo.getX()))&&
						((kirbysword.getY()<=leo.getY()+40)&&
								kirbysword.getY()+100>=leo.getY()-5)){
					if(leogone<70){
					leolife-=5;
					}
				}
				if(((kirbysword.getX()<=sk.getX()+50&&
						kirbysword.getX()+60>sk.getX()+50)||
						(kirbysword.getX()<=sk.getX()&&
								kirbysword.getX()+60>sk.getX()))&&
						((kirbysword.getY()<=sk.getY()+40)&&
								kirbysword.getY()+100>=sk.getY()-5)){
					if(skgone<70){
					sklife-=5;
					}
				}
				if(((kirbysword.getX()<=wadd.getX()+50&&
						kirbysword.getX()+60>wadd.getX()+50)||
						(kirbysword.getX()<=wadd.getX()&&
								kirbysword.getX()+60>wadd.getX()))&&
						((kirbysword.getY()<=wadd.getY()+40)&&
								kirbysword.getY()+100>=wadd.getY()-5)){
					if(waddgone<70){
					waddlife-=5;
					}
				}
			 }
			kirbyswordon = 1;

		}
		else if(kirbypower == 3){
			suck++;
			if(kirby.getDirection().equals("LEFT")){
				kirbybeam.changeleft();
				kirbybeam.setPos(kirby.getX()-140, kirby.getY()-30);
				kirby.beam();
				if(((kirbybeam.getX()<=leo.getX()+50&&
						kirbybeam.getX()+130>leo.getX()+50)||
					(kirbybeam.getX()<=leo.getX()&&
							kirbybeam.getX()+140>leo.getX()))&&
					((kirbybeam.getY()<=leo.getY()+40)&&
							kirbybeam.getY()+100>=leo.getY()-5)){
					if(leogone<70){
					leolife-=2;
					}
				}
				if(((kirbybeam.getX()<=sk.getX()+50&&
						kirbybeam.getX()+130>sk.getX()+50)||
						(kirbybeam.getX()<=sk.getX()&&
								kirbybeam.getX()+140>sk.getX()))&&
						((kirbybeam.getY()<=sk.getY()+40)&&
								kirbybeam.getY()+100>=sk.getY()-5)){
					if(skgone<70){
						sklife-=2;	
					}
					}
				if(((kirbybeam.getX()<=wadd.getX()+50&&
						kirbybeam.getX()+130>wadd.getX()+50)||
						(kirbybeam.getX()<=wadd.getX()&&
								kirbybeam.getX()+140>wadd.getX()))&&
						((kirbybeam.getY()<=wadd.getY()+40)&&
								kirbybeam.getY()+100>=wadd.getY()-5)){
					if(waddgone<70){
						waddlife-=2;
					}
					}
			}
			else{
				kirbybeam.changeright();
				kirbybeam.setPos(kirby.getX()+80, kirby.getY()-30);
				kirby.beam();
				if(((kirbybeam.getX()<=leo.getX()+50&&
						kirbybeam.getX()+130>leo.getX()+50)||
						(kirbybeam.getX()<=leo.getX()&&
								kirbybeam.getX()+140>leo.getX()))&&
						((kirbybeam.getY()<=leo.getY()+40)&&
								kirbybeam.getY()+100>=leo.getY()-5)){
					if(leogone<70){
						leolife-=2;	
					}
					}
					if(((kirbybeam.getX()<=sk.getX()+50&&
							kirbybeam.getX()+130>sk.getX()+50)||
							(kirbybeam.getX()<=sk.getX()&&
									kirbybeam.getX()+140>sk.getX()))&&
							((kirbybeam.getY()<=sk.getY()+40)&&
									kirbybeam.getY()+100>=sk.getY()-5)){
						if(skgone<70){
							sklife-=2;	
						}
						}
					if(((kirbybeam.getX()<=wadd.getX()+50&&
							kirbybeam.getX()+130>wadd.getX()+50)||
							(kirbybeam.getX()<=wadd.getX()&&
									kirbybeam.getX()+140>wadd.getX()))&&
							((kirbybeam.getY()<=wadd.getY()+40)&&
									kirbybeam.getY()+100>=wadd.getY()-5)){
						if(waddgone<70){
							waddlife-=2;		
						}
						}
			 }
			kirbybeamon = 1;

		}
		}

		//add code to move stuff


		//add in collision detection

		}
		twoDGraph.drawImage(back, null, 0, 0);
		}
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

