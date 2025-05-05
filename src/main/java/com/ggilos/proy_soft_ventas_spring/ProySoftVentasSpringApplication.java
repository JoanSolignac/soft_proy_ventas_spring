package com.ggilos.proy_soft_ventas_spring;

import com.ggilos.proy_soft_ventas_spring.entity.RolEntity;
import com.ggilos.proy_soft_ventas_spring.entity.UsuarioEntity;
import com.ggilos.proy_soft_ventas_spring.enums.RolEnum;
import com.ggilos.proy_soft_ventas_spring.repository.RolRepository;
import com.ggilos.proy_soft_ventas_spring.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class ProySoftVentasSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProySoftVentasSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UsuarioRepository usuarioRepository,
                                  RolRepository rolRepository,
                                  PasswordEncoder passwordEncoder) {
        return args -> {
            if(rolRepository.count() == 0) {

                RolEntity admin = RolEntity
                        .builder()
                        .rol(RolEnum.ADMIN)
                        .build();

                RolEntity user = RolEntity
                        .builder()
                        .rol(RolEnum.USER)
                        .build();

                rolRepository.saveAll(
                        List.of(
                                admin, user
                        )
                );

                if(usuarioRepository.count() == 0) {

                    UsuarioEntity userAdmin = UsuarioEntity
                            .builder()
                            .userName("admin")
                            .password(passwordEncoder.encode("admin"))
                            .build();

                    usuarioRepository.saveAll(
                            List.of(
                                    userAdmin
                            )
                    );

                }

            }
        };
    }

}
