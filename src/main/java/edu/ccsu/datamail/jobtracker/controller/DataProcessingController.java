package edu.ccsu.datamail.jobtracker.controller;


import edu.ccsu.datamail.jobtracker.entity.task.InputTask;
import edu.ccsu.datamail.jobtracker.entity.task.TaskNotFoundException;
import edu.ccsu.datamail.jobtracker.service.InputTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
public class DataProcessingController
{
    private final InputTaskService inputTaskService;

    @Autowired
    public DataProcessingController(InputTaskService inputTaskService)
    {
        this.inputTaskService = inputTaskService;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/dataProcessing/displayJob")
    public String getJobHistory()
    {

        return "dataProcessing/displayJob";
    }

    @RequestMapping(value = "job/updateJob/{jobId}", method = RequestMethod.POST)
    public String updateJob(@PathVariable("jobId") int jobId, Model model,
                            @RequestParam("workflowId") Integer workflowId,
                            @RequestParam("taskNum") Integer taskNum,
                            @RequestParam("use_name") String userName,
                            @RequestParam("task_desc") String description,
                            @RequestParam("records_in") Integer recordsIn,
                            @RequestParam("records_out") Integer recordsOut,
                            @RequestParam("records_dropped") Integer recordsDropped,
                            @RequestParam("time_taken") Integer timeTaken,
                            @RequestParam("time_recorded") Timestamp timeRecorded) throws TaskNotFoundException
    {


        InputTask inputTask = inputTaskService.getInputTask(jobId, workflowId,taskNum);

        //inputTask.setUserName(userName);
        inputTask.setWorkflowId(workflowId);
        inputTask.setTaskNum(taskNum);
        inputTask.setDescription(description);
        inputTask.setRecordsIn(recordsIn);
        inputTask.setRecordsOut(recordsOut);
        inputTask.setRecordsDropped(recordsDropped);
        inputTask.setTimeTaken(timeTaken);
        inputTask.setTimeRecorded(timeRecorded);

        model.addAttribute("jobId", jobId);
        model.addAttribute("workflowId", workflowId);
        model.addAttribute("taskNum", taskNum);
        model.addAttribute("user_name", userName);
        model.addAttribute("task_desc", description);
        model.addAttribute("records_in", recordsIn);
        model.addAttribute("records_out", recordsOut);
        model.addAttribute("records_dropped", recordsDropped);
        model.addAttribute("time_taken", timeTaken);
        model.addAttribute("time_recorded", timeRecorded);

        model.addAttribute("inputtasks", inputTaskService.getInputTask(jobId, workflowId,taskNum));
        inputTaskService.updateInputTask(inputTask);

        return "dataProcessing/editJob";
    }
}
