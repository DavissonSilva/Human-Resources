package com.humanresources.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.humanresources.hrpayroll.entity.Worker;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {
	
	@GetMapping(path = "/{id}")
	ResponseEntity<Worker> FinWorkerById(@PathVariable Long id);
}
