package com.example.demo.repository;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public Cliente read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}

	@Override
	public Cliente buscarCedula(String cedula) {
		TypedQuery<Cliente> myQuery=this.entityManager.createQuery("Select c from Cliente c  where c.cedula=:valor", Cliente.class);
		myQuery.setParameter("valor", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Cliente> buscarTodosClientes() {
		TypedQuery<Cliente> myQuery=this.entityManager.createQuery("Select c from Cliente c", Cliente.class);
		//relacionamientos
		return myQuery.getResultList();
	}

	@Override
	public void deleteCedula(String cedula) {
		// TODO Auto-generated method stub
		this.delete(this.buscarCedula(cedula).getId());
	}



}


