package com.humanresources.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.humanresources.hrpayroll.entity.Payment;
import com.humanresources.hrpayroll.entity.Worker;
import com.humanresources.hrpayroll.feignclients.WorkerFeignClient;
import com.humanresources.hrpayroll.response.Response;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Object getPayment(long workerId, int days) {

		try {
			Worker worker = workerFeignClient.FinWorkerById(workerId).getBody();
			if(workerFeignClient.FinWorkerById(workerId).getBody() == worker) {
				return new Payment(worker.getName(), worker.getDailyIncome(), days);
			}else {
				return workerFeignClient.FinWorkerById(workerId).getBody();
			}
		} catch (Exception e) {
			return e.getMessage();
		}

	}
}