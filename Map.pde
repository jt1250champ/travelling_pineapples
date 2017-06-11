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
  catch(FileNotFoundException e) {
      //TODO how do you get it to like not print stuff after like end program i also for some reason couldn't do throw new 
      System.out.println("Please put in a valid filename");
      return;
  }
    }

    public String toString(){
  return "hi please wait until the visually thing works";
    }

    public ArrayList<Node> getPoints() {
  return setOfPoints;
    }

    public double getDiagonalSize(){
  return Math.sqrt(sizeX * sizeX + sizeY * sizeY);
    }

void setup() {
  sizeX = (int)sizeX;
  sizeY = (int)sizeY;
  size(sizeX,sizeY);
  // Make a new instance of a PImage by loading an image file
  //img = loadImage("pineapple.jpg");
}

void draw() {
  background(0);
  // Draw the image to the screen at coordinate (0,0)
  //image(img,0,0);
  stroke(153);
  for(int i = 0; i < setOfPoints.size(); i++) {
    point(setOfPoints.get(i).getX(), setOfPoints.get(i).getY());
  }
}
/*
example code for processing
int d = 70;
int p1 = d;
int p2 = p1+d;
int p3 = p2+d;
int p4 = p3+d;

// Draw gray box
stroke(153);
line(p3, p3, p2, p3);
line(p2, p3, p2, p2);
line(p2, p2, p3, p2);
line(p3, p2, p3, p3);

// Draw white points
stroke(255);
point(p1, p1);
point(p1, p3); 
point(p2, p4);
point(p3, p1); 
point(p4, p2);
point(p4, p4);
*/
  
  

    public static void main(String[] args) {
  Map a = new Map("2apples.txt");
  System.out.println(a.getPoints());
  a.draw();
    }
}