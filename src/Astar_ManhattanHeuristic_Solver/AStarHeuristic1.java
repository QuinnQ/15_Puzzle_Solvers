package Astar_ManhattanHeuristic_Solver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class AStarHeuristic1 {

	private ArrayList<Node> activeNode = new ArrayList<Node>();
	private Map<String, String> StateMap = new HashMap<String, String>();
	private Map<String, String> MoveMap = new HashMap<String, String>();
	private static ArrayList<String> moves = new ArrayList<String>();
	private static ArrayList<String> moveDirs = new ArrayList<String>();
//	private static final String Goal = " ,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
	private Node currentNode;
	private Node previousNode;
	private boolean isGoal = false;
//	private Node GoalState;

	
	private int expandNodeCounter = 0;
//	private static ArrayList<String> BoardArray;
//	
//	public static void setBoardArray(Node n){
//		BoardArray = n.getBoard();
//	}
	
	public AStarHeuristic1(String Board){
		AStarSolver(Board);
	}
	
	public int lookUpNode(Node n){
		int i = -1;
		for(i = 0; i < activeNode.size(); i++){
			if(activeNode.get(i).getBoardToString().equals(n.getBoardToString())){
				break;
			}
		}
		return i;
	}
	
	public int FindMinFn(){
		if(activeNode.size() == 1){
			return 0;
		}else{
			Node min = activeNode.get(0);
			int Fn = activeNode.get(0).getGn() + activeNode.get(0).getHn();
			int index = 0;
			for(int i = 1; i < activeNode.size(); i++){
				if(Fn >= activeNode.get(i).getGn() + activeNode.get(i).getHn()){
					min = activeNode.get(i);
					Fn = activeNode.get(i).getGn() + activeNode.get(i).getHn();
					index = i;
				}
			}
			return index;
		}
	}
	
	public String BoardToString(ArrayList<String> Board){
		String value = "";
		for(int i = 0; i < Board.size(); i++){
			if(i == Board.size() - 1)
				value = value + Board.get(i);
			else
				value = value + Board.get(i) + ",";
		}
//		System.out.println(value);
		return value;
	}
	
	public void moveUp(Node n, String val){
//		System.out.println("MOVE UP");
		//call lookupvalue function to get the index of the value, test if it can be moved
		previousNode = new Node(n);
//		previousNode.displayBoard();
		ArrayList<String> BoardArray = previousNode.getBoard();
		int position = lookUpValue(BoardArray, val);
		int row = -1;
		int col = -1;
		if( position == -1){
			System.err.println("Invalid value for moving.");
		}else if(val.equals(" ")){
			System.err.println("Empty block can not be moved.");
		}else{
			row = position / 4;
			col = position % 4;
			int newRow = row - 1;
			if(newRow < 0){
				System.err.println("Can not move " + val + "! Out of Board.");
			}else if(BoardArray.get(newRow * 4 + col).equals(" ")){
				BoardArray.set(newRow * 4 + col, val);
				BoardArray.set(position, " ");
				currentNode = new Node(BoardToString(BoardArray), previousNode.getGn()+1);
//				currentNode.displayBoard();
			}else{
				System.err.println("Can not move " + val + "! No empty block.");
			}
		}
	}
	
	public void moveDown(Node n, String val){
//		System.out.println("MOVE DOWN");
		//call lookupvalue function to get the index of the value, test if it can be moved
		previousNode = new Node(n);
//		previousNode.displayBoard();
		ArrayList<String> BoardArray = previousNode.getBoard();
		int position = lookUpValue(BoardArray, val);
		int row = -1;
		int col = -1;
		if( position == -1){
			System.err.println("Invalid value for moving.");
		}else if(val.equals(" ")){
			System.err.println("Empty block can not be moved.");
		}else{
			row = position / 4;
			col = position % 4;
			int newRow = row + 1;
			if(newRow > 3){
				System.err.println("Can not move " + val + "! Out of Board.");
			}else if(BoardArray.get(newRow * 4 + col).equals(" ")){
				BoardArray.set(newRow * 4 + col, val);
				BoardArray.set(position, " ");
				currentNode = new Node(BoardToString(BoardArray), previousNode.getGn()+1);
//				currentNode.displayBoard();
			}else{
				System.err.println("Can not move " + val + "! No empty block.");
			}
		}
	}
	
	public void moveLeft(Node n, String val){
//		System.out.println("MOVE LEFT");
		//call lookupvalue function to get the index of the value, test if it can be moved
		previousNode = new Node(n);
//		previousNode.displayBoard();
		ArrayList<String> BoardArray = previousNode.getBoard();
		int position = lookUpValue(BoardArray, val);
		int row = -1;
		int col = -1;
		if( position == -1){
			System.err.println("Invalid value for moving.");
		}else if(val.equals(" ")){
			System.err.println("Empty block can not be moved.");
		}else{
			row = position / 4;
			col = position % 4;
			int newCol = col - 1;
			if(newCol < 0){
				System.err.println("Can not move " + val + "! Out of Board.");
			}else if(BoardArray.get(row * 4 + newCol).equals(" ")){
				BoardArray.set(row * 4 + newCol, val);
				BoardArray.set(position, " ");
				currentNode = new Node(BoardToString(BoardArray), previousNode.getGn()+1);
//				currentNode.displayBoard();
			}else{
				System.err.println("Can not move " + val + "! No empty block.");
			}
		}
	}
	
	public void moveRight(Node n, String val){
//		System.out.println("MOVE RIGHT");
		//call lookupvalue function to get the index of the value, test if it can be moved
		previousNode = new Node(n);
//		previousNode.displayBoard();
		ArrayList<String> BoardArray = previousNode.getBoard();
		int position = lookUpValue(BoardArray, val);
		int row = -1;
		int col = -1;
		if( position == -1){
			System.err.println("Invalid value for moving.");
		}else if(val.equals(" ")){
			System.err.println("Empty block can not be moved.");
		}else{
			row = position / 4;
			col = position % 4;
			int newCol = col + 1;
			if(newCol > 3){
				System.err.println("Can not move " + val + "! Out of Board.");
			}else if(BoardArray.get(row * 4 + newCol).equals(" ")){
				BoardArray.set(row * 4 + newCol, val);
				BoardArray.set(position, " ");
				currentNode = new Node(BoardToString(BoardArray), previousNode.getGn()+1);
//				currentNode.displayBoard();
			}else{
				System.err.println("Can not move " + val + "! No empty block.");
			}
		}
	}
	
	public int lookUpValue(ArrayList<String> board, String val){
		int position = -1;
		for(int i = 0; i < board.size(); i++){
			if(board.get(i).equals(val)){
				position = i;
			}
		}
//		System.out.println("Position of " + val + " is " + position);
		return position;
	}
	
	public void propose(String moveDir){
		String currentBoard = currentNode.getBoardToString();
		String previousBoard = previousNode.getBoardToString();
		if(!StateMap.containsKey(currentBoard)){
			StateMap.put(currentBoard, previousBoard); // Current as key, newBoard as value
			MoveMap.put(currentBoard, moveDir);
//			System.out.println("Node add to activeList");
//			currentNode.displayBoard();
//			System.out.println(currentNode.getGn() + "--" + currentNode.getHn() + "--" + currentNode.getVisited());
			activeNode.add(new Node(currentNode));
			expandNodeCounter++;
		}
	}
	
	public void possibleMoves(Node n){
		previousNode = new Node(n);
//		previousNode.displayBoard();
		ArrayList<String> BoardArray = previousNode.getBoard();
		int emptyBlockPos = lookUpValue(BoardArray, " ");
		if(emptyBlockPos < 0 || emptyBlockPos > 15){
			System.err.println("Error: emptyBlockPos out of band");
		}else if(emptyBlockPos == 0){//corners
			moveLeft(previousNode, BoardArray.get(1)); // get the new board in BoardArray
			propose("L");
			if(isGoal()){
				isGoal = true;
				return;
			}
			moveUp(previousNode, BoardArray.get(4)); 
			propose("U");
			if(isGoal()){
				isGoal = true;
				return;
			}
		}else if(emptyBlockPos == 3){
			moveRight(previousNode, BoardArray.get(2)); // get the new board in BoardArray
			propose("R");
			if(isGoal()){
				isGoal = true;
				return;
			}
			moveUp(previousNode, BoardArray.get(7)); 
			propose("U");
			if(isGoal()){
				isGoal = true;
				return;
			}
		}else if(emptyBlockPos == 12){
			moveLeft(previousNode, BoardArray.get(13)); // get the new board in BoardArray
			propose("L");
			if(isGoal()){
				isGoal = true;
				return;
			}
			moveDown(previousNode, BoardArray.get(8)); 
			propose("D");
			if(isGoal()){
				isGoal = true;
				return;
			}
		}else if(emptyBlockPos == 15){
			moveRight(previousNode, BoardArray.get(14)); // get the new board in BoardArray
			propose("R");
			if(isGoal()){
				isGoal = true;
				return;
			}
			moveDown(previousNode, BoardArray.get(11)); 
			propose("D");
			if(isGoal()){
				isGoal = true;
				return;
			}
		}else if (emptyBlockPos == 5 || emptyBlockPos == 6 || emptyBlockPos == 9 || emptyBlockPos == 10){//middle
			int row = emptyBlockPos / 4;
			int col = emptyBlockPos % 4;
			//movedown
			moveDown(previousNode, BoardArray.get((row-1)*4 + col)); 
			propose("D");
			if(isGoal()){
				isGoal = true;
				return;
			}
			//moveup
			moveUp(previousNode, BoardArray.get((row+1)*4 + col)); 
			propose("U");
			if(isGoal()){
				isGoal = true;
				return;
			}
			//moveLeft
			moveLeft(previousNode, BoardArray.get(row*4 + col + 1)); 
			propose("L");
			if(isGoal()){
				isGoal = true;
				return;
			}
			//moveRight
			moveRight(previousNode, BoardArray.get(row*4 + col - 1)); 
			propose("R");
			if(isGoal()){
				isGoal = true;
				return;
			}
		}else{//side edge, 3 steps
			if(emptyBlockPos == 1 || emptyBlockPos == 2){
				int row = emptyBlockPos / 4;
				int col = emptyBlockPos % 4;
				//moveUp
				moveUp(previousNode, BoardArray.get((row+1)*4 + col)); 
				propose("U");
				if(isGoal()){
					isGoal = true;
					return;
				}
				//moveLeft
				moveLeft(previousNode, BoardArray.get(row*4 + col + 1)); 
				propose("L");
				if(isGoal()){
					isGoal = true;
					return;
				}
				//moveRight
				moveRight(previousNode, BoardArray.get(row*4 + col - 1)); 
				propose("R");
				if(isGoal()){
					isGoal = true;
					return;
				}
			}else if (emptyBlockPos == 13 || emptyBlockPos == 14){
				int row = emptyBlockPos / 4;
				int col = emptyBlockPos % 4;
				//moveDown
				moveDown(previousNode, BoardArray.get((row-1)*4 + col)); 
				propose("D");
				if(isGoal()){
					isGoal = true;
					return;
				}
				//moveLeft
				moveLeft(previousNode, BoardArray.get(row*4 + col + 1)); 
				propose("L");
				if(isGoal()){
					isGoal = true;
					return;
				}
				//moveRight
				moveRight(previousNode, BoardArray.get(row*4 + col - 1)); 
				propose("R");
				if(isGoal()){
					isGoal = true;
					return;
				}
			}else if(emptyBlockPos == 4 || emptyBlockPos == 8){
				int row = emptyBlockPos / 4;
				int col = emptyBlockPos % 4;
				//movedown
				moveDown(previousNode, BoardArray.get((row-1)*4 + col)); 
				propose("D");
				if(isGoal()){
					isGoal = true;
					return;
				}
				//moveup
				moveUp(previousNode, BoardArray.get((row+1)*4 + col)); 
				propose("U");
				if(isGoal()){
					isGoal = true;
					return;
				}
				//moveLeft
				moveLeft(previousNode, BoardArray.get(row*4 + col + 1)); 
				propose("L");
				if(isGoal()){
					isGoal = true;
					return;
				}
			}else if(emptyBlockPos == 7 || emptyBlockPos == 11){
				int row = emptyBlockPos / 4;
				int col = emptyBlockPos % 4;
				//movedown
				moveDown(previousNode, BoardArray.get((row-1)*4 + col)); 
				propose("D");
				if(isGoal()){
					isGoal = true;
					return;
				}
				//moveup
				moveUp(previousNode, BoardArray.get((row+1)*4 + col)); 
				propose("U");
				if(isGoal()){
					isGoal = true;
					return;
				}
				//moveRight
				moveRight(previousNode, BoardArray.get(row*4 + col - 1)); 
				propose("R");
				if(isGoal()){
					isGoal = true;
					return;
				}
			}
		}
//		System.out.println(activeNode.size());
	}
	
	public boolean isGoal(){
		if(currentNode.getHn() == 0)
			return true;
		else
			return false;
	}

//	public String parseBoard(String dir_board){
//		StringTokenizer strtok = new StringTokenizer(dir_board, "|"); // Board Split by comma
//		moveDirs.add(strtok.nextToken());
//		String board = strtok.nextToken();
//		return board;
//	}
	
	public void traceBack(String board, String initialBoard){
		String boardVal = "";
		boardVal = board;
		ArrayList<String> movelist = new ArrayList<String>();
		movelist.add(boardVal);
		while(!StateMap.get(initialBoard).equals(boardVal)){
			boardVal = StateMap.get(boardVal);
			if(!boardVal.equals(" "))
				movelist.add(boardVal);			
		}
		while(movelist.size() > 0){
			String value = movelist.remove(movelist.size()-1);
			if(MoveMap.get(value)!= null){
				String Dirc = MoveMap.get(value);
				moveDirs.add(Dirc);
			}

//			System.out.println("The value is: " + value + " the size: " + movelist.size());
			moves.add(value);
			
		}
	}
	
	public void printMoveDir(){
		System.out.println("\n---Solution moves---");
		String dir = "";
		for(int i = 0; i < moveDirs.size(); i++){
			dir += moveDirs.get(i);
		}
		System.out.println(dir);
	}
	
	public void printMoves(){
		System.out.println("\n---Solution boards---");
		for(int i = 0; i < moves.size(); i++){
			int steps = i;
			if(i==0){
				System.out.println("Original Board: ");
			}else{
				System.out.println("step " + steps + ": ");
			}
			stringToBoard(moves.get(i));
		}
		System.out.println("Goal Reached!");
		
	}
	
	public void stringToBoard(String board){
		ArrayList<String> BoardArray = new ArrayList<String>();
		StringTokenizer strtok = new StringTokenizer(board, ","); // Board Split by comma
		while(strtok.hasMoreElements()){
			String elem = (String)strtok.nextElement();
			BoardArray.add(elem);
		}
		System.out.println(" --Board-- "); 
		for(int i = 0; i < 4; i++){
			String line = "|";
			for(int j = 0; j < 4; j++){
				int index = i*4 + j;
				String value = BoardArray.get(index);
				if(j == 3){
					if(!value.equals(" ")){
						int val_int = Integer.parseInt(value);
						if(val_int <10)
						line = line + value + " ";
						else 
							line = line + value;
					}else
						line = line + value + " ";
				}else{
					if(!value.equals(" ")){
						int val_int = Integer.parseInt(value);
						if(val_int <10)
						line = line + value + "  ";
						else 
							line = line + value + " ";
					}else
						line = line + value + "  ";
				}			
			}
			System.out.println(line + "|");
		}
		System.out.println(" ----------- "); 
	}
	
	public void AStarSolver(String board){
		Node initial = new Node(board, 0);
		currentNode = new Node(initial);
//		currentNode.displayBoard();
//		System.out.println(currentNode.getGn() + "--" + currentNode.getHn() + "--" + currentNode.getVisited());
		String currentBoard = initial.getBoardToString();
		if(!StateMap.containsKey(currentBoard)){
			StateMap.put(currentBoard, " "); // Current as key, newBoard as value
//			System.out.println("Node add to activeList");
//			currentNode.displayBoard();
			activeNode.add(new Node(currentNode));
			expandNodeCounter++;
		}
		while(!isGoal){
			currentNode = new Node(activeNode.remove(FindMinFn()));
			possibleMoves(currentNode);
		}
//		System.out.println("****");
		traceBack(currentNode.getBoardToString(), board);
		printMoveDir();
		printMoves();
		System.out.println("\n---Analysis----");
		System.out.println("Expanded Nodes: " + expandNodeCounter);
	}

}
