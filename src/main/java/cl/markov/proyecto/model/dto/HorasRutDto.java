package cl.markov.proyecto.model.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import cl.markov.proyecto.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Entity
public class HorasRutDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter @Getter private Integer id;
	@Setter @Getter private String fecha;
	@Setter @Getter private String rut;
	@Setter @Getter private String horaEntrada;
	@Setter @Getter private String horaSalida;
	@Setter @Getter private String horasExtras;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@Setter @Getter private Usuario usuario;
	
	
}