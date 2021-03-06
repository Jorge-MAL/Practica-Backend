package apragma.practica.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Detalles de la ciudad")
public class DocumentoTipoDTO {

	@ApiModelProperty(notes = "El identificador ?nico del tipo de documento")
	private int id;

	@NotEmpty(message = "El nombre no debe ser vac?o")
	@ApiModelProperty(notes = "El nombre del tipo de documento")
	private String nombre;
}
