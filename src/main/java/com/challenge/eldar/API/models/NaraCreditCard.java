package com.challenge.eldar.API.models;

import java.time.LocalDate;

public final class NaraCreditCard extends CreditCard {
	
	private String brand = "NARA";

	public NaraCreditCard(String number, String cardholder, LocalDate expirationDate) {
		super(number, cardholder, expirationDate);
	}

	@Override
	public String getBrand() {
		return this.brand;
	}

	@Override
	public String getCardInformation() {
		return "NaraCreditCard [brand=" + getBrand() + ", " + super.getCardInformation() + "]";
	}

	@Override
	public String isDifferent(CreditCard creditCard) {
		if(this.compareTo(creditCard) != 0)
			return MSG_CARD_DIFF;
		
		return MSG_CARD_EQUAL;
	}
	
	/**
	 * NARA Processing Fee = day-of-month * 0.5
	 */
	public static double getProcessingFee(double transaction) {
		return transaction * ((double) adjustProcessingFee(
				((double) LocalDate.now().getDayOfMonth() * 0.5)
				) /100 );
	}
}
