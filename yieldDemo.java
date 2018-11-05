import java.util.*; 
import java.lang.*;  

class MyThread extends Thread{
	public void run(){
		for (int i = 0; i < 5; i++){
			System.out.println(Thread.currentThread().getName() + " in control."); 
		}
	}
}
public class yieldDemo{
	public static void main(String[] args){
		MyThread t = new MyThread();  
		t.start(); 
		for (int i = 0; i < 5; i++){
			// control passes to child thread 
			Thread.yield(); 
			// after execution of child thread 
			// main thread takes over 
			System.out.println(Thread.currentThread().getName() + " in control.");  
		}
	}
}
