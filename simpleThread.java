/*
Create two thread (including main thread) to print alphabets then print digits 
*/ 
import java.util.*; 
class DigitThread extends Thread{
	@Override 
	public void run(){
		for (int i = 0; i < 10; i++){
			System.out.println(i); 
		}
	}
}
public class simpleThread{
	public static void main(String[] args){
		DigitThread d = new DigitThread();  
		d.start(); 
		for (char ch = 'a'; ch <= 'z'; ch++){
			System.out.print(ch); 
		}
	}
}
