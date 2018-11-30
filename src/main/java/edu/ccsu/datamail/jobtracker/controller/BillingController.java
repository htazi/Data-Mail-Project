package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import edu.ccsu.datamail.jobtracker.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
;import java.security.Principal;

@Controller
public class BillingController
{
//    private final UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    public BillingController( UserDetailsServiceImpl userDetailsService)
//    {
//
//        this.userDetailsService = userDetailsService;
//
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/billing/displaybilling")
    public String getToBilling(Model model, Principal principal)
    {
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//        String name = loginedUser.getUsername();
//        AppUser user = userDetailsService.getUser(name);
//        String userName = user.getUserName();
//        model.addAttribute("userName", userName);
        return "billing/displaybilling";
    }
}
