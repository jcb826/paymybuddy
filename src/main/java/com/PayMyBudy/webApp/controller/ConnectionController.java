package com.PayMyBudy.webApp.controller;

import com.PayMyBudy.service.ConnectionService;
import com.PayMyBudy.service.form.AddConnectionForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ConnectionController {

    private final ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @RequestMapping(value = "/addConnection", method = RequestMethod.POST)
    public ModelAndView processRequest(@ModelAttribute("addConnectionForm") AddConnectionForm form) {
        connectionService.addConnection(form);
        return new ModelAndView("transfer", "addConnectionForm", new AddConnectionForm());
    }
}
