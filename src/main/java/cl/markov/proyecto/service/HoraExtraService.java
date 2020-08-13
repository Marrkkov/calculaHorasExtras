package cl.markov.proyecto.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.markov.proyecto.model.dao.HoraExtraDao;
import cl.markov.proyecto.model.dto.HorasRutDto;
import cl.markov.proyecto.model.entity.HoraExtra;
import cl.markov.proyecto.model.entity.Usuario;


@Service
public class HoraExtraService {
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private HoraExtraDao dao;

	public HoraExtra agregarHoraExtra(HorasRutDto horasRutDto, Usuario usuario) {

		HoraExtra	horaEnBase = dao.findByFecha(horasRutDto.getFecha()).orElse(null);
		
		
		if (horaEnBase != null) {
			logger.warn("El registro del dia que desea ingresar ya existe");
		} else {
		        HoraExtra respuesta = new HoraExtra();
		        respuesta.setFecha(horasRutDto.getFecha());
		        respuesta.setHoraEntrada(horasRutDto.getHoraEntrada());
		        respuesta.setHoraSalida(horasRutDto.getHoraSalida());
		        respuesta.setHorasExtras(horasRutDto.getHorasExtras());
		        respuesta.setUsuario(usuario);
		    
		        return dao.save(respuesta);
		}
		return null;
	} 
	
	public List<HoraExtra> llenarHorasExtras () {
			
		return dao.findAll();
		
	}
	
	public HoraExtra buscar(Integer id) {
		return dao.findById(id).orElse(null);
	}
	
	public HoraExtra modificarHora(HoraExtra horaExtra) {

		return dao.save(horaExtra);
	}
}
