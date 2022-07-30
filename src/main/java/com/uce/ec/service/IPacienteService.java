package com.uce.ec.service;

import com.uce.ec.modelo.Paciente;

public interface IPacienteService {

	void crearPaciente(Paciente paciente);
	Paciente buscaPacientePorId(Integer id);
	Paciente buscaPacientePorCedula(String cedula);
	void actualizarPaciente(Paciente paciente);
	void eliminarPaciente(Integer id);
	
}
