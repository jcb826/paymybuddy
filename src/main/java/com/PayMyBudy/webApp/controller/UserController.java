package com.PayMyBudy.webApp.controller;

import com.PayMyBudy.model.User;
import com.PayMyBudy.service.UserService;
import com.PayMyBudy.service.form.LoginForm;
import com.PayMyBudy.service.form.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller

public class UserController {
private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home() {

        return "index";
    }
    @GetMapping("/signin")
    public ModelAndView showForm(Model model) {


        return new ModelAndView("signin","loginForm",new LoginForm());
    }
    @GetMapping("/register")
    public ModelAndView showRegisterForm( ) {


        return new ModelAndView("register", "registrationForm", new RegistrationForm());
    }
    //Get the form field values which are populated using the backing bean and store it in db
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void processRequest(@ModelAttribute("registrationForm") RegistrationForm form) {
        userService.registration(form);
        /*
        List<User> users = userService.getUsers();
        ModelAndView model = new ModelAndView("getEmployees");
        model.addObject("employees", employees);


        return model;
        */

    }
    @GetMapping("/home")
    public String logOff(Model model) {


        return "home";
    }
    @GetMapping("/transfer")
    public String showTransferForm(Model model) {


        return "transfer";
    }
    @GetMapping("/contact")
    public String showContactForm(Model model) {


        return "contact";
    }
@PostMapping("login")
    public String processLogin(@ModelAttribute("loginForm") LoginForm form) {
       if (userService.signin(form)){
           return "index";
       }
       return "signin";
        /*
        List<User> users = userService.getUsers();
        ModelAndView model = new ModelAndView("getEmployees");
        model.addObject("employees", employees);


        return model;
        */

    }

//oki
}