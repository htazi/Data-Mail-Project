package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import edu.ccsu.datamail.jobtracker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JobController
{

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService)
    {
        this.jobService = jobService;
    }

    @Controller
    public class TestController {
        @RequestMapping(value="/test")
        public String showTestPage(HttpServletRequest request) {
            request.setAttribute("param1", "Ken");
            request.setAttribute("param2", "Yamanaka");
            return "forward:/test2";
        }
    }

    @Controller
    public class TestController2 {
        @RequestMapping(value="/test2")
        public String showTestPage(HttpServletRequest request) {
            String param1 = (String) request.getAttribute("param1");
            param1 = "Bakatare " + param1;
            request.setAttribute("param1", param1);
            String param2 = (String) request.getAttribute("param2");
            param2 = "Awesome " + param2;
            request.setAttribute("param2", param2);
            return "job/findJob";
        }
    }

    @Controller
    public class TestController3 {
        @RequestMapping(value="/test3")
        public String showTestPage(@RequestParam String param1, @RequestParam String param2) {
            return "testPageView";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jobs/findjob")
    public String getTOJob()
    {

        return "job/findJob";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/jobs/findjob")
    public String toGetToWf(@RequestParam("jobId") int jobId, Model model)
    {
        Job job = jobService.getJob(jobId);
        if(job!= null) {

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
