package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.dao.WorkflowDAO;
import edu.ccsu.datamail.jobtracker.entity.job.User;
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
     * @param workflowId the id of the workflow
     * @param jobId      the id of the job the workflow belongs to
     * @return the workflow if found, null otherwise
     */
    public Workflow getWorkflows(int workflowId, int jobId)
    {
        return workflowDAO.findWorkflow(workflowId, jobId);
    }

    public User getUserID(int userId)
    {
        return workflowDAO.findUserID(userId);
    }

    /*
        private List<Workflow> workflow = new ArrayList<>(Arrays.asList(new Workflow(1, "aaa", 1), new Workflow(2, "bbb", 2), new Workflow(3, "ccc", 3)));

        public List<Workflow> getAllWorkflows()
        {
            List<Workflow> workFlows = new ArrayList<>();
            workflowRepository.findAll().forEach(workflow::add);
            return workflow;
        }
    */
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
        workflowRepository.deleteById(wfId);
    }
}