import java.util.*;  
public class demoRunnable{
	public static void main(String[] args){
		Runnable runnable = new Runnable(){
			public void run(){
				System.out.println("Yay Runnable!~");  
			}
		};  
		// make a thread on the runnable and run it 
		Thread thread = new Thread(runnable); 
		thread.start();  
	}
}
