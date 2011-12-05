package airlinesystem.payment;

import java.util.Date;

public class CreditCardPayment extends Payment {

	private int cardNumber;
	private Date expiryDate;
	private int secureCode;
	private String cardHolder;
	
	public CreditCardPayment(int cardNumber, Date expiryDate, int secureCode, String cardHolder, double amount) {
		super(amount);
		
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.secureCode = secureCode;
		this.cardHolder = cardHolder;
	}
	
}
