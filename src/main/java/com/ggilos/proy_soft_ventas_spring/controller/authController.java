package com.ggilos.proy_soft_ventas_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class authController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
