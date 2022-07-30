package com.uce.ec.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.PruebaUnidad2DtP21Application;
import com.uce.ec.modelo.CitaMedica;
import com.uce.ec.modelo.Doctor;
import com.uce.ec.modelo.Paciente;
import com.uce.ec.modelo.PacienteSencillo;
import com.uce.ec.repository.ICitaMedicaRepo;
import com.uce.ec.repository.IDoctorRepo;
import com.uce.ec.repository.IPacienteRepo;

@Service
public class GestorServiceImpl implements IGestorCitaService{

	private static final Logger LOG = LogManager.getLogger(GestorServiceImpl.class);
	@Autowired 
	private IDoctorRepo doctorRepo;
	@Autowired
	private IPacienteRepo pacienteRepo;
	@Autowired 
	private ICitaMedicaService citaMedicaService;
	
	
	@Override
	public void agendarCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		
		
		
		Doctor  doctorBuscado = this.doctorRepo.buscaDoctorPorCedula(cedulaDoctor);
		
		Paciente pacienteBuscado = this.pacienteRepo.buscaPacientePorCedula(cedulaPaciente);
		
		CitaMedica cita1=new CitaMedica();
		cita1.setNumeroCita(numeroCita);
		cita1.setFechaCita(fechaCita);
		cita1.setValorCita(valorCita);
		cita1.setLugar_cita(lugarCita);
		cita1.setDoctor(doctorBuscado);
		cita1.setPaciente(pacienteBuscado);
		
		this.citaMedicaService.crearCitaMedica(cita1);
		
	}

	@Override
	public void actualizarCitamedica(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		
		CitaMedica citaBuscada = this.citaMedicaService.buscarCitaMedica(numeroCita);
		CitaMedica citaActualizada =new CitaMedica();
		citaActualizada.setId(citaBuscada.getId());
		citaActualizada.setNumeroCita(numeroCita);
		citaActualizada.setFechaCita(citaBuscada.getFechaCita());
		citaActualizada.setValorCita(citaBuscada.getValorCita());
		citaActualizada.setLugar_cita(citaBuscada.getLugar_cita());
		citaActualizada.setDiagnostico(diagnostico);
		citaActualizada.setReceta(receta);
		citaActualizada.setFechaProximaCita(fechaProximaCita);
		citaActualizada.setPaciente(citaBuscada.getPaciente());
		citaActualizada.setDoctor(citaBuscada.getDoctor());
		
		this.citaMedicaService.actualizarCita(citaActualizada);
		
	}

	@Override
	public void reportePacientes(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		List<PacienteSencillo> pse= this.pacienteRepo.buscarSencilloFechaGenero(fechaNacimiento, genero);
		LOG.info("pacientes encontrados: "+pse.size());
		for(PacienteSencillo pasc : pse) {
			LOG.info("paciente: "+pasc);
		}
	}

	
}
