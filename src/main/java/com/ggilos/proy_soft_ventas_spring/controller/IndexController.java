package com.ggilos.proy_soft_ventas_spring.controller;

import com.ggilos.proy_soft_ventas_spring.custom.CustomUserDetails;
import com.ggilos.proy_soft_ventas_spring.entity.UsuarioEntity;
import com.ggilos.proy_soft_ventas_spring.enums.RolEnum;
import com.ggilos.proy_soft_ventas_spring.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("index")
public class IndexController {

    private final UsuarioRepository usuarioRepository;

    public IndexController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String dashboard(ModelMap modelMap, Principal principal) {
        if(principal != null) {

            String username = principal.getName();

            UsuarioEntity usuarioEntity = usuarioRepository
                    .findByUserName(username)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            boolean isAdmin = usuarioEntity.getRol().getRolNombre().name().equalsIgnoreCase("ADMIN");

            CustomUserDetails user = new CustomUserDetails(usuarioEntity);

            modelMap.addAttribute("user", user);
            modelMap.addAttribute("isAdmin", isAdmin);

        }

        return "dashboard/index";
    }
}
