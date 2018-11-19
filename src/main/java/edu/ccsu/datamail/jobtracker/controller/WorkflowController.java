package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.JobNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.workflow.WorkflowNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.workflow.Workflow;
import edu.ccsu.datamail.jobtracker.service.JobService;
import edu.ccsu.datamail.jobtracker.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(method = RequestMethod.GET, value = "/inputTask")
    public String addWorkflow(@RequestParam("jobId") Integer jobId, @RequestParam("wfId") Integer wfId, @RequestParam("wfdesc") String wfdesc, Model model) throws WorkflowNotFoundException, JobNotFoundException
    {
        Job job = jobService.getJob(jobId);
        Workflow workflow = new Workflow(wfId, jobId, job, wfdesc);
        workflow.setJob(job);
        model.addAttribute("wfId", wfId);
        model.addAttribute("jobId", jobId);
        workflowService.addWorkflow(workflow);
        return "inputtask/inputTask";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/workflows/find")
    public String getWorkflow(@RequestParam("jobId") Integer jobId, @RequestParam("wfId") Integer wfId, Model model)
    {
        try {
            Workflow workflow = workflowService.getWorkflow(jobId, wfId);
            model.addAttribute("wfId", workflow.getWorkflowId());
            model.addAttribute("jobId", workflow.getJobId());
            return "inputtask/inputTask";
        } catch (WorkflowNotFoundException e) {
            return "user/403Page";
        }
    }
}