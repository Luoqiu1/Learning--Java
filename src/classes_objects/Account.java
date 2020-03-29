package classes_objects;

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
			throw new OverdraftException(a-balance,"余额不足，透支了 "+String.valueOf(a-balance)+" 元");
		}
		else {
			balance-=a;
		}
	}
	public static void main(String[] args) {
		try {
			Account a1=new Account(300);
			a1.deposit(200);
			a1.withdraw(450);
			System.out.println(a1.getBalance());
		}
		catch(OverdraftException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

