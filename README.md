# Travelling Salesperson Problem

Final Project
JT Tao and Masha Zorin

There is a driver file so from the terminal javac driver.java then java driver [int]. 0 corresponds to nearest neighbor which is really the only one that works perfectly right now.

##Features
- Different methods for finding shortest path between cities
  - NearestNeighbor: starts at one point and goes to the closest city that hasn't been gone to yet
  - SmallestIncrease: adds shortest edges to the path first
  - ConvexHull: creates a convex polygon and then adds the node closest to polygon in the best possible way
  
##Bugs

-ConvexHull probably works wrong - with given time, because testing was difficult, we couldn't figure out why. It does give a path however. It also might be that
- Smallest Increase doesn't work yet
- Because the line drawing and the point drawing requires integers while the coordinates etc. may be doubles, the lines don't perfectly overlap with the points.

##Development Log
- JT and Masha created all of the files needed
- JT and Masha has worked on the background classes of Edge, Node and Map as well as the abstract class Solver
- Masha has completed the first heuristic - Testing of this is happening right now
- JT has worked on the second heuristic
- Masha has tested first heuristic
- Masha has started working on the third heuristic and created a background class of Vector (to do geometry!)
- JT attempted to use Processing
- Masha has updated Node
- Masha completed and tested the third heuristic
- JT has used awt to print the dots for nodes
- JT has (finally -.-) fixed the line drawing
