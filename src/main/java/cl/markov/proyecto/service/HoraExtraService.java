package cl.markov.proyecto.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.markov.proyecto.model.dao.HoraExtraDao;
import cl.markov.proyecto.model.entity.HoraExtra;


@Service
public class HoraExtraService {
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private HoraExtraDao dao;

	public HoraExtra agregarHoraExtra(HoraExtra horaExtra) {

		HoraExtra horaEnBase = dao.findByFecha(horaExtra.getFecha()).orElse(null);

		if (horaEnBase != null) {

			logger.warn("El registro del dia que desea ingresar ya existe");
		} else {

			dao.save(horaExtra);
		}

		return horaExtra;
	}
	
	public List<HoraExtra> cargarHorasExtras () {
			
		return dao.findAll();
		
	}
	
	public HoraExtra buscar(Integer id) {
		return dao.findById(id).orElse(null);
	}
	
	public HoraExtra modificarHora(HoraExtra horaExtra) {

		return dao.save(horaExtra);
	}
}
