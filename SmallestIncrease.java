import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class SmallestIncrease implements Solver {
    private Map map;
    private LinkedList<Node> solution;
    private double dist;

    public void solve() {
	
    }

    public void solve(Node start) {
    }

    public double getDist() {
	return dist;
    }

    public String toString() {
	return "Dist: " + this.getDist() + "\n" + "The path taken is ";
	//TODO uh i have to do the thing wtih the path but that should be in my linked list so im gonna have to find that and then...do the thing this comment makes no sense sorry
    }
    
    
}
