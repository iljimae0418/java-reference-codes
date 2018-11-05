// java program to demonstrate the working of synchronized 
import java.io.*;  
import java.util.*;  
// a class used to send a message 
class Sender{
	public void send(String msg){
		System.out.println("Sending\t" + msg);  
		try{
			Thread.sleep(1000); 
		}catch (Exception e){
			System.out.println("Thread interrupted.");  
		}
		System.out.println("\n" + msg + "sent");  
	}
}
// class for sending a messsage using threads 
class ThreadedSend extends Thread{
	private String msg; 
	private Thread t;  
	Sender sender; 
	// Receives a message object and a string 
	// message to be sent 
	ThreadedSend(String m,Sender obj){
		msg = m;  
		sender = obj;  
	}
	public void run(){
		// only one thread can send a message at a time 
		synchronized(sender){
			sender.send(msg);  
		}
	}
}

public class SyncDemo{
	public static void main(String[] args){
		Sender snd = new Sender(); 
		ThreadedSend S1 = new ThreadedSend(" Hi ",snd); 
		ThreadedSend S2 = new ThreadedSend(" Bye ",snd);  
		// start two threads of ThreadedSend type 
		S1.start(); 
		S2.start();  
		// wait for threads to end 
		try{
			S1.join(); 
			S2.join();  
		}catch (Exception e){
			System.out.println("Interrupted");  
		}
	}
}
