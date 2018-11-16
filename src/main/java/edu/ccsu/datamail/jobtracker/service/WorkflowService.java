package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.workflow.Workflow;
import edu.ccsu.datamail.jobtracker.entity.workflow.WorkflowNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.workflow.WorkflowPK;
import edu.ccsu.datamail.jobtracker.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Provides services related to manipulating workflows and accessing workflows in the database
 */
@Service
public class WorkflowService
{
    /**
     * A Crud repository for accessing workflows stored in the database
     */
    private final WorkflowRepository workflowRepository;

    /**
     * Autowired Constructor for initializing CRUD repository references
     *
     * @param workflowRepository CRUD repository for accessing workflows in the database
     */
    @Autowired
    public WorkflowService(WorkflowRepository workflowRepository)
    {
        this.workflowRepository = workflowRepository;
    }

    /**
     * Attempts to find a workflow given a workflow primary key
     *
     * @param wfPk the primary key of the workflow desired
     * @return a Workflow object containing information on the workflow requested
     * @throws WorkflowNotFoundException when no workflow was found in the database
     */
    public Workflow getWorkflow(WorkflowPK wfPk) throws WorkflowNotFoundException
    {
        Optional<Workflow> wfContainer = workflowRepository.findById(wfPk);
        return wfContainer.orElseThrow(() -> new WorkflowNotFoundException("Workflow with PK "
                + wfPk.toString() + " not found."));
    }

    /**
     * Attempts to find a workflow given a jobId and workflowId
     *
     * @param jobId the id of the job the desired workflow belongs to
     * @param wfId  the id of the workflow desired
     * @return a Workflow object containing information on the workflow requested
     * @throws WorkflowNotFoundException when no workflow was found in the database
     */
    public Workflow getWorkflow(int jobId, int wfId) throws WorkflowNotFoundException
    {
        Optional<Workflow> wfContainer = workflowRepository.findWorkflow(jobId, wfId);
        return wfContainer.orElseThrow(() -> new WorkflowNotFoundException("Workflow with wfId "
                + wfId + " and jobId" + jobId + " not found."));
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