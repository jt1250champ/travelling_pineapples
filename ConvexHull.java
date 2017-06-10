import java.util.*;
public class ConvexHull extends Solver {
    private Map map;
    private ArrayList<Node> solution;
    private double dist;
    
    public ConvexHull(Map file){
	map = file;
	solution = new ArrayList<Node>();
	dist = 0;
    }

    public void solve(){
	findOuterPolygon();
	while(someNodesNotPassed()){ //copy from NearestNeighbor
	    insert(findNodeNearestToPolygon());
	}
    }

    public void findOuterPolygon(){
	Node node;
	for (i = 0; i < 3; i ++){
	    node = map.findOuterNode();//make method in Map
	    solution.add(node);
	    node.setPassed(true);
	}
	while (areMoreOuterNodes()){
	    node = map.findOuterNode();
	    insert(node);
	    node.setPassed(true);
	}
    }

    public void insert(Node pine){
	
    }

    public boolean areMoreOuterNodes(){
    }

    public Node findNodeNearestToPolygon(){
    }
    
}
