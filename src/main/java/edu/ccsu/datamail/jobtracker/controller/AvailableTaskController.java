package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import edu.ccsu.datamail.jobtracker.entity.task.TaskNotFoundException;
import edu.ccsu.datamail.jobtracker.service.AvailableTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Uses input form data from AvailableTask_list html and retrieves
     * all available tasks from task_list table
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String serveAvailableTaskList(Model model)
    {
        model.addAttribute("tasksList", availableTaskService.getAllAvailableTask());
        return "AvailableTask/AvailableTask_list";
    }

    /**
     * Uses RequestMethod from AvailableTask_list html to call AvailableTask html
     * which has the input form to insert a new task into task_list table
     */
    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String serveAddTaskPage(Model model)
    {
        int newestTaskId = availableTaskService.getTaskId();
        model.addAttribute("taskId", ++newestTaskId);
        model.addAttribute("tasksList", availableTaskService.getAllAvailableTask());
        return "AvailableTask/AvailableTaskAddNew";
    }

    /**
     * Retrieves the input form from the availableTask html page and inserts the
     * form data into the task_list table.
     *
     * @param taskId
     * @param acronym
     * @param taskDesc
     * @param price
     * @param isBillable
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String saveTask(@RequestParam("taskId") Integer taskId, @RequestParam("acronym") String acronym,
                           @RequestParam("t_desc") String taskDesc, @RequestParam(value = "is_billable", defaultValue = "false") Boolean isBillable,
                           @RequestParam("price") Double price, Model model)
    {
        /*TODO figure out how  the auto-increment when inserting new task will work. Currently its hardcoded*/

        /*Build the availableTask object for insertion*/
        AvailableTask availableTask = new AvailableTask(taskId, acronym, taskDesc, isBillable, price);
        model.addAttribute("task_id", taskId);
        availableTaskService.addAvailableTask(availableTask);
        model.addAttribute("tasksList", availableTaskService.getAllAvailableTask());

        return "AvailableTask/AvailableTask_list";
    }

    @RequestMapping(value = "/updateTask/{taskId}", method = RequestMethod.POST)
    public String serveUpdatePage(@PathVariable("taskId") int taskId, Model model, @RequestParam("acronym") String acronym,
                                  @RequestParam("t_desc") String t_desc, @RequestParam("isbillable") boolean isbillable,
                                  @RequestParam("price") double price)
    {
        model.addAttribute("isbillable", isbillable);
        model.addAttribute("taskId", taskId);
        model.addAttribute("acronym", acronym);
        model.addAttribute("t_desc", t_desc);
        model.addAttribute("price", price);
        return "AvailableTask/AvailableTaskUpdate";
    }

    @RequestMapping(value = "/updateTaskPost/{taskId}", method = RequestMethod.POST)
    public String updateTask(@PathVariable("taskId") int taskId, Model model, @RequestParam("acronym") String acronym, @RequestParam("t_desc") String t_desc,
                             @RequestParam("isbillable") boolean isBillable, @RequestParam("price") double price) throws TaskNotFoundException
    {

        AvailableTask availableTask = availableTaskService.getAvailableTask(taskId);
        availableTask.setAcronym(acronym);
        availableTask.setBillable(isBillable);
        availableTask.setPrice(price);
        availableTask.setTaskDesc(t_desc);

        model.addAttribute("taskId", taskId);
        model.addAttribute("acronym", acronym);
        model.addAttribute("t_desc", t_desc);
        model.addAttribute("price", price);
        model.addAttribute("isbillable", isBillable);
        model.addAttribute("tasksList", availableTaskService.getAllAvailableTask());
        availableTaskService.updateAvailableTask(availableTask);

        return "AvailableTask/AvailableTask_list";
    }
}