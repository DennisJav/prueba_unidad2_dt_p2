package com.uce.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Paciente;
import com.uce.ec.repository.IPacienteRepo;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepo pacienteRepo;

	@Override
	public void crearPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.crearPaciente(paciente);
	}

	@Override
	public Paciente buscaPacientePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscaPacientePorId(id);
	}

	@Override
	public Paciente buscaPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscaPacientePorCedula(cedula);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.actualizarPaciente(paciente);
	}

	@Override
	public void eliminarPaciente(Integer id) {
		// TODO Auto-generated method stub
		this.pacienteRepo.eliminarPaciente(id);
	}

}
