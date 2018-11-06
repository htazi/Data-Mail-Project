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

//    @RequestMapping(method = RequestMethod.POST, value = "/workflow/displayworkflow")
//    public String postWorkflow(@RequestParam("workflow") int workflow, @RequestParam("job") int job, Model model)
//    {
//        System.out.println("tesing controller");
//
//        Workflow t = workflowService.getWorkflows(workflow, job);
//        String result = t.toString();
//        model.addAttribute("workflow", result);
//        return "displayworkflow";
//    }


    @RequestMapping(method = RequestMethod.GET, value = "/workflows")
    public String getWorkflow()
    {

        return "workflow/workflows";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/workflows/displayworkflow")
    public String getWorkflow(@RequestParam("workflow") int workflow, @RequestParam("job") int job, Model model)
    {
        System.out.println("tesing controller");
        Workflow t = workflowService.getWorkflows(workflow, job);
        if(t != null) {
            //String result = t.toString();
            model.addAttribute("workflow", t);
            return "inputtask/addTaskInput";
        }
        else
        {
            model.addAttribute("workflow", "No such a workflow exists");
            return "workflow/displayworkflow";
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/workflows/add")
    public String addWorkflow()
    {
        return ("addworkflow");
    }



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