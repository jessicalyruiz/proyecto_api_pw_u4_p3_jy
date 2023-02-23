package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.ClienteTO;





public interface IClienteService {

	public void create(ClienteTO clienteTO);
	public ClienteTO read(Integer id); 
	public void update(ClienteTO clienteTO); 
	public void delete(Integer id); 
	
	public ClienteTO buscarCedula(String cedula);
	
	public void deleteCedula(String cedula);
	public List<ClienteTO> buscarTodosClientes();
	
	
	//public List<ClienteVIP> reporteClientesVIP();
}
