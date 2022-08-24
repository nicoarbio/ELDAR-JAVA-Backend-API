package com.challenge.eldar.API.models;

import java.time.LocalDate;

public final class VisaCreditCard extends CreditCard {
	
	private String brand = "VISA";

	public VisaCreditCard(String number, String cardholder, LocalDate expirationDate) {
		super(number, cardholder, expirationDate);
	}

	@Override
	public String getBrand() {
		return this.brand;
	}

	@Override
	public String getCardInformation() {
		return "VisaCreditCard [brand=" + getBrand() + ", " + super.getCardInformation() + "]";
	}

	@Override
	public String isDifferent(CreditCard creditCard) {
		if(this.compareTo(creditCard) != 0)
			return MSG_CARD_DIFF;
		
		return MSG_CARD_EQUAL;
	}
	
	/**
	 * VISA Processing Fee = 2-digit-year / month
	 */
	public static double getProcessingFee(double transaction) {
		return transaction * ((double) adjustProcessingFee(
				((double) LocalDate.now().getYear() % 100
				/ LocalDate.now().getMonthValue())
				) /100 );
	}
}
