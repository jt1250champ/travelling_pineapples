import java.util.*;

public class NearestNeighbor extends Solver {
    private Map map;
    private ArrayList<Node> solution;
    private double dist;
    private Node firstNode;

    public NearestNeighbor(Map file){
	map = file;
	solution = new ArrayList<Node>();
	firstNode = map.getPoints().get(0);
	dist = 0;
    }
    
    public void solve(){
	solve(firstNode);
    }

    public void solve(Node pine){
	Node next;
	while (someNodesNotPassed()){
	    solution.add(pine);
	    pine.setPassed(true);
	    next = findNearestTo(pine);
	    dist += pine.distanceTo(next);
	    pine = next;
	}
	dist += pine.distanceTo(firstNode);
	//System.out.println(solution);
    }

    public Node findNearestTo(Node apple){
	double leastDist = map.getDiagonalSize();
	Node closest = apple;
	ArrayList<Node> setOfNodes = map.getPoints();
	for (int i = 0; i < setOfNodes.size(); i ++){
	    if (setOfNodes.get(i) != apple && !setOfNodes.get(i).getPassed()){
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

    
    public double getDist(){
	return dist;
    }
    /*
    public static void main(String[]args){
	Map apple2 = new Map("2apples.txt");
	Map apple1000 = new Map("1000apples.txt");

	NearestNeighbor solve2 = new NearestNeighbor(apple2);
	NearestNeighbor solve1000 = new NearestNeighbor(apple1000);

	solve2.solve();
	solve1000.solve();

	System.out.println(solve2.getDist());
	System.out.println(solve1000.getDist());
	}
    */
}
