import java.io.*;
import java.util.*;

class Map {
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
  public double getSizeX() {
    return sizeX;
  }
  
  public double getSizeY() {
    return sizeY;
  }
    
    /*
    public static void main(String[] args) {
  Map a = new Map("2applsdfsdfsdfsdfes.txt");
  System.out.println(a.getPoints());
    }
    */
  //stuff
}