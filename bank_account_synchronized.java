import java.util.*; 
import java.io.*; 
public class BankAccount{
	private int accountNumber; 
	private double accountBalance; 
	// to withdraw funds from the account 
	public synchronized boolean transfer(double amount){
		double newAccountBalance;  
		if (amount > accountBalance){
			return false;  
		}else{
			newAccountBalance = accountBalance-amount;  
			accountBalance = newAccountBalance;  
			return true; 
		}
	}
	public synchronized boolean deposit(double amount){
		double newAccountBalance;  
		if (amount < 0.0){
			return false;  
		}else{
			newAccountBalance = accountBalance+amount;  
			accountBalance = newAccountBalance;  
			return true;  
		}
	}
}
