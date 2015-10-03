package Astar_ManhattanHeuristic_Solver;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Node {
	private ArrayList<String> BoardArray;
	private static final String Goal = " ,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
	private int visited;
	private int h_n;	// number of misplaced tiles
	private int g_n;	// cost so far to reach the node
	
	public Node(String boardV, int g_nV){
		setBoard(boardV);
		setHn();
		g_n = g_nV;
		visited = 0;
	}
	
	public Node(Node n){ // generate a copy constructor
//		System.out.println("copy Node:");
		h_n = n.getHn();
		g_n = n.getGn();
		this.setVisited(n.getVisited());
		BoardArray = new ArrayList<String>();
		for(String elem : n.getBoard()){
			BoardArray.add(elem);
		}
	}
	
	//This Hn is for Heuristic1
	public void setHn(){
		int Hn = 0;
		ArrayList<String> Board = new ArrayList<String>();
		StringTokenizer strtok = new StringTokenizer(Goal, ","); // Board Split by comma
		while(strtok.hasMoreElements()){
			String elem = (String)strtok.nextElement();
			Board.add(elem);
		}
		for(int i = 0; i < Board.size(); i++){
			if(!BoardArray.get(i).equals(" ") && !BoardArray.get(i).equals(Board.get(i))){
				Hn++;
			}
		}
		h_n = Hn;
//		System.out.println("Misplaced tiles: " + Hn);
	}
	
	
	public int getGn(){
		return g_n;
	}
	
	public int getHn(){
		return h_n;
	}
	
	public ArrayList<String> getBoard(){
		ArrayList<String> board = new ArrayList<String>();
		for(String s : BoardArray){
			board.add(s);
		}
		return board;
	}
	
	public String getBoardToString(){
		String value = "";
		for(int i = 0; i < BoardArray.size(); i++){
			if(i == BoardArray.size() - 1)
				value = value + BoardArray.get(i);
			else
				value = value + BoardArray.get(i) + ",";
		}
//		System.out.println(value);
		return value;
	}
	
	public void setVisited(int val){
		visited = val;
	}
	
	public int getVisited(){
		return visited;
	}
	
	public void setBoard(String board){
		BoardArray = new ArrayList<String>();
		StringTokenizer strtok = new StringTokenizer(board, ","); // Board Split by comma
		while(strtok.hasMoreElements()){
			String elem = (String)strtok.nextElement();
			BoardArray.add(elem);
		}
	}
	
	public void displayBoard(){
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
}
