package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ProductoDAO;
import com.luv2code.springdemo.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	// need to inject customer dao
	@Autowired
	private ProductoDAO productoDAO;
	
	@Override
	@Transactional
	public List<Producto> getProductos() {
		return productoDAO.getProductos();
	}

	@Override
	@Transactional
	public void guardarProducto(Producto elProducto) {

		productoDAO.guardarProducto(elProducto);
	}

	@Override
	@Transactional
	public Producto getProducto(int elId) {
		
		return productoDAO.getProducto(elId);
	}

	@Override
	@Transactional
	public void borrarProducto(int elId) {
		
		productoDAO.borrarProducto(elId);
	}
}





