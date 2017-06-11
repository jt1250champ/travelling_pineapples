import java.util.*;
import java.awt.*;
import java.awt.geom.*;

class Node {
  private double x;
  private double y;
  private Node next;
  private boolean passed;
  
  Node(double w, double h) {
    this.x = w;
    this.y = h;
    this.next = null;
    passed = false;
  }
  
  String toString() {
    return "(" + x + ", " + y + ")";
  }

  double getX() {
    return this.x;
  }

  double getY() {
    return this.y;
  }
  
  double distanceTo(Node b) {
    double dx = this.x - b.getX();
    double dy = this.y - b.getY();
    return Math.sqrt(dx*dx + dy*dy); 
  }

  void setPassed(boolean p){
    passed = p;
  }

  boolean getPassed(){
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

class Edge {
    private Line2D line;
    private double length;
    public Node pine;
    public Node apple;

    Edge(Node pine, Node apple) {
      this.length = pine.distanceTo(apple);
      this.pine = pine;
      this.apple = apple;
      this.line = new Line2D.Double(pine.getX(), pine.getY(), apple.getX(), apple.getY());
    }

    Line2D getLine() {
      return line;
    }

    boolean intersect(Edge other) {
      if(line.intersectsLine(other.getLine())) {
        return true;
      }
        return false;
    }
  
    double getLength() {
      return length;
    }
    
    Node getPine() {
      return pine;
    }
    
    Node getApple() {
      return apple;
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