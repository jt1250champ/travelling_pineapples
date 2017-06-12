public class Vector{
    private Node endNode;
    private double magnitude;

    public Vector(Node pine, Node apple){
	endNode = new Node(pine.getX() - apple.getX(), pine.getY() - apple.getX());
	magnitude = Math.sqrt(endNode.getX() * endNode.getX() +
			      endNode.getY() * endNode.getY());
    }

    public Vector(Edge edge){
	this(edge.pine, edge.apple);
    }

    public Node getEndNode(){
	return endNode;
    }

    public double getMagnitude(){
	return magnitude;
    }

    public Vector getNormal(){
    }

    public double dot(Vector other){
    }

    public Vector scale(double scalor){
    }

    public Vector add(Vector other){
    }

    public Vector minus(Vector other){
    }
}
