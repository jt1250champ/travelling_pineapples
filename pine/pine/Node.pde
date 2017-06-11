import java.util.*;

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