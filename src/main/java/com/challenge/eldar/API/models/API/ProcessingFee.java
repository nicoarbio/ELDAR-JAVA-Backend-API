package com.challenge.eldar.API.models.API;

import com.challenge.eldar.API.models.AmexCreditCard;
import com.challenge.eldar.API.models.NaraCreditCard;
import com.challenge.eldar.API.models.VisaCreditCard;

public class ProcessingFee {
	
	private String brand;
	private double transaction;
	public double processingFee;
	
	public String getBrand() {
		return brand;
	}
	
	public double getTransaction() {
		return transaction;
	}

	public double getProcessingFee() {
		if(brand.equalsIgnoreCase("VISA")) {
			return VisaCreditCard.getProcessingFee(transaction);
		} else if(brand.equalsIgnoreCase("NARA")) {
			return NaraCreditCard.getProcessingFee(transaction);
		} else if(brand.equalsIgnoreCase("AMEX")) {
			return AmexCreditCard.getProcessingFee(transaction);			
		} else {
			return 0;
		}			
	}
}
