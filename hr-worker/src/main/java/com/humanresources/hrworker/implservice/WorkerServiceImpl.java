package com.humanresources.hrworker.implservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.humanresources.hrworker.entity.Worker;
import com.humanresources.hrworker.repository.WorkerRepository;
import com.humanresources.hrworker.service.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	private WorkerRepository workerRepository;

	@Override
	public Optional<List<Worker>> buscaTrabalhardores() {
		List<Worker> workers = workerRepository.findAll();
		return Optional.ofNullable(workers);
	}

	@Override
	public Optional<Worker> buscaTrabalhardorPorId(Long id) {
		Worker worker = workerRepository.findById(id).get();
		return Optional.ofNullable(worker);
	}
}
