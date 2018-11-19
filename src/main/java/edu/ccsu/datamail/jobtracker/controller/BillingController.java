package edu.ccsu.datamail.jobtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BillingController {

    @RequestMapping(method = RequestMethod.GET, value = "/billing/displaybilling")
    public String getToBilling(@RequestParam("jobId") int jobId, Model model)
    {
        model.addAttribute("jobId", jobId);
        return "billing/displaybilling";
    }

}
