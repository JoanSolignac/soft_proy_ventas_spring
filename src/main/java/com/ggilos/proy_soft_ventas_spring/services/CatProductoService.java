package com.ggilos.proy_soft_ventas_spring.services;

import com.ggilos.proy_soft_ventas_spring.entity.CatProductoEntity;
import com.ggilos.proy_soft_ventas_spring.repository.CatProductoRepository;
import com.ggilos.proy_soft_ventas_spring.repository.ProductoRepository;
import com.ggilos.proy_soft_ventas_spring.services.interfaces.ICatProductoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CatProductoService implements ICatProductoService {

    private final CatProductoRepository catProductoRepository;

    public CatProductoService(CatProductoRepository catProductoRepository, ProductoRepository productoRepository) {
        this.catProductoRepository = catProductoRepository;
    }

    @Override
    public void agregarCategoriaProducto(CatProductoEntity catProductoEntity) {
        catProductoRepository.save(catProductoEntity);
    }

    @Override
    public void editarCategoriaProducto(CatProductoEntity catProductoEntity) {
        catProductoRepository.save(catProductoEntity);
    }

    @Override
    public void eliminarCategoriaProducto(CatProductoEntity catProductoEntity) {
        catProductoRepository.delete(catProductoEntity);
    }

    @Override
    public Page<CatProductoEntity> obtenerCategoriasProducto(Pageable pageable) {
        return catProductoRepository.findAll(pageable);
    }

    @Override
    public CatProductoEntity buscarCategoriaProductoPorId(Long id) {
        return catProductoRepository.findById(id).orElse(null);
    }
}
