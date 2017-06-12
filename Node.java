import java.util.*;

public class Node {
    private Node p;
    private double x;
    private double y;
    private Node next;
    private boolean passed;

    public Node(double w, double h) {
	this.x = w;
	this.y = h;
	this.next = null;
	passed = false;
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

    public double distToEdge(Edge e){
	Vector edge = new Vector(e);
	Node node;
	if (distanceTo(e.getPine()) < distanceTo(e.getApple())){
	    node = e.getPine();
	}
	else{
	    node = e.getApple();
	}
	Vector v = new Vector(this, node);
	double perpDist = edge.getNormal().dot(v);
	Vector toPerp = edge.minus(edge.getNormal().scale(perpDist));
	//figure out if perpendicular is on edge or outside
	if (edge.add(toPerp).getMagnitude() > edge.getMagnitude()){
	    return v.getMagnitude();
	}
	else{
	    return perpDist;
	}
    }

    public void setPassed(boolean p){
	passed = p;
    }

    public boolean getPassed(){
	return passed;
    }
    
    /*
    public static void main(String[] args) {
	Node a = new Node(0, 0);
	Node b = new Node(5, 12);
	System.out.println(a.distanceTo(b));
    }
    */
}
