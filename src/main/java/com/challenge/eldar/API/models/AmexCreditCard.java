package com.challenge.eldar.API.models;

import java.time.LocalDate;

public final class AmexCreditCard extends CreditCard {
	
	private String brand = "AMEX";

	public AmexCreditCard(String number, String cardholder, LocalDate expirationDate) {
		super(number, cardholder, expirationDate);
	}

	@Override
	public String getBrand() {
		return this.brand;
	}

	@Override
	public String getCardInformation() {
		return "AmexCreditCard [brand=" + getBrand() + ", " + super.getCardInformation() + "]";
	}

	@Override
	public String isDifferent(CreditCard creditCard) {
		if(this.compareTo(creditCard) != 0)
			return MSG_CARD_DIFF;
		
		return MSG_CARD_EQUAL;
	}
	
	/**
	 * AMEX Processing Fee = month * 0.1  return getExpirationDate().getMonthValue() * 0.1;
	 */
	public static double getProcessingFee(double transaction) {
		return transaction * ((double) adjustProcessingFee(
				((double) LocalDate.now().getMonthValue() * 0.1)
				) /100 );
	}
}
