import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics2D.*;
import javax.swing.*;

public class Map extends Frame{
    private ArrayList<Node> setOfPoints;
    private ArrayList<Double> xs = new ArrayList<Double>();
    private ArrayList<Double> ys = new ArrayList<Double>();
    private double sizeX;
    private double sizeY;

    public Map(String filename){
	setOfPoints = new ArrayList<Node>();
	try{
	    File file = new File(filename);
	    Scanner scan = new Scanner(file);
	    sizeX = scan.nextDouble();
	    sizeY = scan.nextDouble();
	    setSize((int)sizeX, (int)sizeY);
	    double x, y;
	    while(scan.hasNextDouble()){
		x = scan.nextDouble();
		y = scan.nextDouble();
		//System.out.println(x);
		xs.add(x);
		//System.out.println("hi");
		ys.add( y);
		Node point = new Node (x,y);
		//Point2D.Double dot = new Point2D.Double(x,y);
		//add(dot);
		//map.draw(new Point2D.Double(x,y));
		//drawString(".", x, y);
		setOfPoints.add(point);
	    }
	}
	catch(FileNotFoundException e) {
	    //TODO how do you get it to like not print stuff after like end program i also for some reason couldn't do throw new 
	    System.out.println("Please put in a valid filename");
	    return;
	}
    }

    public String toString(){
	return "hi please use the driver";
    }

    public ArrayList<Node> getPoints() {
	return setOfPoints;
    }

    public double getDiagonalSize(){
	return Math.sqrt(sizeX * sizeX + sizeY * sizeY);
    }

    public double getSizeX(){
	return sizeX;
    }

    public double getSizeY(){
	return sizeY;
    }

    public void paint(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	for(int i = 0; i < xs.size(); i++) {
	    double a = xs.get(i);
	    double b = ys.get(i);
	    int x = (int)a;
	    int y = (int)b;
	    g2.drawString(".", x, y);
	}
    }
    
    /*
    public static void main(String[] args) {
	Map a = new Map("10apples.txt");
	a.setVisible(true);
       }
    */

}
