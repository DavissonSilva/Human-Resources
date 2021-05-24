package com.humanresources.hrworker.build;

import java.util.List;

import org.aspectj.weaver.reflect.ReflectionWorld.ReflectionWorldException;

import com.humanresources.hrworker.dto.WorkerDto;
import com.humanresources.hrworker.entity.Worker;

public class WorkerBuild {

	public WorkerDto conversorDto(Worker worker){
		WorkerDto workerDto = new WorkerDto();
		
		workerDto.setId(worker.getId());
		workerDto.setName(worker.getName());
		workerDto.setDailyIncome(worker.getDailyIncome());
		return workerDto;
	}
}
