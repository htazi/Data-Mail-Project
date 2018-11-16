package edu.ccsu.datamail.jobtracker.controller;

import edu.ccsu.datamail.jobtracker.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Controller
public class MainController
{

    @RequestMapping(value = { "/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model)
    {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "user/welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal)
    {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "user/adminPage";
    }

    @RequestMapping(value = {"/" ,"/login"}, method = RequestMethod.GET)
    public String loginPage(Model model)
    {
        return "user/loginPage";
    }

    /**
     * Redirects a user to their ROLE page after successful login.
     *
     * @param request
     * @param response
     * @param authResult
     * @throws IOException
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException, IOException {

        String role =  authResult.getAuthorities().toString();

        if(role.contains("ROLE_ADMIN")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin"));
        }
        else if(role.contains("ROLE_USER")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/userInfo"));
        }else if(role.contains("ROLE_Production_Programmer")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/programmer"));
        }else if(role.contains("ROLE_File_Transfer")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/fileTransfer"));
        }else if(role.contains("ROLE_Data_Processing")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/dataProcessing"));
        }else if(role.contains("ROLE_Billing")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/billing"));
        }else if(role.contains("ROLE_Manager")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/manager"));
        }
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model)
    {
        model.addAttribute("title", "Logout");
        return "user/logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal)
    {
        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "user/userInfoPage";
    }

    @RequestMapping(value = "/billing", method = RequestMethod.GET)
    public String billingPage(Model model, Principal principal)
    {
        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "user/billingPage";
    }

    @RequestMapping(value = "/dataProcessing", method = RequestMethod.GET)
    public String dataProcessingPage(Model model, Principal principal)
    {
        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "user/dataProcessingPage";
    }

    @RequestMapping(value = "/fileTransfer", method = RequestMethod.GET)
    public String fileTransferPage(Model model, Principal principal)
    {
        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "user/fileTransferPage";
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String managerPage(Model model, Principal principal)
    {
        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "user/managerPage";
    }

    @RequestMapping(value = "/programmer", method = RequestMethod.GET)
    public String programmerPage(Model model, Principal principal)
    {

        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "user/programmerPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal)
    {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "user/403Page";
    }
}
