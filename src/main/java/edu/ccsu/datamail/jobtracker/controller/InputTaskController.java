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
    private final InputTaskService taskService;
    private final JobService jobService;
    private final InputTaskService inputTaskService;
    private final UserDetailsServiceImpl userDetailsService;
    private final WorkflowService workflowService;


    @Autowired
    public InputTaskController(AvailableTaskService availableTaskService, InputTaskService taskService, JobService jobService, InputTaskService inputTaskService, UserDetailsServiceImpl userDetailsService, WorkflowService workflowService)
    {
        this.availableTaskService = availableTaskService;
        this.taskService = taskService;
        this.jobService = jobService;
        this.inputTaskService = inputTaskService;
        this.userDetailsService = userDetailsService;
        this.workflowService = workflowService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/taskinputs/displaytaskinputs")
    public String showalltaskinputs(Model model)
    {
        //model.addAttribute("taskinputs", taskService.getAllTaskInputs()); TODO: replace with with another method call
        return "displaytaskinputs";
    }

    /* TODO: Make this method retrieve inputTasks correctly instead of with a partial primary key
    @RequestMapping(method = RequestMethod.POST, value = "/taskinputs/displaytaskinput")
    public String gettaskinput(@RequestParam("taskinputs") int taskinputs, Model model)
    {
        InputTask t = taskService.get(taskinputs);
        String result = t.getTaskNum() + " " + t.getTask_id() + " " + t.getDescription() + "" + t.getTimeTaken();

        model.addAttribute("inputtasks", result);
        return "inputtask/displaytaskinput";
    }
    */

    @RequestMapping(method = RequestMethod.POST, value = "/inputTasks/add")
    public String addInputTask(@RequestParam("job_id") int jobId, @RequestParam("workflow") int wfId,
                               @RequestParam("task_id") int tskId, @RequestParam("time_taken") int time,
                               @RequestParam("records_input") int recIn, @RequestParam("records_output") int recOut,
                               @RequestParam("records_dropped")  int recD, Model model, Principal principal) throws JobNotFoundException, TaskNotFoundException {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String name = loginedUser.getUsername();
        AppUser user = userDetailsService.getUser(name);


        Workflow workflow = workflowService.getWorkflow(jobId, wfId);
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        Integer taskNum = 777;

        AvailableTask availableTask = availableTaskService.getAvailableTask(tskId);
        InputTask inputTask = new InputTask(taskNum, wfId, jobId, workflow, availableTask, user, "description here",
                 recIn, recOut, recD, time, timeStamp);

        inputTaskService.addInputTask(inputTask);

        model.addAttribute("jobId", jobId);
        model.addAttribute("wfId", wfId);
        return ("inputtask/inputTask");
    }
//
//    @RequestMapping(method= RequestMethod.POST, value="/taskinputs/add")
//    //  @ResponseBody
//    // public void addTaskinput(@RequestParam("inputbox") int [] inputboxes, @RequestParam("inputboxstring") String [] inputboxstring )
//    public String addTaskinput(Model model,
//                               @RequestParam("job_id") int job_id,
//                               @RequestParam("wf_id") int wf_id,
//                               @RequestParam("task_num") int task_num,
//                               @RequestParam("task_id") int task_id,
//                               @RequestParam("user_ID") int user_id,
//                               @RequestParam("task_description") String task_description,
//                               @RequestParam("records_in") int records_in,
//                               @RequestParam("records_out") int records_out,
//                               @RequestParam("records_dropped")int records_dropped,
//                               @RequestParam("time_taken") int time_taken,
//                               @RequestParam("time_recorded") LocalDate time_recorded)
//    {
//        InputTask t =  new InputTask(job_id, wf_id, task_num, task_id, user_id, task_description, records_in,records_out,records_dropped, time_taken, time_recorded);
//        taskService.addTaskInput(t);
//
//        model.addAttribute("inputtasks", taskService.getAllTaskInputs());
//        return "inputtask/displayinputtask";
//
//    }

    @RequestMapping(method = RequestMethod.PUT, value = "/taskinputs/{id}")
    public void updatetaskinput(@RequestBody InputTask taskinput, @PathVariable int id)
    {
        //taskService.updateTaskInput(id, taskinput);
    }

    /*
    @RequestMapping(method = RequestMethod.DELETE, value = "/taskinputs/{id}")
    public void deletetaskinput(@PathVariable int id)
    {
        taskService.deleteTaskInput(id);
    }
    */
}
