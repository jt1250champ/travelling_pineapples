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
	    node = findOuterNode();
	    solution.add(node);
	    node.setPassed(true);
	}
	while (areMoreOuterNodes()){
	    node = findOuterNode();
	    insert(node);
	    node.setPassed(true);
	}
    }

    //return index of first node in solution
    public int findNearestEdge(Node pine){
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
	return nodeIndex;
    }

    public void insert(Node pine){
	int nodeIndex = findNearestEdge(pine) + 1;
	solution.add(nodeIndex, pine);
    }

    public boolean areMoreOuterNodes(){
	Node node;
	Edge pine, apples;
	for (int i = 0; i < map.getPoints().size(); i ++){
	    node = map.getPoints().get(i);
	    pine = new Edge(node, new Node(map.getSizeX()/2, map.getSizeY()/2));
	    for (int j = 0; j < solution.size(); j ++){
		apples = new Edge(solution.get(j), solution.get((j + 1) % solution.size()));
		if (pine.intersect(apples)){
		    return true;
		}
	    }
	}
	return false;
    }

    public Node findOuterNode(){
	double leastDist = map.getDiagonalSize();
	Node node;
	Node answer;
	for (int i = 0; i < map.getPoints().size(); i ++){
	    node = map.getPoints().get(i);
	    if (!node.getPassed()){
		if (node.getX() < leastDist){
		    leastDist = node.getX();
		    answer = node;
		}
		if (node.getY() < leastDist){
		    leastDist = node.getY();
		    answer = node;
		}
		if (map.sizeX() - node.getX() < leastDist){
		    leastDist = map.sizeX() - node.getX();
		    answer = node;
		}
		if (map.sizeY() - node.getY() < leastDist){
		    leastDist = map.sizeY() - node.getY();
		    answer = node;
		}
	    }
	}
	return answer;
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
		for (int j = 0; j < solution.size() - 1; j ++){
		    edge = new Edge(solution.get(j), solution.get(j + 1));
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

    public boolean someNodesNotPassed(){
	for (int i = 0; i < map.getPoints().size(); i ++){
	    if (!map.getPoints().get(i).getPassed()){
		return true;
	    }
	}
	return false;
    }
}
