package entity;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Receta {
    private int idReceta;
    private String nombrePaciente;
    private String nombreMedicamento;
    private String dosis;
    private String frecuencia;
    private int duracion;
    private LocalDate fechaEmision;
    private String indicaciones;
    private TipoReceta tipoReceta;
}