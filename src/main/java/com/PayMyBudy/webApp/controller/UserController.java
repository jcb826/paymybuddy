package com.PayMyBudy.webApp.controller;

import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.service.ConnectionService;
import com.PayMyBudy.service.TransferService;
import com.PayMyBudy.service.UserService;
import com.PayMyBudy.service.form.AddConnectionForm;
import com.PayMyBudy.service.form.LoginForm;
import com.PayMyBudy.service.form.RegistrationForm;
import com.PayMyBudy.service.form.TransferForm;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller

public class UserController {
    private final ConnectionService connectionService;
    private final UserService userService;
    private final TransferService transferService;

    public UserController(ConnectionService connectionService, UserService userService, TransferService transferService) {
        this.connectionService = connectionService;
        this.userService = userService;
        this.transferService = transferService;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signin")
    public ModelAndView showForm(Model model) {
        return new ModelAndView("signin", "loginForm", new LoginForm());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView processRequest(@ModelAttribute("registrationForm") RegistrationForm form) {
        userService.registration(form);
        return new ModelAndView("signin", "loginForm", new LoginForm());
    }

    @GetMapping("/register")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("register", "registrationForm", new RegistrationForm());
    }

    @GetMapping("/home")
    public String logOff(Model model) {
        return "home";
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        return "contact";
    }

    @PostMapping(path="/login",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String processLogin( LoginForm form) {
        if (userService.signin(form)) {
            return "index";
        }
        return "signin";
    }
    @GetMapping("profile")
    public ModelAndView transfer(Model model) {

        return new ModelAndView("transfer", "transferForm", new TransferForm());
    }
}