package BFS_Solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Queue;



public class SolvePuzzle_BFS {
	private static Queue<String> Queue = new LinkedList<String>();
	private static Map<String, String> StateMap = new HashMap<String, String>();
	private static ArrayList<String> BoardArray;
	private static ArrayList<String> SnapShot;
	private static String currentBoard;
	private static ArrayList<String> moves = new ArrayList<String>();
	private static String previousBoard;
	private static int emptyBlockPos;
	private static final String Goal = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15, ";
	/**
	 * Functions for the possible moves, Up, Down, Right, Left, these functions will move only one step per call and update the board
	 */
	public static void moveUp(String val){
		//call lookupvalue function to get the index of the value, test if it can be moved
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
//				displayBoard();
				//TODO add CurrentBoard and previous board to Map
			}else{
				System.err.println("Can not move " + val + "! No empty block.");
			}
		}
	}
	
	public static void moveDown(String val){
		//call lookupvalue function to get the index of the value, test if it can be moved
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
//				displayBoard();
				//TODO add CurrentBoard and previous board to Map
			}else{
				System.err.println("Can not move " + val + "! No empty block.");
			}
		}
	}
	
	public static void moveLeft(String val){
		//call lookupvalue function to get the index of the value, test if it can be moved
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
//				displayBoard();
				//TODO add CurrentBoard and previous board to Map
			}else{
				System.err.println("Can not move " + val + "! No empty block.");
			}
		}
	}
	
	public static void moveRight(String val){
		//call lookupvalue function to get the index of the value, test if it can be moved
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
//				displayBoard();
				//TODO add CurrentBoard and previous board to Map
			}else{
				System.err.println("Can not move " + val + "! No empty block.");
			}
		}
	}
	
	public static int lookUpValue(ArrayList<String> board, String val){
		int position = -1;
		for(int i = 0; i < board.size(); i++){
			if(board.get(i).equals(val)){
				position = i;
			}
		}
//		System.out.println("Position of " + val + " is " + position);
		return position;
	}
	public static void propose(){
		currentBoard = BoardToString(BoardArray);
		previousBoard = BoardToString(SnapShot);
		if(!StateMap.containsKey(currentBoard)){
			StateMap.put(currentBoard, previousBoard); // Current as key, newBoard as value
			Queue.add(currentBoard);
//			displayBoard();
		}
		setBoard();
	}
	//Every time after detect the newBoard, the board need to set back to Initial state
	public static void possibleMoves(){
		setSnapShot();
//		displaySnapShot();
//		currentBoard = BoardToString(SnapShot);
		emptyBlockPos = lookUpValue(SnapShot, " ");
		if(emptyBlockPos < 0 || emptyBlockPos > 15){
			System.err.println("Error: emptyBlockPos out of band");
		}else if(emptyBlockPos == 0){//corners
			moveLeft(BoardArray.get(1)); // get the new board in BoardArray
			propose();
			moveUp(BoardArray.get(4)); 
			propose();
		}else if(emptyBlockPos == 3){
			moveRight(BoardArray.get(2)); // get the new board in BoardArray
			propose();
			moveUp(BoardArray.get(7)); 
			propose();
		}else if(emptyBlockPos == 12){
			moveLeft(BoardArray.get(13)); // get the new board in BoardArray
			propose();
			moveDown(BoardArray.get(8)); 
			propose();
		}else if(emptyBlockPos == 15){
			moveRight(BoardArray.get(14)); // get the new board in BoardArray
			propose();
			moveDown(BoardArray.get(11)); 
			propose();
		}else if (emptyBlockPos == 5 || emptyBlockPos == 6 || emptyBlockPos == 9 || emptyBlockPos == 10){//middle
			int row = emptyBlockPos / 4;
			int col = emptyBlockPos % 4;
			//movedown
			moveDown(BoardArray.get((row-1)*4 + col)); 
			propose();
			//moveup
			moveUp(BoardArray.get((row+1)*4 + col)); 
			propose();
			//moveLeft
			moveLeft(BoardArray.get(row*4 + col + 1)); 
			propose();
			//moveRight
			moveRight(BoardArray.get(row*4 + col - 1)); 
			propose();
		}else{//side edge, 3 steps
			if(emptyBlockPos == 1 || emptyBlockPos == 2){
				int row = emptyBlockPos / 4;
				int col = emptyBlockPos % 4;
				//moveUp
				moveUp(BoardArray.get((row+1)*4 + col)); 
				propose();
				//moveLeft
				moveLeft(BoardArray.get(row*4 + col + 1)); 
				propose();
				//moveRight
				moveRight(BoardArray.get(row*4 + col - 1)); 
				propose();
			}else if (emptyBlockPos == 13 || emptyBlockPos == 14){
				int row = emptyBlockPos / 4;
				int col = emptyBlockPos % 4;
				//moveDown
				moveDown(BoardArray.get((row-1)*4 + col)); 
				propose();
				//moveLeft
				moveLeft(BoardArray.get(row*4 + col + 1)); 
				propose();
				//moveRight
				moveRight(BoardArray.get(row*4 + col - 1)); 
				propose();
			}else if(emptyBlockPos == 4 || emptyBlockPos == 8){
				int row = emptyBlockPos / 4;
				int col = emptyBlockPos % 4;
				//movedown
				moveDown(BoardArray.get((row-1)*4 + col)); 
				propose();
				//moveup
				moveUp(BoardArray.get((row+1)*4 + col)); 
				propose();
				//moveLeft
				moveLeft(BoardArray.get(row*4 + col + 1)); 
				propose();
			}else if(emptyBlockPos == 7 || emptyBlockPos == 11){
				int row = emptyBlockPos / 4;
				int col = emptyBlockPos % 4;
				//movedown
				moveDown(BoardArray.get((row-1)*4 + col)); 
				propose();
				//moveup
				moveUp(BoardArray.get((row+1)*4 + col)); 
				propose();
				//moveRight
				moveRight(BoardArray.get(row*4 + col - 1)); 
				propose();
			}
		}
		
	}
	
	public static boolean isGoal(){
		boolean isgoal = false;
		String currentBoard = BoardToString(BoardArray);
		if(currentBoard.equals(Goal)){
			isgoal = true;
		}
		return isgoal;
	}
	
	/**
	 * This function use to convert the ArrayList of the board to string with the same format with initial board
	 * @param Board
	 * @return
	 */
	public static String BoardToString(ArrayList<String> Board){
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
	
	public static void getBoard(String board){
		BoardArray = new ArrayList<String>();
		StringTokenizer strtok = new StringTokenizer(board, ","); // Board Split by comma
		while(strtok.hasMoreElements()){
			String elem = (String)strtok.nextElement();
			BoardArray.add(elem);
		}
	}
	
	public static void setSnapShot(){
		SnapShot = new ArrayList<String>();
		for(String s : BoardArray){
			SnapShot.add(s);
		}
//		display board
//		displaySnapShot();
	}
	
	public static void setBoard(){
		BoardArray = new ArrayList<String>();
		for(String s : SnapShot){
			BoardArray.add(s);
		}
	}
	
	
	public static void displaySnapShot(){
//		display board
		System.out.println(" --SnapShot-- "); 
		for(int i = 0; i < 4; i++){
			String line = "|";
			for(int j = 0; j < 4; j++){
				int index = i*4 + j;
				String value = SnapShot.get(index);
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
//		BoardToString(SnapShot);
	}
	
	public static void displayBoard(){
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
//		BoardToString(BoardArray);
	}

	public static void BFS(String initialBoard){
		getBoard(initialBoard);
		setSnapShot();
		currentBoard = BoardToString(BoardArray);
		previousBoard = BoardToString(SnapShot);
		if(!StateMap.containsKey(currentBoard)){
			StateMap.put(currentBoard, " "); // Current as key, newBoard as value
			Queue.add(currentBoard);
			setBoard();
		}
		while(!Queue.isEmpty()){
//			System.out.println("Queue: " + Queue.size());
			getBoard(Queue.remove());
//			System.out.println("Queue: " + Queue.size());
			String currentboard = BoardToString(BoardArray);
			if(isGoal()){
				traceBack(currentboard, initialBoard);
				printMoves();
				break;
			}else{
				possibleMoves();
			}
		}
	}
	
	public static void traceBack(String board, String initialBoard){
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
//			System.out.println("The value is: " + value + " the size: " + movelist.size());
			moves.add(value);
			
		}
	}
	
	public static void printMoves(){
		System.out.println("-----Solution-----");
		for(int i = 0; i < moves.size(); i++){
			int steps = i;
			if(i==0){
				System.out.println("Original Board: ");
			}else{
				System.out.println("step " + steps + ": ");
			}
			getBoard(moves.get(i));
			displayBoard();
		}
		System.out.println("Goal Reached!");
		
	}
	
	public static void main(String[] args){
		System.out.println("Breath_First_Search:");
		String BOARD = "1,6,2,3,5,10,8,4, ,13,7,11,14,9,15,12"; //BFS solve it in 14 steps
		String BOARD1 = "1,2, ,3,5,6,7,4,9,10,11,8,13,14,15,12"; // BFS solve it in 4 steps
		String BOARD2 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15, ";
		String BOARD3 = "1, ,2,4,5,7,3,8,9,6,11,12,13,10,14,15"; // case list one the hand out(case 1)
		BFS(BOARD);
	}
}


