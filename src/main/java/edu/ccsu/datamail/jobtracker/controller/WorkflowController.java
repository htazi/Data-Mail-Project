package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.JobNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.workflow.Workflow;
import edu.ccsu.datamail.jobtracker.service.JobService;
import edu.ccsu.datamail.jobtracker.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WorkflowController
{

    private final WorkflowService workflowService;
    private final JobService jobService;

    @Autowired
    public WorkflowController(WorkflowService workflowService, JobService jobService)
    {
        this.workflowService = workflowService;
        this.jobService = jobService;
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
    public String addWorkflow(@RequestParam("jobId") Integer jobId, @RequestParam("wfId") int wfId, @RequestParam("wfdesc") String wfdesc, Model model) throws JobNotFoundException {


        Job job = jobService.getJob(jobId);

        Workflow workflow = new Workflow(wfId, jobId, job, wfdesc);
        workflow.setJob(job);
        model.addAttribute("wfId", wfId);
        model.addAttribute("jobId", jobId);
        workflowService.addWorkflow(workflow);

        return "inputtask/inputTask";

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