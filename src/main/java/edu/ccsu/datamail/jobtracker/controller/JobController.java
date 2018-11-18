package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.JobNotFoundException;
import edu.ccsu.datamail.jobtracker.service.JobService;
import edu.ccsu.datamail.jobtracker.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController
{

    private final JobService jobService;

    private final WorkflowService workflowService;

    @Autowired
    public JobController(JobService jobService, WorkflowService workflowService)
    {
        this.jobService = jobService;
        this.workflowService = workflowService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jobs/findjob")
    public String getToJob()
    {
        return "job/findJob";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createWorkflow")
    public String toGetToWf(@RequestParam("jobId") int jobId, Model model) throws JobNotFoundException
    {
        Job job = null;
        try {
            job = jobService.getJob(jobId);
        } catch (JobNotFoundException e) {
            e.getMessage();
        }
        if (job != null) {
            int nextWorkflowId = workflowService.findNextWorkflowId(jobId);
            model.addAttribute("job", job);
            model.addAttribute("wfId", nextWorkflowId);
            return "workflow/createWorkflowPage";
        }
        else {
            model.addAttribute("job", "No such a job exists");
            return "job/findJob";
        }
    }

}
