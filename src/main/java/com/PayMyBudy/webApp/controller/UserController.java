package com.PayMyBudy.webApp.controller;

import com.PayMyBudy.model.Account;
import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.model.User;
import com.PayMyBudy.service.ConnectionService;
import com.PayMyBudy.service.TransferService;
import com.PayMyBudy.service.UserService;
import com.PayMyBudy.service.form.*;
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


    @GetMapping("/")
    public ModelAndView home(Model model) {
        List<Transfer> transactions = transferService.findTransactions();
        model.addAttribute("transfers", transactions);
        return new ModelAndView("index");
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

    @GetMapping("profile")
    public ModelAndView profile(Model model) {
        User account = userService.findAccount();
        model.addAttribute("account", account);

        return new ModelAndView("profile");


    }

    @GetMapping("add-iban")
    public ModelAndView getAddConnectionForm(Model model) {
        return new ModelAndView("add-iban", "addIbanForm", new AddIbanForm());
    }
    @PostMapping("add-iban")
    public ModelAndView addIban(@ModelAttribute("addIbanForm") AddIbanForm form) {
        userService.addIban(form);
        return new ModelAndView("add-iban", "addIbanForm", new AddIbanForm());
    }
}

