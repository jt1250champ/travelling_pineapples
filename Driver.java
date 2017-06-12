public class Driver {
    public static void main(String[] args) {
	Map map1 = new Map("USA.txt");
	
	Solver solver;
	if (args[0].equals("0")){
	    solver = new NearestNeighbor(map1);
	}
	//else if (args[0].equals("1")){
	//   solver = new SmallestIncrease(map1);
	//}
	else{
	    solver = new ConvexHull(map1);
	}

	solver.solve();
	System.out.println(solver.getDist());
    }
}
