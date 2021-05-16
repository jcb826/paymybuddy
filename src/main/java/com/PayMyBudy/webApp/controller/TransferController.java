package com.PayMyBudy.webApp.controller;

import com.PayMyBudy.service.ConnectionService;
import com.PayMyBudy.service.TransferService;
import com.PayMyBudy.service.form.TransferForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TransferController {

    private final TransferService transferService;
    private final ConnectionService connectionService;
    public TransferController(TransferService transferService, ConnectionService connectionService) {
        this.transferService = transferService;
        this.connectionService = connectionService;
    }

    @PostMapping("transfer")
    public ModelAndView transfer(Model model, @ModelAttribute("transferForm") TransferForm form) {
        transferService.transfer(form);
        List<String> contacts = connectionService.findConnectionsEmail();
        model.addAttribute("connections", contacts);
        return new ModelAndView("transfer", "transferForm", new TransferForm());
    }

    @GetMapping("/transfer")
    public ModelAndView transfer(Model model) {
        List<String> contacts = connectionService.findConnectionsEmail();
        model.addAttribute("connections", contacts);
        return new ModelAndView("transfer", "transferForm", new TransferForm());
    }
}
