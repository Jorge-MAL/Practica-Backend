package apragma.practica.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apragma.practica.dto.PersonaDTO;
import apragma.practica.service.PersonaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping(value = "/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping(value = "/")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Todo bien"),
			@ApiResponse(code = 401, message = "No autorizado el acceso"),
			@ApiResponse(code = 403, message = "Prohibido el acceso"),
			@ApiResponse(code = 404, message = "No encontrado") })
	@ApiOperation(value = "Lista de todas las personas", notes = "Proporciona una lista de personas de la base de datos")
	public ResponseEntity<List<PersonaDTO>> ListaDePersonas() {
		return new ResponseEntity<List<PersonaDTO>>(personaService.findAllPersona(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Todo bien"),
			@ApiResponse(code = 401, message = "No autorizado el acceso"),
			@ApiResponse(code = 403, message = "Prohibido el acceso"),
			@ApiResponse(code = 404, message = "No encontrado") })
	@ApiOperation(value = "Busca una persona por identificador(id)", notes = "Porpocionar un identificador(id) para encontrar la persona a la que corresponde", response = PersonaDTO.class)
	public ResponseEntity<PersonaDTO> BuscarPersona(
			@ApiParam(value = "Identificador de la persona", required = true) @PathVariable("id") int id) {
		return new ResponseEntity<PersonaDTO>(personaService.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/{idTipoDeDocumento}/{numeroDeDocumento}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Todo bien"),
			@ApiResponse(code = 401, message = "No autorizado el acceso"),
			@ApiResponse(code = 403, message = "Prohibido el acceso"),
			@ApiResponse(code = 404, message = "No encontrado") })
	@ApiOperation(value = "Busca una persona por id del tipo de docuemnto y n?mero de documento", notes = "Porpocionar un id del tipo de docuemnto y n?mero de documento para encontrar la persona a la que corresponde", response = PersonaDTO.class)
	public ResponseEntity<PersonaDTO> BuscarPersona(
			@ApiParam(value = "Id del Tipo de documento", required = true) @PathVariable("idTipoDeDocumento") int idTipoDeDocumento,
			@ApiParam(value = "N?mero de documento", required = true) @PathVariable("numeroDeDocumento") String numeroDeDocumento) {
		return new ResponseEntity<PersonaDTO>(
				personaService.findByDocumentotipoAndDocumentonumero(idTipoDeDocumento, numeroDeDocumento),
				HttpStatus.OK);
	}

	@GetMapping(value = "/Edad/{edad}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Todo bien"),
			@ApiResponse(code = 401, message = "No autorizado el acceso"),
			@ApiResponse(code = 403, message = "Prohibido el acceso"),
			@ApiResponse(code = 404, message = "No encontrado") })
	@ApiOperation(value = "Lista de personas mayores o iguales a la edad", notes = "Porpocionar una edad para obtener una lista las personas mayores o iguales a la edad", response = PersonaDTO.class)
	public ResponseEntity<List<PersonaDTO>> BuscarPersonaa(
			@ApiParam(value = "Edad para la condici?n", required = true) @PathVariable("edad") int edad) {
		return new ResponseEntity<List<PersonaDTO>>(personaService.findByEdadGreaterThanEqual(edad), HttpStatus.OK);
	}

	@PostMapping(value = "/")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Todo bien"),
			@ApiResponse(code = 201, message = "Creado"), @ApiResponse(code = 401, message = "No autorizado el acceso"),
			@ApiResponse(code = 403, message = "Prohibido el acceso"),
			@ApiResponse(code = 404, message = "No encontrado") })
	@ApiOperation(value = "Crear una persona", notes = "Porpocionar los datos necesarios para crear una persona")
	public ResponseEntity<Void> CrearPersona(
			@ApiParam(value = "Un JSON de persona", required = true) @Valid @RequestBody PersonaDTO persona)
			throws IOException {
		personaService.savePersona(persona);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Todo bien"),
			@ApiResponse(code = 201, message = "Creado"), @ApiResponse(code = 401, message = "No autorizado el acceso"),
			@ApiResponse(code = 403, message = "Prohibido el acceso"),
			@ApiResponse(code = 404, message = "No encontrado") })
	@ApiOperation(value = "Actualizar una persona", notes = "Porpocionar el identificador(id) y dem?s datos necesarios para actualizar una persona")
	public ResponseEntity<Void> ActualizarPersona(
			@ApiParam(value = "Un JSON de persona", required = true) @RequestBody PersonaDTO persona) {
		personaService.updatePersona(persona);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Todo bien"),
			@ApiResponse(code = 204, message = "Sin contenido"),
			@ApiResponse(code = 401, message = "No autorizado el acceso"),
			@ApiResponse(code = 403, message = "Prohibido el acceso") })
	@ApiOperation(value = "Elimina una persona por identificador(id)", notes = "Porpocionar el identificador(id) para eliminar una persona")
	public ResponseEntity<Void> EliminarPersona(
			@ApiParam(value = "Identificador de la persona", required = true) @PathVariable("id") int id) {
		personaService.deletePersonaById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
