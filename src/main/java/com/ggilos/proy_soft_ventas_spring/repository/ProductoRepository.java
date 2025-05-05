package com.ggilos.proy_soft_ventas_spring.repository;

import com.ggilos.proy_soft_ventas_spring.entity.CatProductoEntity;
import com.ggilos.proy_soft_ventas_spring.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}
