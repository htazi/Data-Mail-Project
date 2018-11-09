package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import edu.ccsu.datamail.jobtracker.entity.job.WorkflowPK;
import edu.ccsu.datamail.jobtracker.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkflowService
{
    /**
     * A Crud repository for accessing workflows in the database
     */
    private final WorkflowRepository workflowRepository;

    @Autowired
    public WorkflowService(WorkflowRepository workflowRepository)
    {
        this.workflowRepository = workflowRepository;
    }

    /**
     * Attempts to find a workflow given a workflow primary key
     *
     * @param wfId the primary key of the workflow desired
     * @return an optional container that may contain the workflow
     */
    public Optional<Workflow> getWorkflow(WorkflowPK wfId)
    {
        return workflowRepository.findById(wfId);
    }

    public void addWorkflow(Workflow workflow)
    {
        workflowRepository.save(workflow);
    }

    public void updateWorkflow(Workflow workflow)
    {
        workflowRepository.save(workflow);
    }

    public void deleteWorkflow(WorkflowPK workflow)
    {
        workflowRepository.deleteById(workflow);
    }
}