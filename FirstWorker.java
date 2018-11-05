import java.util.*; 
/*
Demonstrates creating a couple worker threads, running them, 
and waiting for them to finish 
Threads respond to a getName() method, which returns a string 
like "Thread-1" which is handy for debugging.  
*/ 
class FirstWorker extends Thread{
	public void run(){
		long sum = 0; 
		for (int i = 0; i < 10000000; i++){
			sum = sum + i;  
			if (i%1000000 == 0){
				Thread running = Thread.currentThread();  
				System.out.println(running.getName() + " " + i); 
			}
		}
	}
	public static void main(String[] args){
		FirstWorker a = new FirstWorker(); 
		FirstWorker b = new FirstWorker(); 
		System.out.println("Starting...");  
		a.start();  
		b.start(); 
		// the current running thread blocks 
		// until both workers have finished 
		try{
			a.join();  
			b.join(); 
		}
		catch (Exception ignored) {

		}
		System.out.println("All done");  
	}
}
