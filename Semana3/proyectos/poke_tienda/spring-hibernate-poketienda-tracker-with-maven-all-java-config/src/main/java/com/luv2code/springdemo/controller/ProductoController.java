package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Producto;
import com.luv2code.springdemo.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	// need to inject our customer service
	@Autowired
	private ProductoService productoServicio;
	
	@GetMapping("/list")
	public String listProductos(Model elModelo) {
		
		// get customers from the service
		List<Producto> losProductos = productoServicio.getProductos();
				
		// add the customers to the model
		elModelo.addAttribute("productos", losProductos);
		
		return "list-productos";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model elModelo) {
		
		// create model attribute to bind form data
		Producto elProducto = new Producto();
		
		elModelo.addAttribute("producto", elProducto);
		
		return "producto-form";
	}
	
	@PostMapping("/guardarProducto")
	public String guardarProducto(@ModelAttribute("producto") Producto elProducto) {
		
		// save the customer using our service
		productoServicio.guardarProducto(elProducto);	
		
		return "redirect:/producto/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productoId") int elId,
									Model theModel) {
		
		// get the customer from our service
		Producto elProducto = productoServicio.getProducto(elId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("producto", elProducto);
		
		// send over to our form		
		return "producto-form";
	}
	
	@GetMapping("/delete")
	public String borrarProducto(@RequestParam("productoId") int elID) {
		
		// delete the customer
		productoServicio.borrarProducto(elID);
		
		return "redirect:/producto/list";
	}
}










