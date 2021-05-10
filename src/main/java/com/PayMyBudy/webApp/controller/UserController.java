package com.PayMyBudy.webApp.controller;

import com.PayMyBudy.service.ConnectionService;
import com.PayMyBudy.service.UserService;
import com.PayMyBudy.service.form.AddConnectionForm;
import com.PayMyBudy.service.form.LoginForm;
import com.PayMyBudy.service.form.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    private final ConnectionService connectionService;
    private final UserService userService;
public UserController(ConnectionService connectionService, UserService userService) {
    this.connectionService = connectionService;
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
    public ModelAndView processRequest(@ModelAttribute("registrationForm") RegistrationForm form) {
        userService.registration(form);

        return new ModelAndView("signin","loginForm",new LoginForm());

    }
    @RequestMapping(value = "/addConnection", method = RequestMethod.POST)
    public ModelAndView processRequest(@ModelAttribute("addConnectionForm") AddConnectionForm form) {
   connectionService.addConnection(form);
        return new ModelAndView("transfer","addConnectionForm",new AddConnectionForm());


    }
    @GetMapping("/transfer")
    public ModelAndView transfer(Model model) {


        return new ModelAndView("transfer","addConnectionForm",new AddConnectionForm());
    }
    @GetMapping("/home")
    public String logOff(Model model) {


        return "home";
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