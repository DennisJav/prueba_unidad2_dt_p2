package com.uce.ec;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.ec.modelo.Doctor;
import com.uce.ec.modelo.Paciente;
import com.uce.ec.modelo.PacienteSencillo;
import com.uce.ec.service.IDoctorService;
import com.uce.ec.service.IGestorCitaService;
import com.uce.ec.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2DtP21Application implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(PruebaUnidad2DtP21Application.class);

	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private IGestorCitaService gestorCitaService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2DtP21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("PRUEBA UNIDAD 2");
		LOG.info("Ingreso de dos doctores");
		Doctor d1 = new Doctor();
		d1.setCedula("12369");
		d1.setNombre("Dennis");
		d1.setApellido("Tapia");
		d1.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		d1.setNumeroConsultorio("1a");
		d1.setCodigoSenecyt("asd1");
		d1.setGenero("M");
		//this.doctorService.crearDoctor(d1);

		Doctor d2 = new Doctor();
		d2.setCedula("1234569");
		d2.setNombre("Javier");
		d2.setApellido("Ortiz");
		d2.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		d2.setNumeroConsultorio("2a");
		d2.setCodigoSenecyt("asd1222");
		d2.setGenero("M");
		//this.doctorService.crearDoctor(d2);

		LOG.info("Ingreso de dos pacientes");
		Paciente p1 = new Paciente();
		p1.setCedula("7812");
		p1.setNombre("Alis");
		p1.setApellido("Capuz");
		p1.setFechaNacimiento(LocalDateTime.of(1996, 1, 1, 1, 1));
		p1.setCodigoSeguro("123aasd");
		p1.setEstatura(1.69);
		p1.setPeso(65.2);
		p1.setGenero("F");
		//this.pacienteService.crearPaciente(p1);

		Paciente p2 = new Paciente();
		p2.setCedula("7912");
		p2.setNombre("Ali");
		p2.setApellido("Morocho");
		p2.setFechaNacimiento(LocalDateTime.of(1997, 2, 2, 2, 2));
		p2.setCodigoSeguro("123sqwd");
		p2.setEstatura(1.69);
		p2.setPeso(65.2);
		p2.setGenero("F");
		//this.pacienteService.crearPaciente(p2);

		LOG.info("Agendar cita");
		//this.gestorCitaService.agendarCitaMedica("2", LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1),
				//new BigDecimal(10), "Villaflora", "12369", "7912");
		LOG.info("Actualizar cita");
		//this.gestorCitaService.actualizarCitamedica("1", "COVID", "PARACETAMOL",
				//LocalDateTime.of(2024, Month.JANUARY, 2, 2, 2));
		LOG.info("Reporte pacientes");
		//this.gestorCitaService.reportePacientes(LocalDateTime.of(1997, 2, 2, 2, 2), "F");

	}

}
