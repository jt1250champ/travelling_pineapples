import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics2D.*;
import javax.swing.*;

public class NearestNeighbor extends Solver {
    private Map map;
    private ArrayList<Node> solution;
    private ArrayList<Double> xs;
    private ArrayList<Double> ys;
    private double dist;
    private Node firstNode;

    public NearestNeighbor(Map a) {
		setSize((int)a.getSizeX(), (int)a.getSizeY());
	xs = a.getXs();
	ys = a.getYs();
		solution = new ArrayList<Node>();
	map = a;
	dist = 0;
	//solution = new ArrayList<Node>();
	firstNode = map.getPoints().get(0);
	//setSize((int)map.getSizeX(),(int) map.getSizeY());
	
    }
    
    public void solve(){
	solve(firstNode);
    }

    public void solve(Node pine){
	Node next;
	while (someNodesNotPassed()){
	    solution.add(pine);
	    pine.setPassed(true);
	    next = findNearestTo(pine);
	    dist += pine.distanceTo(next);
	    pine = next;
	}
	dist += pine.distanceTo(firstNode);
	//System.out.println(solution);
    }

    public Node findNearestTo(Node apple){
	double leastDist = map.getDiagonalSize();
	Node closest = apple;
	ArrayList<Node> setOfNodes = map.getPoints();
	for (int i = 0; i < setOfNodes.size(); i ++){
	    if (setOfNodes.get(i) != apple && !setOfNodes.get(i).getPassed()){
		double dist = apple.distanceTo(setOfNodes.get(i));
		if (dist < leastDist){
		    leastDist = dist;
		    closest = setOfNodes.get(i);
		}
	    }
	}
	return closest;
    }

    public boolean someNodesNotPassed(){
	for (int i = 0; i < map.getPoints().size(); i ++){
	    if (!map.getPoints().get(i).getPassed()){
		return true;
	    }
	}
	return false;
    }

    
    public double getDist(){
	return dist;
    }

    public ArrayList<Node> getSolution() {
	return solution;
    }
    /*
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        g2.draw(lin);
    }
    */
    /*
    public void paint(Graphics g) {

	Graphics2D g2 = (Graphics2D) g;
	System.out.println("do i get here?");
	
	g2.drawLine(200,300,400,500);
	for(int i = 0; i < solution.size() - 1; i++) {
	    g2.drawLine((int)solution.get(i).getX(), (int)solution.get(i).getY(), (int)solution.get(i+1).getX(), (int)solution.get(i+1).getY());
	}
  
	
	
	}

    */
    /*
    public static void main(String[]args){
	//Map apple2 = new Map("2apples.txt");
	Map apple10 = new Map("10apples.txt");
	//apple2.setVisible(true);
	apple10.setVisible(true);
	//NearestNeighbor solve2 = new NearestNeighbor(apple2);
	NearestNeighbor solve10 = new NearestNeighbor(apple10);

	solve10.solve();
	//solve10.solve();

	System.out.println(solve10.getDist());
	//System.out.println(solve10.getDist());
    }
    */

     public void paint(Graphics g) {
	for(int i = 0; i < xs.size(); i++) {
	    double a = xs.get(i);
	    double b = ys.get(i);
	    int x = (int)a;
	    int y = (int)b;
	    g.drawString(".", x, y);
	}

	for(int i = 0; i < solution.size() - 1; i++) {
	    g.drawLine((int)solution.get(i).getX(), (int)solution.get(i).getY(), (int)solution.get(i+1).getX(), (int)solution.get(i+1).getY());
	}
	g.drawLine((int)solution.get(solution.size()-1).getX(),(int)solution.get(solution.size()-1).getY(), (int)solution.get(0).getX(), (int)solution.get(0).getY());
	
    }


    public static void main(String[]args){
	Map a = new Map("10apples.txt");
	//Map apple1000 = new Map("1000apples.txt");
	a.setVisible(true);
		//apple1000.setVisible(true);

        Solver solve2 = new NearestNeighbor(a);
	//NearestNeighbor solve1000 = new NearestNeighbor(apple1000);
	solve2.setVisible(true);

	solve2.solve();
	//solve1000.solve();

	System.out.println(solve2.getDist());
	//System.out.println(solve1000.getDist());
	//solve2.getSolution();
    }


}
