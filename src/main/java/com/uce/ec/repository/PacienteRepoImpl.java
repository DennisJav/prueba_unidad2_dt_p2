package com.uce.ec.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Doctor;
import com.uce.ec.modelo.Paciente;
import com.uce.ec.modelo.PacienteSencillo;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crearPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscaPacientePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public Paciente buscaPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> typedQuery = this.entityManager
				.createQuery("select p from Paciente p where p.cedula = :valoruno", Paciente.class);
		typedQuery.setParameter("valoruno", cedula);
		return typedQuery.getSingleResult();
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminarPaciente(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscaPacientePorId(id));
	}

	@Override
	public List<PacienteSencillo> buscarSencilloFechaGenero(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.ec.modelo.PacienteSencillo(p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento > :valorUno and p.genero = :valorDos",
				PacienteSencillo.class);
		myQuery.setParameter("valorUno", fechaNacimiento);
		myQuery.setParameter("valorDos", genero);
		return myQuery.getResultList();
	}

}
