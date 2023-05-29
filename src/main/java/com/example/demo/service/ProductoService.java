package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.bd.Producto;
import com.example.demo.repository.ProductoRepository;





@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> listarProducto(){
		return productoRepository.findAll();
	}
	
	public void registrarProducto(Producto producto) {
		productoRepository.save(producto);
	}
	
	public void eliminarProducto(Integer idproducto) {
		productoRepository.deleteById(idproducto);
	}
	

}
