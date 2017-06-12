# Travelling Salesperson Problem

Final Project
JT Tao and Masha Zorin

##Features
- Different methods for finding shortest path between cities
  - NearestNeighbor: starts at one point and goes to the closest city that hasn't been gone to yet
  - SmallestIncrease: adds shortest edges to the path first
  - ConvexHull: creates a convex polygon and then adds the node closest to polygon in the best possible way
##Bugs
-ConvexHull probably works wrong - with given time, because testing was difficult, we couldn't figure out why. It does give a path however. It also might be that
##Development Log
- JT and Masha created all of the files needed
- JT and Masha has worked on the background classes of Edge, Node and Map as well as the abstract class Solver
- Masha has completed the first heuristic - Testing of this is happening right now
- JT has worked on the second heuristic
- Masha has tested first heuristic
- Masha has started working on the third heuristic and created a background class of Vector (to do geometry!)
- Masha has updated Node
- Masha completed and tested the third heuristic
