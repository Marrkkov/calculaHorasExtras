package cl.markov.proyecto.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HoraExtraServiceTest {
	
	@Autowired HoraExtraService servicio;
	
	@Test
	public void agregarHoraExtra() {
		//agrega una HoraExtra a un trabajador de forma manual, se debe ingresar los atributos de horaextra
		   //y debe mostrar la hora extra ingresada en la lista de horas extras del trabajador
		
		assertTrue(true);
		
	}
	
	public void cargarHorasExtras () {
		//importa los usuarios y las horas extras de un archivo excel entregado por el reloj control de la empresa.
		
		assertTrue(true);
		
	}
	public void sumarHorasExtra () {
		//realiza suma de horas extras de un trabajador pertenecientes a un mismo mes y anio.
		
		assertTrue(true);
	}
	
	public void llenarHorasExtrasTotales() {
		//debe traer la lista de todos las horas extras y mostrarla
				
		assertTrue(true);
	}
	
	public void llenarHorasExtrasMensuales() {
		//debe traer la lista de todos las horas extras mensuales y mostrarla
				
		assertTrue(true);
		
	}
}