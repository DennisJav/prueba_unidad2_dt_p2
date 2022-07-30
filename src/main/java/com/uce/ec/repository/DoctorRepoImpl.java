package com.uce.ec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Doctor;


@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crearDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
	}

	@Override
	public Doctor buscaDoctorPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public Doctor buscaDoctorPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Doctor> typedQuery = this.entityManager
				.createQuery("select d from Doctor d where d.cedula = :valoruno", Doctor.class);
		typedQuery.setParameter("valoruno", cedula);
		return typedQuery.getSingleResult();
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	public void eliminarDoctor(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscaDoctorPorId(id));;
	}
	

}
