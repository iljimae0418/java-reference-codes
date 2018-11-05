import java.util.*; 
import java.io.*; 
/*
The sum() and incr() methods form a "critical section" 
--they can compute the wrong thing if run by multiple threadsat 
the same time. The sum() and inc() methods are declared"synchronized" 
--they respect the lock in the receiver object.
*/  
class Pair{
	private int a,b;  
	public Pair(){
		a = 0; 
		b = 0; 
	}
	public synchronized int sum(){
		return (a+b); 
	}
	public synchronized void inc(){
		a++; 
		b++;  
	}
}
public class SyncDemo2 extends Thread{
	public final int COUNT = 1000; 
	private Pair pair; 
	public SyncDemo2(Pair pair){
		this.pair = pair; 
	}
	public void run(){
		for (int i = 0; i < COUNT; i++){
			pair.inc();  
		}
	}
	public static void main(String[] args){
		Pair pair = new Pair(); 
		SyncDemo2 w1 = new SyncDemo2(pair); 
		SyncDemo2 w2 = new SyncDemo2(pair);  
		SyncDemo2 w3 = new SyncDemo2(pair); 
		w1.start(); 
		w2.start(); 
		w3.start();  
		// the 3 workers are running 
		// all sending messages to the same object  
		// we block until the workers complete  
		try{
			w1.join(); 
			w2.join();  
			w3.join();  
		}catch (InterruptedException ignored) {}
		System.out.println("Final sum: " + pair.sum());  
	}
}
