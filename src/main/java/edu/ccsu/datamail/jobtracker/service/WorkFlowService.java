package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.WorkFlow;
import edu.ccsu.datamail.jobtracker.repository.WorkFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class WorkFlowService {


    @Autowired
    private WorkFlowRepository workflowRepository;

    private   List<WorkFlow> workflows =  new ArrayList<>(Arrays.asList(

            new WorkFlow(1,"aaa",1 ),

            new WorkFlow(2,"bbb",2 ),

            new WorkFlow(3,"ccc",3 )

    ));

    public List<WorkFlow> getAllWorkflows(){

        List<WorkFlow> workFlows = new ArrayList<>();
        workflowRepository.findAll().forEach(workflows::add);
        return workflows;
    }

    public WorkFlow getWorkflows(int wfId){

        WorkFlow t = workflowRepository.findById(String.valueOf(wfId)).get();
        return t;

    }

    public void addWorkflow(WorkFlow workflow){

        workflowRepository.save(workflow);
    }

    public void updateWorkflow(int wfId, WorkFlow workflow){

        workflowRepository.save(workflow);
    }

    public void deleteWorkflow(int wfId){

        workflowRepository.deleteById(String.valueOf(wfId));
    }
}