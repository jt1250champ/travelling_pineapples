import java.util.*;
public class ConvexHull extends Solver {
    private Map map;
    private ArrayList<Node> solution;
    private ConvexPolygon polygon;
    private double dist;
    
    public ConvexHull(Map file){
	map = file;
	solution = new ArrayList<Node>();
	polygon = new ConvexPolygon();
	dist = 0;
    }

    public void solve(){
    }

    public ArrayList<Node> findOuterPolygon(){
	Node node;
	for (i = 0; i < 3; i ++){
	    node = map.findOuterNode();
	    polygon.add(node);
	    node.setPassed(true);
	}
    }

    public void insert(Node pine){
	
    }
    
}
