package apragma.practica.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
@ApiModel(description = "Detalles de la persona")
public class PersonaDTO {
	
	@ApiModelProperty(notes = "El identificador único de la persona")
	private int id;

	@NotEmpty(message = "Los nombres no deben ser vacío")
	@ApiModelProperty(notes = "El nombre de la persona")
	private String nombres;

	@NotEmpty(message = "Los apellidos no deben ser vacío")
	@ApiModelProperty(notes = "El apellido de la persona")
	private String apellidos;

	@NotNull(message = "El tipo de documento no debe ser vacío")
	@ApiModelProperty(notes = "El tipo de documento de la persona")
	private DocumentoTipoDTO documentotipo;

	@NotEmpty(message = "El número de documento no debe ser vacío")
	@ApiModelProperty(notes = "El número de documento de la persona")
	private String documentonumero;

	@Positive(message = "La edad debe ser mayor a cero")
	@ApiModelProperty(notes = "La edad de la persona")
	private int edad;

	@NotNull(message = "La ciudad de nacimiento no debe ser vacía")
	@ApiModelProperty(notes = "La ciudad de nacimeinto de la persona")
	private CiudadDTO ciudadnacimiento;

	@NotNull(message = "La foto no debe ser vacía")
	@ApiModelProperty(notes = "La foto de la persona")
	private ArchivoDTO foto;

}
