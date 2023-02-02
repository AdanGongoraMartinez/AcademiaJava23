package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Producto;

@Repository
public class ProductoDAOImpl implements ProductoDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Producto> getProductos() {
		
		// get the current hibernate session
		Session sessionActual = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Producto> elQuery = 
				sessionActual.createQuery("from Producto order by nombre",
											Producto.class);
		
		// execute query and get result list
		List<Producto> productos = elQuery.getResultList();
		System.out.println("***"+productos);		
		// return the results		
		return productos;
	}

	@Override
	public void guardarProducto(Producto elProducto) {

		// get current hibernate session
		Session sessionActual = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		sessionActual.saveOrUpdate(elProducto);
		
	}

	@Override
	public Producto getProducto(int elId) {

		// get the current hibernate session
		Session sessionActual = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Producto elProducto = sessionActual.get(Producto.class, elId);
		
		return elProducto;
	}

	@Override
	public void borrarProducto(int elId) {

		// get the current hibernate session
		Session sessionActual = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query elQuery = 
				sessionActual.createQuery("delete from Producto where id=:productoId");
		elQuery.setParameter("productoId", elId);
		
		elQuery.executeUpdate();
	}

}











