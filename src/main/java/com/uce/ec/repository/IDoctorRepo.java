package com.uce.ec.repository;

import com.uce.ec.modelo.Doctor;

public interface IDoctorRepo {

	void crearDoctor(Doctor doctor);
	Doctor buscaDoctorPorId(Integer id);
	Doctor buscaDoctorPorCedula(String cedula);
	void actualizarDoctor(Doctor doctor);
	void eliminarDoctor(Integer id);
	
}
