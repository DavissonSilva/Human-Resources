package com.humanresources.hrpayroll.build;

import com.humanresources.hrpayroll.dto.PaymentDto;
import com.humanresources.hrpayroll.entity.Payment;

public class PaymentBuild {

	public Payment conversorDto(PaymentDto paymentDto){
		Payment payment = new Payment();
		
		payment.setName(paymentDto.getName());
		payment.setDays(paymentDto.getDays());
		payment.setDailyIncome(paymentDto.getDailyIncome());
		
		
		return payment;
	}
}
