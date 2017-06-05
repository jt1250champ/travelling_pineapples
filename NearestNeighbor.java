public class NearestNeighbor implements Solver {
    private Map map;
    private LinkedList<Node> solution;
    private Node firstNode;

    public NearestNeighbor(Map file){
	map = file;
	solution = new LinkedList<Node>();
	firstNode = map.getPoints().get(0);
    }
    
    public void solve(){
	solve(firstNode);
    }

    public void solve(Node pine){
	solution.add(pine);
	pine.setPassed(true);
	if (someNodesNotPassed){
	    Node next = findNearestTo(pine);
	    solve(next);
	}
    }

    public Node findNearestTo(Node apple){
	double leastDist = map.getDiagonalSize();
	Node closest = apple;
	ArrayList<Node> setOfNodes = map.getPoinst();
	for (int i = 0; i < setOfNodes.size(); i ++){
	    if (setOfNodes.get(i) != apple){
		double dist = apple.distanceTo(setOfNodes.get(i));
		if (dist < leastDist){
		    leastDist = dist;
		    closest = setOfNodes.get(i);
		}
	    }
	}
	return closest;
    }
}
