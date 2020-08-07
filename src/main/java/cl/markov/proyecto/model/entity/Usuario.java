package cl.markov.proyecto.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.markov.proyecto.config.EncoderUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter @Getter private Integer id;
	@Setter @Getter private String nombre;
	@Setter @Getter private String rut;
	@Setter @Getter private String correo;
	@Getter private String contrasenia;
	@Setter @Getter private Rol rol;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
	@Setter @Getter private List<HoraExtra> horasExtras = new ArrayList<>();

	public void setContrasenia(String contrasenia) {
		this.contrasenia = EncoderUtils.passwordEncoder().encode(contrasenia);
	}
	
	public Usuario agregarHoraExtra(HoraExtra horaExtra) {		
		this.horasExtras.add(horaExtra);
		
		return this;
	}
	
	 public String toJson() {
	        Usuario aux = new Usuario(id, nombre, rut, correo, contrasenia, rol, horasExtras);
	        ObjectMapper mapper = new ObjectMapper();
	        String jsonString = null;
	        try {
	            jsonString = mapper.writeValueAsString(aux);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
	        
	        return jsonString;
	    }
}
