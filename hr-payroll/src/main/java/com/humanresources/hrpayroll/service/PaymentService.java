package com.humanresources.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.humanresources.hrpayroll.entity.Payment;
import com.humanresources.hrpayroll.entity.Worker;
import com.humanresources.hrpayroll.response.Response;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days) {

		Map<String, String> urlVariables = new HashMap<>();
		urlVariables.put("id", "" + workerId);

		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, urlVariables);
		Response<Worker> response = new Response<Worker>();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
