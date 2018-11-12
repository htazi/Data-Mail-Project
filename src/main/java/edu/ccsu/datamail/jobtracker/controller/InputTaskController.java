package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.InputTask;
import edu.ccsu.datamail.jobtracker.service.InputTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InputTaskController
{

    private final InputTaskService taskService;

    @Autowired
    public InputTaskController(InputTaskService taskService)
    {
        this.taskService = taskService;
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

    @RequestMapping(method = RequestMethod.GET, value = "/inputtask/add")
    public String addInputTask()
    {
        return ("inputtask/addTaskInput");
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
        taskService.updateTaskInput(id, taskinput);
    }

    /*
    @RequestMapping(method = RequestMethod.DELETE, value = "/taskinputs/{id}")
    public void deletetaskinput(@PathVariable int id)
    {
        taskService.deleteTaskInput(id);
    }
    */
}
