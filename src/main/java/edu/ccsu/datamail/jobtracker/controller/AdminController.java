package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import edu.ccsu.datamail.jobtracker.entity.task.TaskNotFoundException;
import edu.ccsu.datamail.jobtracker.service.AvailableTaskService;
import edu.ccsu.datamail.jobtracker.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(value = "/admin")
public class AdminController
{

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public AdminController(AvailableTaskService availableTaskService, UserDetailsServiceImpl userDetailsService)
    {

        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(Model model)
    {


        return "user/addUser";
    }



    /**
     *
     */
    @RequestMapping(value = "admin/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("user_name") String user_name, @RequestParam("f_name") String f_name,
                          @RequestParam("l_name") String l_name, @RequestParam("user_id") Integer user_id, Model model)
    {

     return "user/addUser";
    }


}