package cl.markov.proyecto.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
