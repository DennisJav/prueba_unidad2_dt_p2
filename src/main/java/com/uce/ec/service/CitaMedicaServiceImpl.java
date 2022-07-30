package com.uce.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.CitaMedica;
import com.uce.ec.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{

	@Autowired
	private ICitaMedicaRepo citaMedicaRepo;
	
	@Override
	public void crearCitaMedica(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.crearCitaMedica(citaMedica);
	}

	@Override
	public void actualizarCita(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.actualizarCita(citaMedica);
	}

	@Override
	public CitaMedica buscarCitaMedica(String numeroCita) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepo.buscarCitaMedica(numeroCita);
	}

	
	
	
}
