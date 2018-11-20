class shape{ 
	private static int k = 0;  
	public shape(){
		k++;  
	}
	public void printSerial(){
		System.out.println(k);  
	}
}
public class defaultName{
	public static void main(String[] args){
		shape s1 = new shape();  
		s1.printSerial();  
		shape s2 = new shape();  
		s2.printSerial();  
		shape s3 = new shape(); 
		s3.printSerial(); 
	}
}
