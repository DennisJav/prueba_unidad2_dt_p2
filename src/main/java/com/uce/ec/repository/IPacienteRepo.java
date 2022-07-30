package com.uce.ec.repository;


import java.time.LocalDateTime;
import java.util.List;

import com.uce.ec.modelo.Paciente;
import com.uce.ec.modelo.PacienteSencillo;

public interface IPacienteRepo {

	void crearPaciente(Paciente paciente);
	Paciente buscaPacientePorId(Integer id);
	Paciente buscaPacientePorCedula(String cedula);
	void actualizarPaciente(Paciente paciente);
	void eliminarPaciente(Integer id);
	List<PacienteSencillo> buscarSencilloFechaGenero(LocalDateTime fechaNacimiento, String genero);
	
}
