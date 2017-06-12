import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class SmallestIncrease extends Solver {
    private Map map;
    private ArrayList<Node> solution;
    private ArrayList<Edge> lengthythings;
    private double dist;

    public SmallestIncrease(Map file) {
	map = file;
	solution = new LinkedList<Node>();
	dist = 0;
    }

    public void solve() {
	Edge smallest = lengthythings.get(0);
	for(int i = 1; i < lengthythings.size(); i++) {
	    if(lengthythings.get(i).getLength() < smallest.getLength()) {
		smallest = lengthythings.get(i);
	    }
	}
	solution.add(smallest.getPine());
	solution.add(smallest.getApple());
	
    }

    private boolean remover(ArrayList<Edge> a, Node b, Node c) {
    }
    
    public void getEdgeLengths() {
	for(int i = 0; i < map.getPoints().size(); i++) {
	    for(int j = i; j < map.getPoints().size(); j++) {
		Node one = map.getPoints().get(i);
		Node two = map.getPoints().get(j);
		Edge edgy = new Edge(one, two);
		lengthythings.add(edgy);
	    }
	}
    }

  
}