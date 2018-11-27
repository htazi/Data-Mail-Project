package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Provides functionality to retrieve available tasks from the database using various search conditions
 */
@Repository
public interface AvailableTaskRepository extends CrudRepository<AvailableTask, Integer>
{
    /**
     * Attempts to get the highest taskId
     * @param taskId
     * @return
     */
    @Query("Select taskId FROM AvailableTask where taskId = (SELECT MAX(taskId) FROM AvailableTask)")
    int maxTaskId(@Param("task_id") int taskId);

}
