import java.io.*;
import java.util.*;
public class Map {
    private ArrayList<Node> setOfPoints;
    private double sizeX;
    private double sizeY;

    public Map(String filename){
	setOfPoints = new ArrayList<Node>();
	try{
	    File file = new File(filename);
	    Scanner scan = new Scanner(file);
	    sizeX = scan.nextDouble();
	    sizeY = scan.nextDouble();
	    double x, y;
	    while(scan.hasNextDouble()){
		x = scan.nextDouble();
		y = scan.nextDouble();
		Node point = new Node (x,y);
		setOfPoints.add(point);
	    }
	}
	catch(FileNotFoundException e){
	}
    }

    public String toString(){
	//stuff
    }
}
