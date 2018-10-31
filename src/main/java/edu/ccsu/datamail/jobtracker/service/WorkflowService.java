package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.Workflow;
import edu.ccsu.datamail.jobtracker.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkflowService
{

    @Autowired
    private WorkflowRepository workflowRepository;

    public Workflow getWorkflows(int wfId)
    {

        Workflow t = workflowRepository.findById(String.valueOf(wfId)).get();
        return t;

    }

    private List<Workflow> workflows = new ArrayList<>(Arrays.asList(

            new Workflow(1, "aaa", 1),

            new Workflow(2, "bbb", 2),

            new Workflow(3, "ccc", 3)

    ));

    public List<Workflow> getAllWorkflows()
    {
        List<Workflow> workFlows = new ArrayList<>();
        workflowRepository.findAll().forEach(workflows::add);
        return workflows;
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