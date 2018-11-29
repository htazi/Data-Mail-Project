package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
     * Attempts to get the highest taskId
     * @param taskId
     * @return
     */
    @Query("Select taskId FROM AvailableTask where taskId = (SELECT MAX(taskId) FROM AvailableTask)")
    int maxTaskId(@Param("task_id") int taskId);

//    @Query("Select maxelement(taskId) FROM AvailableTask ")
//    int newestTaskId();

}
