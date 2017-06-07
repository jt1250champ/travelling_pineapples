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
    }

    public ArrayList<Node> findOuterPolygon(){
    }
    
}
