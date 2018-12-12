package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides functionality to retrieve available tasks from the database using various search conditions
 */
@Repository
public interface AvailableTaskRepository extends CrudRepository<AvailableTask, Integer>
{
    /**
     * Returns a List of all AvailableTasks in the database
     *
     * @return all AvailableTasks in the database
     */
    List<AvailableTask> getAllBy();

    /**
     * Returns the largest value for the primary key among AvailableTasks
     *
     * @return the largest primary key among AvailableTasks
     */
    @Query("Select taskId FROM AvailableTask where taskId = (SELECT MAX(taskId) FROM AvailableTask)")
    int maxTaskId();
}
