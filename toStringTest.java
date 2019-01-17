import java.io.*; 
import java.util.*;  
class gridtest{
	public int[][] grid = new int[10][10];  
	public gridtest(int[][] grid){
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				this.grid[i][j] = grid[i][j]; 
			}
		}
	}
	public String toString(){
		String ret = ""; 
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				if (j == grid[0].length-1) ret += Integer.toString(grid[i][j]);    
				else ret += String.format(grid[i][j] + " ");  
			}
			if (i != grid.length-1) ret += "\n";  
		}
		return ret; 
	}
}
public class toStringtest{
	public static void main(String[] args){
		int[][] sample = new int[10][10]; 
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				sample[i][j] = i+j;  
			}
		}
		gridtest g1 = new gridtest(sample); 
		System.out.println(g1);   
	}
}
