package com.humanresources.hrworker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.humanresources.hrworker.entity.Worker;

@Service
public interface WorkerService {

	Optional<List<Worker>> buscaTrabalhardores();
	
	Optional<Worker> buscaTrabalhardorPorId(Long id);
}
