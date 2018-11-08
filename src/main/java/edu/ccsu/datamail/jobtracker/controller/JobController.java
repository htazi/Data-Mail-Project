package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import edu.ccsu.datamail.jobtracker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;


    @RequestMapping(method = RequestMethod.GET, value = "/jobs/findjob")
    public String getTOJob()
    {

        return "job/findJob";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/jobs/findjob")
    public String toGetToWf(@RequestParam("jobId") int jobId, Model model)
    {

        Job t = jobService.getJob(jobId);
        if(t != null) {
            model.addAttribute("workflow", t);
            return "workflow/createWorkflowPage";
        }
        else
        {
            model.addAttribute("job", "No such a job exists");
            return  "job/findJob";
        }


    }


}
