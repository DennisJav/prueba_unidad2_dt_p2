package com.uce.ec.service;

import com.uce.ec.modelo.Doctor;

public interface IDoctorService {
	void crearDoctor(Doctor doctor);
	Doctor buscaDoctorPorId(Integer id);
	Doctor buscaDoctorPorCedula(String cedula);
	void actualizarDoctor(Doctor doctor);
	void eliminarDoctor(Integer id);
	
}
