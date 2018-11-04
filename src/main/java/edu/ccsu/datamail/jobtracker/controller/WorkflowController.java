package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import edu.ccsu.datamail.jobtracker.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WorkflowController
{

    @Autowired
    private WorkflowService workflowService;

    @RequestMapping(method = RequestMethod.POST, value = "/workflows/displayworkflow")
    public String getWorkflow(@RequestParam("workflow") int workflow, @RequestParam("job") int job, Model model)
    {

        Workflow t = workflowService.getWorkflow(workflow, job);
        String result = t.getWorkflowId() + " " + t.getJob() + " " + t.getWfDesc();

        model.addAttribute("workflow", result);
        return "displayworkflow";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/workflows/add")
    public String addWorkflow()
    {
        return ("addworkflow");
    }

    /*
    @RequestMapping(method= RequestMethod.POST, value="/workflows/add")

    public void addWorkflow(@RequestParam("wf_id") int wfId, @RequestParam("wf_desc") String wfDesc, @RequestParam("job_id") Job job){

        Workflow t =  new Workflow(wfId, wfDesc, job);

        workflowService.addWorkflow(t);
    }
    */

    @RequestMapping(method = RequestMethod.PUT, value = "/workflows/{wf_id}")

    public void updateWorkflow(@RequestBody Workflow workflow, @PathVariable int wfId)
    {
        workflowService.updateWorkflow(wfId, workflow);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/workflows/{wf_id}")
    public void deleteWorkflow(@PathVariable int wfId)
    {
        workflowService.deleteWorkflow(wfId);
    }
}