package com.uce.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Doctor;
import com.uce.ec.repository.IDoctorRepo;

@Service
public class DoctorServiceImpl implements IDoctorService{

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public void crearDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepo.crearDoctor(doctor);
	}

	@Override
	public Doctor buscaDoctorPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscaDoctorPorId(id);
	}

	@Override
	public Doctor buscaDoctorPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscaDoctorPorCedula(cedula);
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepo.actualizarDoctor(doctor);
	}

	@Override
	public void eliminarDoctor(Integer id) {
		// TODO Auto-generated method stub
		this.doctorRepo.eliminarDoctor(id);
	};
	
}
