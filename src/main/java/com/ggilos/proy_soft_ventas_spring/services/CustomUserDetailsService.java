package com.ggilos.proy_soft_ventas_spring.services;

import com.ggilos.proy_soft_ventas_spring.custom.CustomUserDetails;
import com.ggilos.proy_soft_ventas_spring.entity.UsuarioEntity;
import com.ggilos.proy_soft_ventas_spring.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioEntity usuarioEntity = usuarioRepository.findByUserName(username)
                .orElseThrow();

        return new CustomUserDetails(usuarioEntity);
    }
}
