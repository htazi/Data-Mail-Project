package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.JobNotFoundException;
import edu.ccsu.datamail.jobtracker.service.JobService;
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

    @Autowired
    public JobController(JobService jobService)
    {
        this.jobService = jobService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jobs/findjob")
    public String getToJob()
    {
        return "job/findJob";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/jobs/findjob")
    public String toGetToWf(@RequestParam("jobId") int jobId, Model model) throws JobNotFoundException
    {
        Job job = jobService.getJob(jobId);
        if (job != null) {

            int nextWorkflowId = jobService.findWFNumber(jobId);
            model.addAttribute("job", job);
            model.addAttribute("nextWorkflowId", nextWorkflowId);
            return "workflow/createWorkflowPage";
        }
        else {
            model.addAttribute("job", "No such a job exists");
            return "job/findJob";
        }
    }

}
