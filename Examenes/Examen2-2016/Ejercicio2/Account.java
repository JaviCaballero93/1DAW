package object;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Account { 
	
	private int id;
	private String name;
	private double balance;
	private static double annualInterestRate;
	private Date dateCreated;
	private ArrayList<Transaction> transactions;

	public Account() {
		// TODO Auto-generated constructor stub
		this(1, "Javi", 2500.0);
	}
	
	public Account(int id, String name, double balance) {
		
		this.id = id;
		this.name = name;
		this.balance = balance;
		dateCreated = new Date();
		transactions = new ArrayList<Transaction>();
	}
	
	public int getId() {
		
		return id;
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	public double getAnnualInterestRate() {
		
		return annualInterestRate / 100;
	}

	public void setId(int id) {
		
		this.id = id;
	}
	
	public void setBalance(double balance) {
		
		this.balance = balance;
	}
	
	public static void setAnnualInterestRate(double rate) {
		
		annualInterestRate = rate;
	}
	
	public Date getDateCreated() {
		
		return (Date) dateCreated.clone();
	}
	
	public double getMonthlyInterestRate() {
		
		return getAnnualInterestRate() / 12;
	}
	
	public double getMonthlyInterest() {
		
		return balance * getMonthlyInterestRate();
	}
	
	public Account withdraw(double amount, String description) {
		
		if(this.balance < amount)
			return this;
		
		this.balance -= amount;
		this.transactions.add(new Transaction('W', amount, this.balance, description));
		
		return this;
	}
	
	public Account withdraw(double amount) {
		
		return withdraw(amount, "");
	}
	
	public Account deposit(double amount, String description) {
		
		this.balance += amount;
		this.transactions.add(new Transaction('D', amount, this.balance, description));
		
		return this;
	}
	
	public Account deposit(double amount) {
		
		return deposit(amount, "");
	}
	
	public Account printSummary() {
		
		String text = "";
		
		text += "Account ID: " + this.id;
		text += "\nName: " + this.name;
		text += "\nInterestRate:";
		text += "\n+ Annual: " + getAnnualInterestRate();
		text += "\n+ Monthly: " + getMonthlyInterestRate();
		text += "\nTransactions:\n";
		// to do something here to get a better format
		text += transactions;
		
		JOptionPane.showMessageDialog(null, text);
		
		return this;
	}
}