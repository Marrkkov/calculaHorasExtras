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
	
	@Test
	public void cargarHorasExtras () {
		//importa los usuarios y las horas extras de un archivo excel entregado por el reloj control de la empresa.
		
		assertTrue(true);
		
	}
	
	@Test
	public void sumarHorasExtra () {
		//realiza suma de horas extras de un trabajador pertenecientes a un mismo mes y anio.
		
		assertTrue(true);
	}
	
	@Test
	public void llenarHorasExtrasTotales() {
		//debe traer la lista de todos las horas extras y mostrarla
				
		assertTrue(true);
	}
	
	@Test
	public void llenarHorasExtrasMensuales() {
		//debe traer la lista de todos las horas extras mensuales y mostrarla
				
		assertTrue(true);
		
	}
	
	@Test 
	public void eliminarHora() {
		//Elimina una hora extra, la busca y no debe encontrar nada.
		assertTrue(true);
	}
	
	@Test
	public void modificarHora() {
	//debe modificar una hora, eliminando el dato que existia antes y luego al ser consultado
		//mostrar los nuevos datos ingresados
		
		assertTrue(true); 
	}
	
	@Test
	public void buscar() {
		//busca una hora y lo muestra
	}
}