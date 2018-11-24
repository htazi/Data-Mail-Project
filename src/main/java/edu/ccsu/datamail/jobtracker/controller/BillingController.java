package edu.ccsu.datamail.jobtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BillingController
{
    @RequestMapping(method = RequestMethod.GET, value = "/billing/displaybilling")
    public String getToBilling()
    {
        return "billing/displaybilling";
    }
}
