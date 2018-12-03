package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import edu.ccsu.datamail.jobtracker.service.AvailableTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AvailableTaskController {

    AvailableTaskService availableTaskService;

    @RequestMapping(value="availableTaskAjax", method = RequestMethod.GET)
    public @ResponseBody List searchAvailableTasks(HttpServletRequest request, @RequestParam("acronym") String acronym){

        List<AvailableTask> taskList = availableTaskService.getAvailableTaskList();

        List listString = new ArrayList();

        for (AvailableTask availableTask : taskList) {

            if (availableTask.getAcronym().toLowerCase().contains(acronym.toLowerCase())) {
                listString.add(availableTask);
            }
        }

        return listString;
    }

}
