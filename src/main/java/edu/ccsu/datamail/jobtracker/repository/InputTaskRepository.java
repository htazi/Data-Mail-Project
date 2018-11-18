package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.task.InputTask;
import edu.ccsu.datamail.jobtracker.entity.task.InputTaskPK;
import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import edu.ccsu.datamail.jobtracker.entity.workflow.Workflow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Provides functionality to retrieve user input tasks from the database using various search conditions
 */
@Repository
public interface InputTaskRepository extends CrudRepository<InputTask, InputTaskPK>
{
    /**
     * Finds all tasks that were input by the specified user in the specified Workflow
     *
     * @param user     the user who entered the tasks
     * @param workflow the workflow the tasks are a part of
     * @return a List containing all the tasks requested
     */
    List<InputTask> findAllByUserIdAndWorkflow(AppUser user, Workflow workflow);

    /**
     * Finds all InputTasks associated with the supplied workflow
     *
     * @param workflow the supplied workflow
     * @return a list of the Workflow's InputTasks
     */
    List<InputTask> findAllByWorkflow(Workflow workflow);

    /**
     * Attempts to find an InputTask given the jobId, workflowId, and task number in the workflow
     *
     * @param jobId      the id of the job this task is associated with
     * @param workflowId the id of the workflow this task is associated with
     * @param taskNum    the number of this task in the specified workflow
     * @return A container that may contain an InputTask if one was found
     */
    @Query("FROM InputTask t WHERE t.jobId = :jobId AND t.workflowId = :workflowId AND t.taskNum = :taskId")
    Optional<InputTask> findInputTask(@Param("jobId") int jobId, @Param("workflowId") int workflowId, @Param("taskId") int taskNum);

    /**
     * Attempts to count the number of tasks that contain the same workflow and job id
     * @param jobId
     * @param workflowId
     * @return
     */
    @Query("SELECT  COUNT (t) FROM InputTask t where t.workflow.job.jobId = :jobId AND t.workflow.workflowId = :workflowId ")
    int countTaskNum(@Param("jobId") int jobId, @Param("workflowId") int workflowId);
}