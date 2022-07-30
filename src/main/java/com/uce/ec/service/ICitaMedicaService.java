package com.uce.ec.service;

import com.uce.ec.modelo.CitaMedica;

public interface ICitaMedicaService {
	void crearCitaMedica(CitaMedica citaMedica);
	void actualizarCita(CitaMedica citaMedica);
	CitaMedica buscarCitaMedica(String numeroCita);
}
