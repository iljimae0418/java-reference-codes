import java.util.*;  
public class hashmaptest{
	public static void main(String[] args){
		HashMap<Integer,Integer> map = new HashMap<>();  
		map.put(0,0);  
		map.put(1,2);  
		map.put(2,3); 
		for (Map.Entry<Integer,Integer> entry :  map.entrySet()){
			System.out.println(entry.getKey() + ":" + entry.getValue()); 
		}
		int[] skirt;    
		int i = 0;   
		for (Map.Entry<Integer,Integer> entry : map.entrySet()){
			skirt[i++] = entry.getValue();  
		}
		for (int j = 0; j < skirt.length; j++){
			System.out.println(skirt[j]);  
		}
	}
}
