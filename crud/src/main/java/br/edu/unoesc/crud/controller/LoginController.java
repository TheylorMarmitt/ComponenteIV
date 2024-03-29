package br.edu.unoesc.crud.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(path = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "login";
    }
}

