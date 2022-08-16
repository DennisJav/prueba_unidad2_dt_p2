package com.uce.ec.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.ec.modelo.Paciente;
import com.uce.ec.modelo.PacienteSencillo;
import com.uce.ec.repository.IPacienteRepo;

@SpringBootTest
@Transactional
@Rollback(true)
class GestorServiceImplTest {

	@Autowired
	private IGestorCitaService gestorCitaService;
	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private ICitaMedicaService citaMedicaService;
	@Autowired
	private IPacienteRepo pacienteRepo;

	@Test
	void testAgendarCitaMedica() {

		this.gestorCitaService.agendarCitaMedica("88", LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1),
				new BigDecimal(10), "Villaflora", "123", "7912");

		assertThat(this.doctorService.buscaDoctorPorCedula("123")).isNotNull();

	}

	@Test
	void testActualizarCitamedica() {
		this.gestorCitaService.actualizarCitamedica("1", "COVID", "PARACETAMOL",
				LocalDateTime.of(2024, Month.JANUARY, 2, 2, 2));
		assertThat(this.citaMedicaService.buscarCitaMedica("1")).isNotNull();
	}

	@Test
	void testReportePacientes() {
		List<PacienteSencillo> p = this.pacienteRepo.buscarSencilloFechaGenero(LocalDateTime.of(1997, 2, 2, 2, 2), "q");
		assertThat(p).isEmpty();
	}

}
