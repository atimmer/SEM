package airlinesystem.payment;

public abstract class Payment {

	private double amount;
	
	public Payment(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
}
