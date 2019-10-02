package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Exemplar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {

    @RequestMapping(path = "/login")
    public String login() {
        return "login";
    }


}

