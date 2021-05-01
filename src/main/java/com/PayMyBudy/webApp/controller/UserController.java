package com.PayMyBudy.webApp.controller;

import com.PayMyBudy.model.User;
import com.PayMyBudy.service.UserService;
import com.PayMyBudy.service.form.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String showForm(Model model) {
        User user = new User();
        List<String> professionList = Arrays.asList("Developer", "Designer", "Tester");

        model.addAttribute("user", user);
        model.addAttribute("professionList", professionList);

        return "signin";
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
    // hello world
}