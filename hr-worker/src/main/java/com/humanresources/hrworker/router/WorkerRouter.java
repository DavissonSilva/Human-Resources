package com.humanresources.hrworker.router;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.humanresources.hrworker.build.WorkerBuild;
import com.humanresources.hrworker.dto.WorkerDto;
import com.humanresources.hrworker.entity.Worker;
import com.humanresources.hrworker.implservice.WorkerServiceImpl;
import com.humanresources.hrworker.response.Response;

@RestController
public class WorkerRouter {

	@Autowired
	private WorkerServiceImpl serviceImpl;

	@GetMapping(path = "workers/{id}")
	public ResponseEntity<Response<WorkerDto>> FinById(@PathVariable Long id) {

		WorkerBuild workerBuild = new WorkerBuild();
		Response<WorkerDto> response = new Response<WorkerDto>();

		try {
			Optional<Worker> workers = serviceImpl.buscaTrabalhardorPorId(id);
			response.setData(workerBuild.conversorDto(workers.get()));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add("Trabalhador não encotrado para o ID: " + id);
			return ResponseEntity.badRequest().body(response);

		}
	}
}
