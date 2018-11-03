package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.dao.WorkflowDAO;
import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import edu.ccsu.datamail.jobtracker.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService
{

    @Autowired
    private WorkflowRepository workflowRepository;

    @Autowired
    private WorkflowDAO workflowDAO;

    /**
     * Finds and returns a workflow associated with a given job
     *
     * @param jobId      the id of the job the workflow belongs to
     * @param workflowId the id of the workflow
     * @return the workflow if found, null otherwise
     */
    public Workflow getWorkflow(int jobId, int workflowId)
    {
        return workflowDAO.findWorkflow(jobId, workflowId);
    }

    public void addWorkflow(Workflow workflow)
    {
        workflowRepository.save(workflow);
    }

    public void updateWorkflow(int wfId, Workflow workflow)
    {
        workflowRepository.save(workflow);
    }

    public void deleteWorkflow(int wfId)
    {
        workflowRepository.deleteById(String.valueOf(wfId));
    }
}