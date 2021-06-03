package com.humanresources.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.humanresources.hrpayroll.entity.Worker;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8080", path = "/workers")
public interface WorkerFeignClient {
	
	@GetMapping(path = "/{id}")
	ResponseEntity<Worker> FinWorkerById(@PathVariable Long id);
	
}
