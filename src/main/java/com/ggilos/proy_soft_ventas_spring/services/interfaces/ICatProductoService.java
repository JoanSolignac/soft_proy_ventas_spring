package com.ggilos.proy_soft_ventas_spring.services.interfaces;

import com.ggilos.proy_soft_ventas_spring.entity.CatProductoEntity;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface ICatProductoService {
    void agregarCategoriaProducto(CatProductoEntity catProductoEntity);
    void editarCategoriaProducto(CatProductoEntity catProductoEntity);
    void eliminarCategoriaProducto(CatProductoEntity catProductoEntity);
    Page<CatProductoEntity> obtenerCategoriasProducto(Pageable pageable);
    CatProductoEntity buscarCategoriaProductoPorId(Long id);
}
