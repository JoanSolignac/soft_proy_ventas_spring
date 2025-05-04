package com.ggilos.proy_soft_ventas_spring.repository;

import com.ggilos.proy_soft_ventas_spring.entity.CatProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatProductoRepository extends JpaRepository<CatProductoEntity, Long> {
}
