package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.Client;
import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.workflow.Workflow;
import edu.ccsu.datamail.jobtracker.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WorkflowController
{

    private final WorkflowService workflowService;

    @Autowired
    public WorkflowController(WorkflowService workflowService)
    {
        this.workflowService = workflowService;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/workflow/displayworkflow")
//    public String postWorkflow(@RequestParam("workflow") int workflow, @RequestParam("job") int job, Model model)
//    {
//        System.out.println("tesing controller");
//
//        Workflow t = workflowService.getWorkflows(workflow, job);
//        String result = t.toString();
//        model.addAttribute("workflow", result);
//        return "workflow/displayworkflow";
//    }


//    @RequestMapping(method = RequestMethod.GET, value = "/workflows")
//    public String getWorkflow()
//    {
//
//        return "workflow/workflows";
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/workflows/displayworkflow")
//    public String getWorkflow(@RequestParam("workflow") int workflow, @RequestParam("job") int job, Model model)
//    {
//        System.out.println("tesing controller");
//        Workflow t = workflowService.getWorkflows(workflow, job);
//        if(t != null) {
//            //String result = t.toString();
//            model.addAttribute("workflow", t);
//            return "inputtask/addTaskInput";
//        }
//        else
//        {
//            model.addAttribute("workflow", "No such a workflow exists");
//            return "workflow/displayworkflow";
//        }
//    }



    @RequestMapping(method = RequestMethod.GET, value = "/workflows/add")
    public String addWorkflow(@RequestParam("jobId") Integer jobId, @RequestParam("wfId") int wfId, @RequestParam("wfdesc") String wfdesc, Model model)
    {
        /*
        Client client = new Client("test5", "Newtown");
        Job job = new Job("", client);
        job.setClient(client);
        Workflow workflow = new Workflow(jobId, jobId, job, wfdesc);
        workflow.setJob(job);
        model.addAttribute("wfId", wfId);
        model.addAttribute("jobId", jobId);
        workflowService.addWorkflow(workflow);
        */
        return "forward:/inputTasks/add";
    }


//    @RequestMapping(method = RequestMethod.GET, value = "/workflows/add")
//    public String addWorkflow(@RequestParam("jobId") int jobId, @RequestParam("wfId") int wfId, @RequestParam("wfdesc") String wfdesc, Model model)
//    {
//        return ("workflow/createWorkflowPage");
//    }


    @RequestMapping(method = RequestMethod.PUT, value = "/workflows/{wf_id}")
    public void updateWorkflow(@RequestBody Workflow workflow, @PathVariable int wfId)
    {
        //workflowService.updateWorkflow(wfId, workflow);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/workflows/{wf_id}")
    public void deleteWorkflow(@PathVariable int wfId)
    {
        //workflowService.deleteWorkflow(wfId);  // workflows cannot be deleted using a single integer
    }
}