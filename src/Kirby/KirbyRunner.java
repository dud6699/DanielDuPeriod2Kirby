package Kirby;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class KirbyRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public KirbyRunner()
	{
		super("KIRBY");
		setSize(WIDTH,HEIGHT);

		Game theGame = new Game();
		((Component)theGame).setFocusable(true );

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		KirbyRunner run = new KirbyRunner();
	}
}