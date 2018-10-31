import java.io.*; 
import java.util.*;  
public class sortUserDefinedTest{
	private int[][] grid = new int[9][9];   
	public sortUserDefinedTest(int[][] ints){
		for (int i = 0; i < ints.length; i++){
			for (int j = 0; j < ints[0].length; j++){
				grid[i][j] = ints[i][j];  
			}
		}
	}
	class spot{
		private HashSet<Integer> assignable;  
		int row; 
		int col; 
		public spot(HashSet<Integer> assignable,int r,int c){
			this.assignable = assignable;  
			this.row = r; 
			this.col = c; 
		}
		public int spot_size(){
			return assignable.size(); 
		}
		public void print_coordinates(){
			System.out.println("(" + row + "," + col + ")"); 
		}
	}
	/**
	 * Returns whether any assigned entry in the specified 
	 * row matches the given number 
	 */
	public boolean UsedInRow(int row,int num){
		for (int col = 0; col < grid[0].length; col++){
			if (grid[row][col] == num) return true;  
		}
		return false;  
	}
	
	/**
	 * Returns whether any assigned entry in the specified 
	 * column matches the given number  
	 */
	public boolean UsedInCol(int col,int num){
		for (int row = 0; row < grid.length; row++){
			if (grid[row][col] == num){
				return true; 
			}
		}
		return false; 
	}
	
	/**
	 * Returns whether any assigned entry within the 3x3 
	 * box matches the given number 
	 */
	public boolean UsedInBox(int startRow,int startCol,int num){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				if (grid[row+startRow][col+startCol] == num){
					return true;  
				}
			}
		}
		return false; 
	}
	
	/** 
	 * Checks if it is legal to assign number to the given 
	 * (row,column) location 
	 */
	public boolean isLegal(int row,int col,int num){
		return !UsedInRow(row,num) && !UsedInCol(col,num) 
				&& !UsedInBox(row-row%3,col-col%3,num);  
	}
	
	/**
	 * Used for sorting an ArrayList containing instances of 
	 * the class spot in ascending order of size of assignables. 
	 */
	class SortByConstrained implements Comparator<spot>{
		public int compare(spot a,spot b){
			return a.assignable.size() - b.assignable.size(); 
		}
	}
	
	/**
	 * Generate all the spots and sort the spots into order 
	 * by the size of their set of assignable numbers with 
	 * the smallest set spots coming first.   
	 */
	public ArrayList<spot> generateSpots(){
		ArrayList<spot> spots = new ArrayList<spot>(); 
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				if (grid[i][j] == 0){ // if this cell is empty 
					HashSet<Integer> set = new HashSet<Integer>();  
					spot s = new spot(set,i,j); 
					for (int k = 1; k <= 9; k++){
						if (isLegal(i,j,k)){
							s.assignable.add(k); 
						}
					}
					spots.add(s); 
				}
			}
		}
		Collections.sort(spots,new SortByConstrained()); 
		return spots; 
	}
	public static void main(String[] args){
		int[][] grid = new int[9][9]; 
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length;j++){
				grid[i][j] = 0;  
			}
		}
		sortUserDefinedTest sd = new sortUserDefinedTest(grid);  
		ArrayList<sortUserDefinedTest.spot> al = sd.generateSpots(); 
		System.out.println(al.size()); 
	}
}
