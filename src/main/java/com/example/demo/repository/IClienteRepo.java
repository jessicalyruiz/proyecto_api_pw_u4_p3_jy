package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;



public interface IClienteRepo {

	public void create(Cliente cliente);
	public Cliente read(Integer id); 
	public void update(Cliente cliente); 
	public void delete(Integer id); 
	
	public Cliente buscarCedula(String cedula);
	public void deleteCedula(String cedula);
	public List<Cliente> buscarTodosClientes();
}
