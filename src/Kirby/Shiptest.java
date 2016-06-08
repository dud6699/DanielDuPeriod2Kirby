package Kirby;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Shiptest
{
    public static void main( String args[] )
    {
        MovingThing test = new Kirby();
        System.out.println("Ship 1 " + test);

        Kirby test2 = new Kirby(50,75);
        System.out.println("Ship 2 " + test2);

        Kirby test3 = new Kirby();
        test3.setX(3);
        test3.setY(5);
        System.out.println("Ship 3 " + test3);
    }
}
