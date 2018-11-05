/*
The join() method of a Thread instance is used to join the 
start of a thread's execution to end of other thread's execution 
such that a thread does not start running until another thread ends. 
If join() is called on a Thread instance, the currently running thread 
will block until the Thread instance has finished executing. 
The join() method waits at most this much milliseconds for this thread 
to die. A timeout of 0 means to wait forever.  
*/ 
import java.lang.*; 
import java.util.*;  
public class JoinDemo implements Runnable{
	public void run(){
		Thread t = Thread.currentThread();  
		System.out.println("Current thread: " + t.getName());  
		// checks if current thread is alive 
		System.out.println("Is Alive? " + t.isAlive());  
	}
	public static void main(String[] args) throws Exception{
		Thread t = new Thread(new JoinDemo());  
		t.start(); 
		// waits for 1000 ms for this thread to die. 
		t.join(1000);  
		System.out.println("\nJoining after 1000" + "ms\n");  
		System.out.println("Current Thread: " + t.getName()); 
		// checks if this thread is alive 
		System.out.println("Is alive? " + t.isAlive()); 
	}
}
