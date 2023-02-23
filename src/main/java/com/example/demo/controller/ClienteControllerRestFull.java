package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IClienteService;
import com.example.demo.service.to.ClienteTO;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteControllerRestFull {
	
	@Autowired
	IClienteService clienteService;
	
	///1. Buscar Cliente por cedula
	@GetMapping(path = "/{cedula}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ClienteTO buscarCesula(@PathVariable("cedula") String cedula) {
		return this.clienteService.buscarCedula(cedula);
	}
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void insertarCliente(@RequestBody ClienteTO clienteTO) {
		this.clienteService.create(clienteTO);
	}

	
	//3. Actualizar Cliente a partir del id
	
	@PutMapping(path = "/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void actualizar(@PathVariable("id") Integer id, @RequestBody ClienteTO clienteTO) {
		clienteTO.setId(id);
		this.clienteService.update(clienteTO);
	}
	
	// 4. Buscar Clientes (buscar todos)
   
	
	@GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ClienteTO> buscarTodos(){
		return this.clienteService.buscarTodosClientes();
	}
	
	// 5. Borrar a partir del id
	
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable("id") Integer id) {
		this.clienteService.delete(id);
	}
	
	 //6. Borrar a partir de la cédula
	@DeleteMapping(path = "porCedula/{cedula}")
	public void borrar(@PathVariable("cedula") String cedula) {
		this.clienteService.deleteCedula(cedula);
	}
}
