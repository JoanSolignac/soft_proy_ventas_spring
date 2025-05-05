package com.ggilos.proy_soft_ventas_spring.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class dashboardController {

    @GetMapping
    public String dashboard() {
        return "dashboard/index";
    }
}
