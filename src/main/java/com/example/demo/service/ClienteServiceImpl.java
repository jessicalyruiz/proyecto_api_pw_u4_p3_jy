package com.example.demo.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepo;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.service.to.ClienteTO;



@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo clienteRepo;
	
	

	@Override
	public void create(ClienteTO clienteTO) {
		// TODO Auto-generated method stub
		this.clienteRepo.create(this.convertirCliente(clienteTO));
	}

	@Override
	public ClienteTO read(Integer id) {
		// TODO Auto-generated method stub
		return this.convertirClienteTO( this.clienteRepo.read(id));
	}

	@Override
	public void update(ClienteTO clienteTO) {
		// TODO Auto-generated method stub
		this.clienteRepo.update(this.convertirCliente(clienteTO));
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepo.delete(id);
	}

	@Override
	public ClienteTO buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.convertirClienteTO(this.clienteRepo.buscarCedula(cedula));
	}



	@Override
	public List<ClienteTO> buscarTodosClientes() {
		// TODO Auto-generated method stub
		List<Cliente> clientes=this.clienteRepo.buscarTodosClientes();
		return clientes.stream().map(c->convertirClienteTO(c)).collect(Collectors.toList());
		
	}

	
	public Cliente convertirCliente(ClienteTO clienteTO) {
		Cliente cliente=new Cliente();
		cliente.setApellido(clienteTO.getApellido());
		cliente.setCedula(clienteTO.getCedula());
		cliente.setFechaNacimiento(clienteTO.getFechaNacimiento());
		cliente.setGenero(clienteTO.getGenero());
		cliente.setId(clienteTO.getId());
		cliente.setNombre(clienteTO.getNombre());
		//*************
		cliente.setEmail(clienteTO.getEmail());
		return cliente;
	}
	
	public ClienteTO convertirClienteTO(Cliente cliente) {
		ClienteTO clienteTO=new ClienteTO();
		clienteTO.setApellido(cliente.getApellido());
		clienteTO.setCedula(cliente.getCedula());
		clienteTO.setFechaNacimiento(cliente.getFechaNacimiento());
		clienteTO.setGenero(cliente.getGenero());
		clienteTO.setId(cliente.getId());
		clienteTO.setNombre(cliente.getNombre());
		clienteTO.setEmail(cliente.getEmail());
		return clienteTO;
	}

	@Override
	public void deleteCedula(String cedula) {
		// TODO Auto-generated method stub
		this.clienteRepo.deleteCedula(cedula);
	}



}
