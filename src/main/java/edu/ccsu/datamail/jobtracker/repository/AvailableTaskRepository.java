package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.job.AvailableTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides functionality to retrieve available tasks from the database using various search conditions
 */
@Repository
public interface AvailableTaskRepository extends CrudRepository<AvailableTask, Integer>
{

}
