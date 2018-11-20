package edu.ccsu.datamail.jobtracker.controller;


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
public class AvailableTaskController {

    private final AvailableTaskService availableTaskService;


    @Autowired
    public AvailableTaskController(AvailableTaskService availableTaskService)
    {
        this.availableTaskService = availableTaskService;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String Taskslist(Model model){
        //ModelAndView model = new ModelAndView("AvailableTask/AvailableTask_list");
       // List<AvailableTask> taskList = availableTaskService.getAllAvailableTask();
        model.addAttribute("tasksList", availableTaskService.getAllAvailableTask());

        return "AvailableTask/AvailableTask_list";
    }

  /* @RequestMapping(value="/addTask/", method=RequestMethod.GET)
    public String addTask(@RequestParam("task_id") int taskId, @RequestParam("acronym") String acronym,
                          @RequestParam("_t_desc") String taskDesc, @RequestParam("is_billable") boolean isBillable,
                          @RequestParam("price") Double price,Model model) {
        //ModelAndView model = new ModelAndView();

        AvailableTask availableTask = new AvailableTask(taskId,acronym,taskDesc,isBillable,price);
        model.addAttribute("taskId", taskId);
        AvailableTaskService.addAvailableTask(taskId);

        return ("")
    }*/

    @RequestMapping(value="/updateTask/{taskId}", method=RequestMethod.GET)
    public ModelAndView editTask(@PathVariable int taskId) throws TaskNotFoundException {
        ModelAndView model = new ModelAndView();

        AvailableTask availableTask = availableTaskService.getAvailableTask(taskId);
        model.addObject("taskForm", availableTask);
        model.setViewName("task_form");

        return model;
    }

    @RequestMapping(value="/saveTask", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("taskForm") AvailableTask availableTask) {
        availableTaskService.addAvailableTask(availableTask);

        return new ModelAndView("redirect:/task/list");
    }

    @RequestMapping(value="/deleteTask/{taskId}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("taskId") int taskId) {
        availableTaskService.deleteAvailableTask(taskId);

        return new ModelAndView("redirect:/task/list");
    }

}