package test;

import object.Account;

public class TestAccount {
	public static void main(String[] args) {
		
		// set the AnnualInterestRate = 1.5%
		Account.setAnnualInterestRate(1.5);
		// Create a new account
		Account A = new Account( 1122, "George", 1000);
		A.deposit(30).deposit(40).deposit(50).withdraw(5).withdraw(4).withdraw(2).printSummary();
	}
}