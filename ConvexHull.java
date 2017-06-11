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
	int nodeIndex;
	double leastDist = map.getDiagonalSize();
	Edge edge;
	for (int i = 0; i < solution.size(); i ++){
	    edge = new Edge(solution.get(i), solution.get((i + 1) % solution.size()));
	    if (pine.distToEdge(edge) < leastDist){
		leastDist = pine.distToEdge(edge);
		nodeIndex = i;
	    }
	}
	solution.add(i, pine);
    }

    public boolean areMoreOuterNodes(){
    }

    public Node findNodeNearestToPolygon(){
	Node node;
	Node answer = new Node(0,0);
	double leastDist = map.getDiagonalSize();
	for (int i = 0; i < map.getPoints().size(); i ++){
	    if (!map.getPoints().get(i).getPassed()){
		node = map.getPoints().get(i);
		answer = node;
		Edge edge;
		double dist;
		for (int i = 0; i < solution.size() - 1; i ++){
		    edge = new Edge(solution.get(i), solution.get(i + 1));
		    dist = node.distToEdge(edge); //write this in node
		    if (dist < leastDist){
			leastDist = dist;
			answer = node;
		    }
		}
	    }
	}
	return answer;
    }
    
}
