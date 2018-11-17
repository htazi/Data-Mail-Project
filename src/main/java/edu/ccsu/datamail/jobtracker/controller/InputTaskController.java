package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.JobNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import edu.ccsu.datamail.jobtracker.entity.task.InputTask;
import edu.ccsu.datamail.jobtracker.entity.task.TaskNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import edu.ccsu.datamail.jobtracker.entity.workflow.Workflow;
import edu.ccsu.datamail.jobtracker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;

import java.security.Principal;

@Controller
public class InputTaskController
{
    private final AvailableTaskService availableTaskService;
    private final InputTaskService inputTaskService;
    private final UserDetailsServiceImpl userDetailsService;
    private final WorkflowService workflowService;


    @Autowired
    public InputTaskController(AvailableTaskService availableTaskService, InputTaskService taskService, JobService jobService, InputTaskService inputTaskService, UserDetailsServiceImpl userDetailsService, WorkflowService workflowService)
    {
        this.availableTaskService = availableTaskService;
        this.inputTaskService = inputTaskService;
        this.userDetailsService = userDetailsService;
        this.workflowService = workflowService;
    }
    /*
    @RequestMapping(method = RequestMethod.GET, value = "/taskinputs/displaytaskinputs")
    public String showalltaskinputs(Model model)
    {
        //model.addAttribute("taskinputs", taskService.getAllTaskInputs()); TODO: replace with with another method call
        return "displaytaskinputs";
    }
    */

    /**
     * Retrieves the input form from the inputTask html page and inserts the
     * form data into the input_task table.
     *
     * @param jobId
     * @param wfId
     * @param tskId
     * @param time
     * @param recIn
     * @param recOut
     * @param recD
     * @param model
     * @param principal
     * @return
     * @throws JobNotFoundException
     * @throws TaskNotFoundException
     */

    @RequestMapping(method = RequestMethod.POST, value = "/inputTasks/add")
    public String addInputTask(@RequestParam("job_id") int jobId, @RequestParam("workflow") int wfId,
                               @RequestParam("task_id") int tskId, @RequestParam("time_taken") int time,
                               @RequestParam("records_input") int recIn, @RequestParam("records_output") int recOut,
                               @RequestParam("records_dropped")  int recD, Model model, Principal principal) throws JobNotFoundException, TaskNotFoundException {

        /*Retrieves the logged in user with spring security's getPrincipal method.
        * The username is extracted from the authenticated User object with the
        * User's getUserName method. That name is passed to the custom UserDetailService's
        * getUser method. The userDetailService handles retrieving the current user's
        * AppUser Object from the app_user table. The current logged in user is a
        * parameter for the addInputTask method*/
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String name = loginedUser.getUsername();
        AppUser user = userDetailsService.getUser(name);

        /*A work flow object is created to contain the current jobId and wfId. This is
        * used as a parameter in the addInputTask method*/
        Workflow workflow = workflowService.getWorkflow(jobId, wfId);

        /*Timestamp needed for the addInputTask method. Currently displays the UTC time*/
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

        /*TODO figure out how updating and retrieving taskNum will work. Currently its hardcoded*/
        Integer taskNum = 777;

        /*The availableTaskService retrieves an available task object with the tskId
        * parameter. TskId is sent from the inputTask html page*/
        AvailableTask availableTask = availableTaskService.getAvailableTask(tskId);

        /*Build the inputTask object for insertion*/
        InputTask inputTask = new InputTask(taskNum, wfId, jobId, workflow, availableTask, user, "description here",
                 recIn, recOut, recD, time, timeStamp);

        /*Add the newly created task to the input_task table*/
        inputTaskService.addInputTask(inputTask);

        /*Populate the html fields in the inputTask page with the current job and wf Ids*/
        model.addAttribute("jobId", jobId);
        model.addAttribute("wfId", wfId);

        /*The inputTask html page in the inputtask package is displayed again after form
        * submission*/
        return ("inputtask/inputTask");
    }
}
