package cl.markov.proyecto.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class HoraExtra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter @Getter private Integer id;
	@Setter @Getter private String fecha;
	@Setter @Getter private String horaEntrada;
	@Setter @Getter private String horaSalida;
	@Setter @Getter private String horasExtras;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@Setter @Getter private Usuario usuario;
	
	 public String toJson() {
	        HoraExtra aux = new HoraExtra(id, fecha, horaEntrada, horaSalida, horasExtras, usuario);
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
