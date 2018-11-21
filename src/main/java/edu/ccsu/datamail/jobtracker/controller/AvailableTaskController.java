package edu.ccsu.datamail.jobtracker.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import edu.ccsu.datamail.jobtracker.entity.task.TaskNotFoundException;
import edu.ccsu.datamail.jobtracker.service.AvailableTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/task")
public class AvailableTaskController
{

    private final AvailableTaskService availableTaskService;


    @Autowired
    public AvailableTaskController(AvailableTaskService availableTaskService)
    {
        this.availableTaskService = availableTaskService;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String Taskslist(Model model)
    {
        model.addAttribute("tasksList", availableTaskService.getAllAvailableTask());
        return "AvailableTask/AvailableTask_list";
    }

  @RequestMapping(value="/addTask", method=RequestMethod.POST)
    public String addTask()
    {

        return ("AvailableTask/AvailableTask");
    }

    @RequestMapping(value="/list", method=RequestMethod.POST)
    public String saveTask(@RequestParam("task_id") Integer taskId, @RequestParam("acronym") String acronym,
                           @RequestParam("t_desc") String taskDesc, @RequestParam("is_billable") Boolean isBillable,
                           @RequestParam("price") Double price, Model model)
    {
        AvailableTask availableTask = new AvailableTask(taskId, acronym, taskDesc, isBillable, price);
        model.addAttribute("task_id", taskId);
        availableTaskService. addAvailableTask(availableTask);
        return "redirect:list";
    }

   /* @RequestMapping(value="/updateTask/{taskId}", method=RequestMethod.GET)
    public ModelAndView editTask(@PathVariable int taskId) throws TaskNotFoundException {
        ModelAndView model = new ModelAndView();

        AvailableTask availableTask = availableTaskService.getAvailableTask(taskId);
        model.addObject("taskForm", availableTask);
        model.setViewName("task_form");

        return model;
    }*/

    /*@RequestMapping(value="/deleteTask/{taskId}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("taskId") int taskId) {
        availableTaskService.deleteAvailableTask(taskId);

        return new ModelAndView("redirect:/task/list");
    }*/

}