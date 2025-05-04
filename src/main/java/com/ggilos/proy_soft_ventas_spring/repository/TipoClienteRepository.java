package com.ggilos.proy_soft_ventas_spring.repository;

import com.ggilos.proy_soft_ventas_spring.entity.TipoClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoClienteRepository extends JpaRepository<TipoClienteEntity, Long> {
}
