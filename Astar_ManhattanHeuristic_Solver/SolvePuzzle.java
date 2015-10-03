package Astar_ManhattanHeuristic_Solver;

public class SolvePuzzle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String BOARD1 = "1,2, ,3,5,6,7,4,9,10,11,8,13,14,15,12"; //Case 1: The board will take 4 steps to solve it
//		String BOARD = "1,6,2,3,5,10,8,4, ,13,7,11,14,9,15,12"; //The board will take 14 steps to solve it
		String BOARD = " ,1,2,3,10,6,8,4,5,13,7,11,14,9,15,12";//Case 3: The board will take 18 steps to solve it
		String BOARD2 = "10,1,2,3,6,8,4, ,7,13,11,12,5,14,9,15"; 
		String BOARD3 = "2,6,10,3,1,4,7,11,8,5,9,15,12,13,14, "; //Case 2:  case list one the hand out(case 1)
		String BOARD4 = "5,1,3,4,2,6,7,8,9,10,12, ,13,14,11,15";

		long startTime = System.currentTimeMillis();
		System.out.println("A* Heuristic1: ");
		AStarHeuristic1 A = new AStarHeuristic1(BOARD3);
	    long total = 0;
	    for (int i = 0; i < 10000000; i++) {
	      total += i;
	    }

	    long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println("Time used: " + elapsedTime);
	 // Get the Java runtime
	    Runtime runtime = Runtime.getRuntime();
	    // Run the garbage collector
	    runtime.gc();
	    // Calculate the used memory
	    long memory = runtime.totalMemory() - runtime.freeMemory();
	    System.out.println("Used memory is bytes: " + memory);
	    System.out.println("Used memory is megabytes: "
	        + (memory/1024L/1024L));
		
	}
}
