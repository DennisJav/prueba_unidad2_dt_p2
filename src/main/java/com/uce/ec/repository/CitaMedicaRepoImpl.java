package com.uce.ec.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.CitaMedica;
import com.uce.ec.modelo.Paciente;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void crearCitaMedica(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizarCita(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica buscarCitaMedica(String numeroCita) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> typedQuery = this.entityManager
				.createQuery("select c from CitaMedica c where c.numeroCita = :valoruno", CitaMedica.class);
		typedQuery.setParameter("valoruno", numeroCita);
		return typedQuery.getSingleResult();
	}
	
}
