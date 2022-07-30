package com.uce.ec.repository;

import com.uce.ec.modelo.CitaMedica;

public interface ICitaMedicaRepo {

	void crearCitaMedica(CitaMedica citaMedica);
	void actualizarCita(CitaMedica citaMedica);
	CitaMedica buscarCitaMedica(String numeroCita);
	
}
