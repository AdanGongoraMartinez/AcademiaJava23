package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Producto;

public interface ProductoDAO {

	public List<Producto> getProductos();

	public void guardarProducto(Producto elProducto);

	public Producto getProducto(int elId);

	public void borrarProducto(int elId);
	
}
