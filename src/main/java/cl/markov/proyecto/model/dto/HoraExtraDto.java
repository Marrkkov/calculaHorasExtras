package cl.markov.proyecto.model.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.markov.proyecto.model.entity.HoraExtra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Data

public class HoraExtraDto {
    private HoraExtra horas;
    private List<HoraExtra> horasExtas;
}