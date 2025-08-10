package com.tienda.service.impl;

import com.tienda.repositorio.ProductoRepository;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> lista = productoRepository.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoRepository.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoRepository.deleteById(producto.getIdProducto());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarPorRangoPrecio(double precioInf, double precioSup) {
        return productoRepository.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarPorParteDescripcion(String termino) {
        return productoRepository.findByDescripcionContainingIgnoreCase(termino);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoRepository.metodoJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoNativo(double precioInf, double precioSup) {
        return productoRepository.metodoNativo(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarPorPrecioYCategoria(double precioMin, double precioMax, Long categoriaId) {
        return productoRepository.buscarPorPrecioYCategoria(precioMin, precioMax, categoriaId);
    }
}
