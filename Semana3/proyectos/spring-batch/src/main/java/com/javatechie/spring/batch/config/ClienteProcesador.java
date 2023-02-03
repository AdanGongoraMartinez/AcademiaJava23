package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcesador implements ItemProcessor<Cliente,Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
//        if(customer.getCountry().equals("China")) {
//            return customer;
//        }
//        return null;
//        

	
    	return cliente;
    }
}
