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
public class CiudadDTO {

	@ApiModelProperty(notes = "El identificador único de la ciudad")
	private int id;

	@NotEmpty(message = "El nombre no debe ser vacío")
	@ApiModelProperty(notes = "El nombre de la ciudad")
	private String nombre;

}
