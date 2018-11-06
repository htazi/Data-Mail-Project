package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.job.AvailableTask;
import org.springframework.data.repository.CrudRepository;

public interface AvailableTaskRepository  extends CrudRepository<AvailableTask, Integer> {
}
