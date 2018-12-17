package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.task.InputTask;
import edu.ccsu.datamail.jobtracker.entity.task.TaskNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import edu.ccsu.datamail.jobtracker.service.InputTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class DataProcessingController
{
    private final InputTaskService inputTaskService;

    @Autowired
    public DataProcessingController(InputTaskService inputTaskService)
    {
        this.inputTaskService = inputTaskService;
    }

    /**
     * Display the data retrieved from input task to displayJob page
     * the data retrieved  is handled by InputTask Controller
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dataProcessing/displayJob")
    public String getJobHistory()
    {
        return "dataProcessing/displayJob";
    }

    /**
     * Retrieves the input form from the editJob html page to be updated
     *
     * @param jobId
     * @param workflowId
     * @param taskNum
     * @param model
     * @return
     * @throws TaskNotFoundException
     */
    @RequestMapping(value = "job/updateJob/{job_id}/{workflow}/{taskNum}", method = RequestMethod.POST)
    public String updateJobPage(@PathVariable("job_id") Integer jobId,
                                @PathVariable("workflow") Integer workflowId,
                                @PathVariable("taskNum") Integer taskNum, Model model) throws TaskNotFoundException
    {
        InputTask task = inputTaskService.getInputTask(jobId, workflowId, taskNum);
        model.addAttribute("job_id", task.getJobId());
        model.addAttribute("workflow", task.getWorkflowId());
        model.addAttribute("taskNum", task.getTaskNum());
        model.addAttribute("user_name", task.getUserId().getUserName());
        model.addAttribute("task_desc", task.getDescription());
        model.addAttribute("records_input", task.getRecordsIn());
        model.addAttribute("records_output", task.getRecordsOut());
        model.addAttribute("records_dropped", task.getRecordsDropped());
        model.addAttribute("time_taken", task.getTimeTaken());
        model.addAttribute("time_recorded", task.getTimeRecorded());
        return "dataProcessing/editJob";
    }

    /**
     * Updates the input form from the editJob html page and inserts the
     * form data into the input_task table.
     *
     * @param jobId
     * @param workflowId
     * @param taskNum
     * @param userName
     * @param description
     * @param recordsIn
     * @param recordsOut
     * @param recordsDropped
     * @param timeTaken
     * @param model
     * @return
     * @throws TaskNotFoundException
     */
    @RequestMapping(value = "job/updatedJob/{job_id}/{workflow}/{taskNum}", method = RequestMethod.POST)
    public String updateTask(@PathVariable("job_id") Integer jobId, Model model,
                             @PathVariable("workflow") Integer workflowId,
                             @PathVariable("taskNum") Integer taskNum,
                             @RequestParam("user_name") String userName,
                             @RequestParam("task_desc") String description,
                             @RequestParam("records_input") Integer recordsIn,
                             @RequestParam("records_output") Integer recordsOut,
                             @RequestParam("records_dropped") Integer recordsDropped,
                             @RequestParam("time_taken") Integer timeTaken) throws TaskNotFoundException
    {
        InputTask inputTask = inputTaskService.getInputTask(jobId, workflowId, taskNum);
        /* call AppUser object to set userName input*/
        AppUser appUser = inputTask.getUserId();
        String usrName = inputTask.getUserId().getUserName();

        /* set all input fields to the new entered data*/
        appUser.setUserName(usrName);
        inputTask.setDescription(description);
        inputTask.setRecordsIn(recordsIn);
        inputTask.setRecordsOut(recordsOut);
        inputTask.setRecordsDropped(recordsDropped);
        inputTask.setTimeTaken(timeTaken);
        inputTask.setTimeRecorded(new Timestamp(System.currentTimeMillis()));

        /* insert the new updated task*/
        inputTaskService.updateInputTask(inputTask);

        /* Retrieves the data from input task table after  updating a job */
        List<InputTask> inputTasks = inputTaskService.getAllInJob(jobId);
        model.addAttribute("inputtasks", inputTasks);

        return "dataProcessing/displayJob";
    }
}
