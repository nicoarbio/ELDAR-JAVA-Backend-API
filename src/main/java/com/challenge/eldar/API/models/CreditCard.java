package com.challenge.eldar.API.models;

import java.time.LocalDate;

public abstract class CreditCard implements Comparable<CreditCard>{

	public static double TRANSACTION_LIMIT = 1000;
	public static double MIN_PROCESSING_FEE_PERCENT = 0.3;
	public static double MAX_PROCESSING_FEE_PERCENT = 5;
	
	private final static String MSG_TRANSACTION_AMOUNT = "Transaction must be less than $" + CreditCard.TRANSACTION_LIMIT;
	private final static String MSG_CARD_INVALID = "Credit Card is expired";
	private final static String MSG_CARD_VALID = "Credit Card is valid for operations";
	protected final static String MSG_CARD_EQUAL = "Credit Card is equal";
	protected final static String MSG_CARD_DIFF = "Credit Card is different";
	
	private String number;
	private String cardholder;
	private LocalDate expirationDate;
	
	/**
	 * @param number
	 * @param cardholder
	 * @param expirationDate
	 */
	public CreditCard(String number, String cardholder, LocalDate expirationDate) {
		if(number.equals(null) || number.trim().equals(""))
			throw new IllegalArgumentException("Credit Card number cannot be null or be empty.");
		if(cardholder.equals(null) || cardholder.trim().equals(""))
			throw new IllegalArgumentException("Credit Card cardholder cannot be null or be empty.");
		if(expirationDate.equals(null))
			throw new IllegalArgumentException("Credit Card expiration date cannot be null.");
		
		this.number = number;
		this.cardholder = cardholder;
		this.expirationDate = expirationDate;
	}
	
	public abstract String getBrand();
	
	protected String getNumber() {
		return number;
	}
	
	protected String getCardholder() {
		return cardholder;
	}
	
	protected LocalDate getExpirationDate() {
		return expirationDate;
	}

	//1)
	public String getCardInformation() {
		return "number=" + number + ", cardholder= " + cardholder + ", expirationDate= " + expirationDate;
	}

	//2)
	private void isValidOperation(double transaction) {
		if (transaction >= CreditCard.TRANSACTION_LIMIT)
			throw new IllegalArgumentException(MSG_TRANSACTION_AMOUNT);
	}
	
	//2)
	private void isValidCard() {
		if (this.expirationDate.isBefore(LocalDate.now()))
			throw new IllegalArgumentException(MSG_CARD_INVALID);
	}
	
	//2)
	public String doTransaction(double transaction) {
		try {
			isValidCard();
			isValidOperation(transaction);
		} catch (Exception e) {
			return "Transaction Invalid: " + e.getMessage() + ".";
		}
		return "Transaction from card number " + number + " for $" + transaction + " successfully done.";
	}
	
	//3)
	public String isOperative() {
		try {
			isValidCard();
			return MSG_CARD_VALID + ".";
		} catch (Exception e) {
			return MSG_CARD_INVALID + ".";
		}
	}

	//4)
	public abstract String isDifferent(CreditCard creditCard);
	
	public int compareTo(CreditCard creditCard) {
		return this.getBrand().compareTo(creditCard.getBrand())
				+ this.getNumber().compareTo(creditCard.getNumber())
				+ this.getCardholder().compareTo(creditCard.getCardholder())
				+ this.getExpirationDate().compareTo(creditCard.getExpirationDate());
	}
	
	//5)
	//public abstract double getProcessingFee(double transaction);
	
	/**
	 * 
	 * @param processingFee
	 * @return Processing fee between 0.3% and 5%
	 */
	protected static double adjustProcessingFee(double processingFee) {
		if(processingFee > MAX_PROCESSING_FEE_PERCENT) {
			return MAX_PROCESSING_FEE_PERCENT;
		} else if(processingFee < MIN_PROCESSING_FEE_PERCENT) {
			return MIN_PROCESSING_FEE_PERCENT;
		} else {			
			return processingFee;
		}
	}


}
