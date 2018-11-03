package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.job.InputTask;
import edu.ccsu.datamail.jobtracker.service.InputTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class InputTaskController {

    @Autowired
    private InputTaskService taskService;

    @Autowired
    public InputTaskController(InputTaskService taskService) { this.taskService = taskService;}





    @RequestMapping(method= RequestMethod.GET, value="/taskinputs/displaytaskinputs")
    public String showalltaskinputs(Model model){

        model.addAttribute("taskinputs", taskService.getAllTaskInputs());
        return "displaytaskinputs";
    }

    @RequestMapping(method= RequestMethod.POST, value = "/taskinputs/displaytaskinput")
    public String gettaskinput(@RequestParam("taskinputs") int taskinputs, Model model){
        InputTask t = taskService.getTaskInput(taskinputs);
        String result  = t.getTaskNum() + " " + t.getTask_id() + " " + t.getDescription() + ""+ t.getTimeTaken();

        model.addAttribute("inputtasks", result);
        return "inputtask/displaytaskinput";
    }



    @RequestMapping(method= RequestMethod.GET, value="/inputtask/add")
    public String addInputTask(){

        return ("inputtask/addTaskInput");
    }

    @RequestMapping(method= RequestMethod.POST, value="/taskinputs/add")
    //  @ResponseBody
    // public void addTaskinput(@RequestParam("inputbox") int [] inputboxes, @RequestParam("inputboxstring") String [] inputboxstring )
    public String addTaskinput(Model model,
                               @RequestParam("job_id") int job_id,
                               @RequestParam("wf_id") int wf_id,
                               @RequestParam("task_num") int task_num,
                               @RequestParam("task_id") int task_id,
                               @RequestParam("user_ID") int user_id,
                               @RequestParam("task_description") String task_description,
                               @RequestParam("records_in") int records_in,
                               @RequestParam("records_out") int records_out,
                               @RequestParam("records_dropped")int records_dropped,
                               @RequestParam("time_taken") int time_taken,
                               @RequestParam("time_recorded") Date time_recorded)
    {
       // InputTask t =  new InputTask(job_id, wf_id, task_num, task_id, user_id, task_description, records_in,records_out,records_dropped,time_taken, time_recorded);
        //  TaskInput t =  new TaskInput(inputboxes[0],inputboxes[1],inputboxes[2],inputboxstring[0],inputboxes[3],inputboxes[4],inputboxes[5],inputboxstring[1],inputboxstring[2],inputboxes[6]);
        //taskService.addTaskInput(t);
        //return ("displaytaskinputs");
        model.addAttribute("taskinputs", taskService.getAllTaskInputs());
        return "displaytaskinputs";

    }

    @RequestMapping(method= RequestMethod.PUT, value="/taskinputs/{id}")
    public void updatetaskinput(@RequestBody InputTask taskinput, @PathVariable int id){
        taskService.updateTaskInput(id, taskinput);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/taskinputs/{id}")
    public void deletetaskinput(@PathVariable int id){
        taskService.deleteTaskInput(id);
    }

}
