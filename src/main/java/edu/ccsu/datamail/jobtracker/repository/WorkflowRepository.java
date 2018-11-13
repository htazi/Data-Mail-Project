package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import edu.ccsu.datamail.jobtracker.entity.job.WorkflowPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Provides functionality to retrieve workflows from the database using various search conditions
 */
@Repository
public interface WorkflowRepository extends CrudRepository<Workflow, WorkflowPK>
{
    /**
     * Attempts to find a workflow from the database given a jobId and workflowId
     *
     * @param jobId      the integer id of the job
     * @param workflowId the integer id of the workflow
     * @return An Optional container holding a workflow object if one was found, an empty container otherwise
     */
    @Query("FROM Workflow w Where w.job.jobId = :jobId AND w.workflowId = :workflowId")
    Optional<Workflow> findWorkflow(@Param("jobId") Integer jobId, @Param("workflowId") Integer workflowId);

    /**
     * Finds all workflows associated with a given Job
     *
     * @param job the job the desired workflows are associated with
     * @return a List of workflows associated with the job
     */
    List<Workflow> findWorkflowsByJob(Job job);
}
