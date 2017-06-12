import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics2D.*;
import javax.swing.*;

public abstract class Solver {
    private Map map;
    private ArrayList<Node> solution;
    private double dist;
    
    abstract void solve();

    public double getDist() {
	return dist;
    }

    public void paint(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	for(int i = 0; i < solution.size() - 1; i++) {
	    g2.drawLine((int)solution.get(i).getX(), (int)solution.get(i).getY(), (int)solution.get(i+1).getX(), (int)solution.get(i+1).getY());
	}
	
    }

    
    public String toString() {
	String nodes = "";
	for (int i = 0; i < solution.size(); i ++){
	    nodes += solution.get(i) + "\n";
	}
	return "Dist: " + dist + "\n" + "The path taken is: \n" + nodes;
	//TODO uh i have to do the thing wtih the path but that should be in my linked list so im gonna have to find that and then...do the thing this comment makes no sense sorry
    }
    
}
