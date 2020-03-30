package classes_objects;

import java.util.Arrays;

public class Account {
	private double balance;
	public Account() {
	}
	public Account(double a) {
		balance=a;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double a) {
		balance+=a;
	}
	public void withdraw(double a) throws OverdraftException {
		if(balance<a) {
			throw new OverdraftException(a-balance,"Óà¶î²»×ã£¬Í¸Ö§ÁË ");
		}
		else {
			balance-=a;
		}
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new int[] {1,2}));
		try {
			Account a1=new Account(300);
			a1.deposit(200);
			a1.withdraw(650);
			System.out.println(a1.getBalance());
		}
		catch(OverdraftException e) {
			System.out.println(e.getMessage()+e.getDeficit());
			e.printStackTrace();
		}
	}
}

