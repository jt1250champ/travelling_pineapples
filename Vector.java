import java.util.*;
public class Vector{
    private double x;
    private double y;
    private double magnitude;
    private double direction;

    public Vector(Node pine, Node apple){
	x = apple.getX() - pine.getX();
	y = apple.getY() - pine.getY();
	magnitude = Math.sqrt(x * x + y * y);
	direction = Math.asin(y / x);
    }

    public Vector(Edge edge){
	this(edge.getPine(), edge.getApple());
    }

    public Vector(double dir, double mag){
	direction = dir;
	magnitude = mag;
	x = mag * Math.cos(dir);
	y = mag * Math.sin(dir);
    }
    /*
    public Vector(double X, double Y){
	x = X;
	y = Y;
	magnitude = Math.sqrt(x * x + y * y);
	direction = Math.asin(y / x);
	}*/

    public double getX(){
	return x;
    }

    public double getY(){
	return y;
    }

    public double getMagnitude(){
	return magnitude;
    }

    public double getDirection(){
	return direction;
    }

    public void setMagnitude(double mag){
	x = x / magnitude * mag;
	y = y / magnitude * mag;
	magnitude = mag;
    }

    public Vector getNormal(){
	return new Vector(direction + Math.PI / 2, 1);
    }

    public double dot(Vector other){
	return x * other.getX() + y * other.getY();
    }

    public Vector scale(double scalor){
	return new Vector(direction, magnitude * scalor);
    }

    public Vector add(Vector other){
	double newX = x + other.getX();
	double newY = y + other.getY();
	double newDir = newY / newX;
	double newMag = Math.sqrt(newX * newX + newY * newY);
	return new Vector(newDir, newMag);
    }

    public Vector minus(Vector other){
	double newX = x - other.getX();
	double newY = y - other.getY();
	double newDir = newY / newX;
	double newMag = Math.sqrt(newX * newX + newY * newY);
	return new Vector(newDir, newMag);
    }
}
