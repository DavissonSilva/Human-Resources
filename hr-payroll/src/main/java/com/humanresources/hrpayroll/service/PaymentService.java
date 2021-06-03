package com.humanresources.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanresources.hrpayroll.entity.Payment;
import com.humanresources.hrpayroll.entity.Worker;
import com.humanresources.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {

		Worker worker = workerFeignClient.FinWorkerById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
