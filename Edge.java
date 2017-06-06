import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class Edge {
    private Line2D line;
    private double length;

    public Edge(Node pine, Node apple) {
	this.length = pine.distanceTo(apple);
	this.line = new Line2D.Double(pine.getX(), pine.getY(), apple.getX(), apple.getY());
    }

    public Line2D getLine() {
	return line;
    }

    public boolean intersect(Edge other) {
	if(line.intersectsLine(other.getLine())) {
	    return true;
	}
	return false;
    }
	
public double getLength() {
	return length;
}
    /*
    public static void main(String[] args) {
	Node a = new Node(5, 9);
	Node b = new Node(1, 4);
	Node c = new Node(30, 40);
	Node d = new Node(10, 10);
	Edge abc = new Edge(a, b);
	Edge bd = new Edge(c, d);
	System.out.println(abc.intersect(bd));
    }
    */

}
