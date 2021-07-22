package com.humanresources.hrworker.router;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humanresources.hrworker.build.WorkerBuild;
import com.humanresources.hrworker.dto.WorkerDto;
import com.humanresources.hrworker.entity.Worker;
import com.humanresources.hrworker.implservice.WorkerServiceImpl;
import com.humanresources.hrworker.response.Response;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class WorkerRouter {

	private static final Logger LOG = LoggerFactory.getLogger(WorkerRouter.class);
	
	@Autowired
	private WorkerServiceImpl serviceImpl;
	
	@Autowired
	private Environment env;

	@GetMapping(path = "workers/{id}")
	public ResponseEntity<Object> FinById(@PathVariable Long id) {

		Response<WorkerDto> response = new Response<WorkerDto>();
		try {

			WorkerBuild workerBuild = new WorkerBuild();
			Optional<Worker> workers = serviceImpl.buscaTrabalhardorPorId(id);
			LOG.info("Servidor subiu na porta:"+ env.getProperty("local.server.port"));
			return ResponseEntity.ok(workerBuild.conversorDto(workers.get()));

		} catch (Exception e) {
			LOG.info("Servidor subiu na porta:"+ env.getProperty("local.server.port"));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	        .body("Trabalhador não encontrado para o ID:  "+ id);
		}
	}
}