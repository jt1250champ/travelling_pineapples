import java.util.*;

public class Node {
    private Node p;
    private double x;
    private double y;
    private Node next;

    public Node(double w, double h) {
	this.x = w;
	this.y = h;
	this.next = null;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double getX() {
	return this.x;
    }

    public double getY() {
	return this.y;
    }
    /*
    public void draw() {
    }

    public void drawTo(Node b) {
    }
    */

    public double distanceTo(Node b) {
	double dx = this.x - b.getX();
	double dy = this.y - b.getY();
	return Math.sqrt(dx*dx + dy*dy); 
    }
    /*
    public static void main(String[] args) {
	Node a = new Node(0, 0);
	Node b = new Node(5, 12);
	System.out.println(a.distanceTo(b));
    }
    */
}
