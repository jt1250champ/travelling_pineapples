import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics2D.*;
import javax.swing.*;

public class Driver {

    
    public static void main(String[] args) {
	Map map1 = new Map("USA.txt");
	Map map2 = new Map("10apples.txt");

	map1.setVisible(true);
	map2.setVisible(true);

	Solver solver1;
	Solver solver2;
	if (args[0].equals("0")){
	    solver1 = new NearestNeighbor(map1);
	    solver1.setVisible(true);
	    solver2 = new NearestNeighbor(map2);
	    solver2.setVisible(true);
	}
	//else if (args[0].equals("1")){
	//   solver1 = new SmallestIncrease(map1);
	//solver2 = new SmallestIncrease(map2);
	//}
	else{
	    solver1 = new ConvexHull(map1);
	    	    solver1.setVisible(true);
	    solver2 = new ConvexHull(map2);
	    	    solver2.setVisible(true);
	}

	solver1.solve();
	solver2.solve();
	
	System.out.println(solver1.getDist());
	System.out.println(solver2.getDist());
    }
}
