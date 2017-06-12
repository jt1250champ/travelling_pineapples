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
	if (map.getPoints().size() > 2){
	    findOuterPolygon();
	    while(someNodesNotPassed()){
		insert(findNodeNearestToPolygon());
	    }
	}
	else{
	    for (int i = 0; i < map.getPoints().size(); i ++){
		solution.add(map.getPoints().get(i));
	    }
	}
	updateDist(); 
	//System.out.println(solution);
    }

    public void findOuterPolygon(){
	Node node;
	for (int i = 0; i < 3; i ++){
	    //System.out.println(findOuterNode());
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
	int nodeIndex = -1;
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
	Edge edge;
	Edge pineapple1;
	Edge pineapple2;
	Edge pineapple3;
	Edge pineapple4;
	Node node;
	for (int i = 0; i < map.getPoints().size(); i ++){
	    //System.out.println(map.getPoints().size());
	    node = map.getPoints().get(i);
	    pineapple1 = new Edge(new Node(0, node.getY()), node);
	    pineapple2 = new Edge(new Node(map.getSizeX(), node.getY()), node);
	    pineapple3 = new Edge(new Node(node.getX(), 0), node);
	    pineapple4 = new Edge(new Node(node.getX(), map.getSizeY()), node);
	    if (!node.getPassed()){
		for (int j = 0; j < solution.size(); j ++){
		    //System.out.println(solution.size());
		    edge = new Edge (solution.get(j), solution.get((j + 1) % solution.size()));
		    //System.out.println(edge.getLine());
		    if (!(pineapple1.intersect(edge) &&
			  pineapple2.intersect(edge) &&
			  pineapple3.intersect(edge) &&
			  pineapple4.intersect(edge))){
			return true;
		    }
		}
	    }
	}
	return false;
    }

    public Node findOuterNode(){
	double leastDist = map.getDiagonalSize();
	Node node;
	Node answer = new Node(0.0,0.0);
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
		if (map.getSizeX() - node.getX() < leastDist){
		    leastDist = map.getSizeX() - node.getX();
		    answer = node;
		}
		if (map.getSizeY() - node.getY() < leastDist){
		    leastDist = map.getSizeY() - node.getY();
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
		    dist = node.distToEdge(edge);
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

    public void updateDist(){
	Node pine;
	Node apple;
	for (int i = 0; i < solution.size(); i ++){
	    pine = solution.get(i);
	    apple = solution.get((i + 1) % solution.size());
	    dist += pine.distanceTo(apple);
	    //System.out.println(dist);
	}
    }

    //no idea why i need to do this, it should come from solver :(
    public double getDist(){
	return dist;
    }
    /*
    public static void main(String[]args){
	Map m = new Map("1000apples.txt");
	Map n = new Map("2apples.txt");
	System.out.println(m.getSizeX());
	System.out.println(m.getSizeY());

	ConvexHull apple1000 = new ConvexHull(m);
	ConvexHull apple2 = new ConvexHull(n);

	apple1000.solve();
	apple2.solve();

	System.out.println(apple1000.getDist());
	System.out.println(apple2.getDist());
    }
    */
}

