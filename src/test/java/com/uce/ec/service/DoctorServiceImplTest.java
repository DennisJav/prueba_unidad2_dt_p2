package com.uce.ec.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.ec.modelo.Doctor;

@SpringBootTest
@Transactional
@Rollback(true)
class DoctorServiceImplTest {

	@Autowired
	private IDoctorService doctorService;
	
	@Test
	void testCrearDoctor() {
		
		Doctor d1 = new Doctor();
		d1.setCedula("1236977");
		d1.setNombre("Dennis");
		d1.setApellido("Tapia");
		d1.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		d1.setNumeroConsultorio("1a");
		d1.setCodigoSenecyt("asd1");
		d1.setGenero("M");
		this.doctorService.crearDoctor(d1);
		assertThat(this.doctorService.buscaDoctorPorCedula(d1.getCedula()).getId()).isNotNull();
		
	}

	@Test
	void testBuscaDoctorPorId() {
	
		assertThat(this.doctorService.buscaDoctorPorId(1).getApellido()).isNotNull();
		
	}

	@Test
	void testBuscaDoctorPorCedula() {
		Doctor doctor = new Doctor();
		doctor.setCedula("1236922277");
		doctor.setNombre("Dennis");
		doctor.setApellido("Tapia");
		doctor.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		doctor.setNumeroConsultorio("1a");
		doctor.setCodigoSenecyt("asd1");
		doctor.setGenero("M");
		this.doctorService.crearDoctor(doctor);
		Doctor doctorBuscado = this.doctorService.buscaDoctorPorCedula(doctor.getCedula());
		assertEquals(doctor, doctorBuscado);
	}

	@Test
	void testActualizarDoctor() {
		Doctor doctor = new Doctor();
		doctor.setCedula("1236922277");
		doctor.setNombre("Dennis");
		doctor.setApellido("Tapia");
		doctor.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		doctor.setNumeroConsultorio("1a");
		doctor.setCodigoSenecyt("asd455");
		doctor.setGenero("M");		
		
		this.doctorService.crearDoctor(doctor);
		Doctor doctorBuscado = this.doctorService.buscaDoctorPorCedula(doctor.getCedula());
		doctorBuscado.setCodigoSenecyt("121212asad");
		this.doctorService.actualizarDoctor(doctorBuscado);
		assertEquals(doctor.getCodigoSenecyt(), doctorBuscado.getCodigoSenecyt());
	
		
	}

	@Test
	void testEliminarDoctor() {
		Doctor doctorBuscado = this.doctorService.buscaDoctorPorCedula("12345");
		assertThat(doctorBuscado.getId()).isNotIn(this.doctorService.buscaDoctorPorId(1));
	}

}
