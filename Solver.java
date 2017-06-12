import java.util.*;

public abstract class Solver {
    private Map map;
    private ArrayList<Node> solution;
    private double dist;
    
    abstract void solve();

    public double getDist() {
	return dist;
    }
    
    public String toString() {
	String nodes = "";
	for (int i = 0; i < solution.size(); i ++){
	    nodes += solution.get(i) + "\n";
	}
	return "Dist: " + dist + "\n" + "The path taken is: \n" + nodes;
	//TODO uh i have to do the thing wtih the path but that should be in my linked list so im gonna have to find that and then...do the thing this comment makes no sense sorry
    }
    
}
