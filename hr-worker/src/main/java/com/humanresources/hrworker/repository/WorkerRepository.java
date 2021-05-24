package com.humanresources.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humanresources.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
