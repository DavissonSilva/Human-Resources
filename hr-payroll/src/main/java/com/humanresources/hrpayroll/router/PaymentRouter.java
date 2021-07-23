package com.humanresources.hrpayroll.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humanresources.hrpayroll.entity.Payment;
import com.humanresources.hrpayroll.entity.Worker;
import com.humanresources.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/payments")
public class PaymentRouter {

	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<?>getPayment(@PathVariable Long workerId,
			@PathVariable Integer days){
			return ResponseEntity.ok(service.getPayment(workerId, days));
		
	}	
	public ResponseEntity<Object>getPaymentAlternative(Long workerId, Integer days){
			Object object = "Não foi possivel encontar o serviço: hr-worker ";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(object);
		
	}
}
