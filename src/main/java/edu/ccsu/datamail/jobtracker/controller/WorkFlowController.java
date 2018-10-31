package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.Job;
import edu.ccsu.datamail.jobtracker.entity.WorkFlow;
import edu.ccsu.datamail.jobtracker.service.WorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WorkFlowController {

    @Autowired
    private WorkFlowService workflowService;

    @Autowired
    public WorkFlowController(WorkFlowService workflowService) { this.workflowService = workflowService;}


    @RequestMapping("/workflows/displayworkflows")

    public String showallworkflows(Model model){
        model.addAttribute("workflows", workflowService.getAllWorkflows());
        return "displayworkflows";
    }

    @RequestMapping(method= RequestMethod.POST, value = "/workflows/displayworkflow")
    public String getWorkflow(@RequestParam("workflow") int workflow, Model model){

        WorkFlow t = workflowService.getWorkflows(workflow);
        String result  = t.getWfId() + " " + t.getJob() + " " + t.getWfDesc();

        model.addAttribute("workflow", result);
        return "displayworkflow";

    }

    @RequestMapping(method= RequestMethod.GET, value="/workflows/add")
    public String addWorkflow(){
        return ("addworkflow");

    }

    @RequestMapping(method= RequestMethod.POST, value="/workflows/add")

    public void addWorkflow(@RequestParam("wf_id") int wfId, @RequestParam("wf_desc") String wfDesc, @RequestParam("job_id") Job job){

        WorkFlow t =  new WorkFlow(wfId, wfDesc, job);

        workflowService.addWorkflow(t);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/workflows/{wf_id}")

    public void updateWorkflow(@RequestBody WorkFlow workflow, @PathVariable int wfId){

        workflowService.updateWorkflow(wfId, workflow);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/workflows/{wf_id}")
    public void deleteWorkflow(@PathVariable int wfId){

        workflowService.deleteWorkflow(wfId);
    }
}