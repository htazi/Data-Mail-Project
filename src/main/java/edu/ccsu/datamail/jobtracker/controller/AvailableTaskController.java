package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import edu.ccsu.datamail.jobtracker.entity.task.acronymDD;
import edu.ccsu.datamail.jobtracker.service.AvailableTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @RequestMapping(value = {"/list", "/updateTaskPost/{taskId}"}, method = RequestMethod.POST)
    public String saveTask(@RequestParam("taskId") Integer taskId, @RequestParam("acronym") String acronym,
                           @RequestParam("t_desc") String taskDesc, @RequestParam(value = "is_billable", defaultValue = "false") Boolean isBillable,
                           @RequestParam("price") Double price, Model model)
    {
        /*TODO figure out how  the auto-increment when inserting new task will work. Currently its hardcoded*/

        /*Build the availableTask object for insertion*/
        // TODO: Validation may have to be added when a task is being updated
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

    @ResponseBody
    @RequestMapping(value = "/getAcronym", method = RequestMethod.GET)
    public List<acronymDD> getAcronym(Model model)
    {
        List<acronymDD> acronymDDList = new ArrayList<>();
        List<AvailableTask> taskList = availableTaskService.getAllAvailableTaskSortByAcronym();

        for (int i = 0; i < taskList.size(); i++) {
            int taskid = taskList.get(i).getTaskId();
            String acronym = taskList.get(i).getAcronym();
            acronymDDList.add(new acronymDD(taskid, acronym));
        }

        return acronymDDList;
    }
}