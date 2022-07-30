package com.uce.ec.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorCitaService {

	void agendarCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);

	void actualizarCitamedica(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita);
	
	void reportePacientes(LocalDateTime fechaNacimiento, String genero);
}
