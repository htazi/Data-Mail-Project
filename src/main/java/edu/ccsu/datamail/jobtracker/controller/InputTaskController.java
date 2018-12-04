package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.JobNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import edu.ccsu.datamail.jobtracker.entity.task.InputTask;
import edu.ccsu.datamail.jobtracker.entity.task.TaskNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import edu.ccsu.datamail.jobtracker.entity.workflow.Workflow;
import edu.ccsu.datamail.jobtracker.entity.workflow.WorkflowNotFoundException;
import edu.ccsu.datamail.jobtracker.service.AvailableTaskService;
import edu.ccsu.datamail.jobtracker.service.InputTaskService;
import edu.ccsu.datamail.jobtracker.service.UserDetailsServiceImpl;
import edu.ccsu.datamail.jobtracker.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class InputTaskController
{
    private final AvailableTaskService availableTaskService;
    private final InputTaskService inputTaskService;
    private final UserDetailsServiceImpl userDetailsService;
    private final WorkflowService workflowService;


    @Autowired
    public InputTaskController(AvailableTaskService availableTaskService, InputTaskService inputTaskService, UserDetailsServiceImpl userDetailsService, WorkflowService workflowService)
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
    public String addInputTask(@RequestParam("job_id") Integer jobId, @RequestParam("workflow") Integer wfId,
                               @RequestParam("task_id") Integer tskId, @RequestParam("time_taken") Integer time,
                               @RequestParam("records_input") Integer recIn, @RequestParam("records_output") Integer recOut,
                               @RequestParam("records_dropped") Integer recD,
                               @RequestParam(name = "is_pcr", defaultValue = "false") Boolean isPCR,
                               @RequestParam("notes") String desc, Model model, Principal principal) throws WorkflowNotFoundException, TaskNotFoundException
    {
        if(tskId<0)
        {
            tskId =null;
        }
        if (time <0)
        {
            time=null;
        }
        if (recIn < 0)
        {
            recIn=null;
        }
        if ( recOut <0)
        {
            recOut=null;
        }
        if( recD<0)
        {
            recD=null;
        }
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
        Integer taskNum = inputTaskService.getTaskNum(jobId, wfId);
        taskNum++;

        /*The availableTaskService retrieves an available task object with the tskId
         * parameter. TskId is sent from the inputTask html page*/
        AvailableTask availableTask = availableTaskService.getAvailableTask(tskId);

        /*Build the inputTask object for insertion*/
        InputTask inputTask = new InputTask(taskNum, wfId, jobId, workflow, availableTask, user, desc, isPCR, recIn,
                recOut, recD, time, timeStamp);

        /*Add the newly created task to the input_task table*/
        inputTaskService.addInputTask(inputTask);

        /*Populate the html fields in the inputTask page with the current job and wf Ids*/
        model.addAttribute("jobId", jobId);
        model.addAttribute("wfId", wfId);

        /*The inputTask html page in the inputtask package is displayed again after form
         * submission*/
        return ("inputtask/inputTask");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/inputTasks/getalltasks")
    public String getAllInputTasks(@RequestParam("jobId") int jobId, Model model,Authentication authResult) throws JobNotFoundException, WorkflowNotFoundException
    {
        List<InputTask> inputTasks = inputTaskService.getAllInJob(jobId);
        boolean isempty = false;
        model.addAttribute("isempty", isempty);
        model.addAttribute("inputtasks", inputTasks);

        if (inputTasks.isEmpty()) {
            isempty = true;
            model.addAttribute("message", "No Such a Job Id");
            model.addAttribute("isempty", isempty);
        }

        String role = authResult.getAuthorities().toString();



        if (role.contains("ROLE_Billing")) {

            return "/billing/displaybilling";

        }

        else if  (role.contains("ROLE_Production_Programmer")) {

            return "/inputtask/baseDisplayJob";

        }
        else if  (role.contains("ROLE_Manager")) {

            return "/billing/displaybilling";

        }

        return "default";
        //return "/billing/displaybilling";
    }
}