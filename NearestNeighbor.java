public class NearestNeighbor implements Solver {
    private Map map;
    private LinkedList<Node> solution;
    private double dist;
    private Node firstNode;

    public NearestNeighbor(Map file){
	map = file;
	solution = new LinkedList<Node>();
	firstNode = map.getPoints().get(0);
	dist = 0;
    }
    
    public void solve(){
	solve(firstNode);
    }

    public void solve(Node pine){
	solution.add(pine);
	pine.setPassed(true);
	if (someNodesNotPassed()){
	    Node next = findNearestTo(pine);
	    totalDist += pine.distanceTo(next);
	    solve(next);
	}
	else{
	    totalDist += pine.distTo(firstNode);
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

    public boolean someNodesNotPassed(){
	for (int i = 0; i < map.getPoints().size(); i ++){
	    if (!map.getPoints().get(i).getPassed()){
		return true;
	    }
	}
	return false;
    }

    public static void main(String[]args){
	Map apple2 = new Map("2apples.txt");
	Map apple10 = new Map("10apples.txt");

	NearestNeighbor solve2 = new NearestNeighbor(apple2);
	NearestNeighbor solve10 = new NearestNeighbor(apple10);

	solve2.solve();
	solve10.solve();

	System.out.println(sovle2.getDist());
	System.out.println(sovle10.getDist());
    }
}
