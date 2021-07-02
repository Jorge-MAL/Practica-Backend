package apragma.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import apragma.practica.client.ArchivoClient;
import apragma.practica.dto.ArchivoDTO;
import apragma.practica.dto.PersonaDTO;
import apragma.practica.entity.CiudadEntity;
import apragma.practica.entity.DocumentoTipoEntity;
import apragma.practica.entity.PersonaEntity;
import apragma.practica.repository.PersonaRepository;
import apragma.practica.service.use.PersonaServiceUse;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PersonaServiceMockTest {

	@InjectMocks
	PersonaServiceUse personaServiceUse;

	@Mock
	PersonaRepository personaRepository;

	@Mock
	ArchivoClient archivoClient;

	@BeforeAll
	public void DatosBaseParaLosTest() {
		MockitoAnnotations.openMocks(this);
		
		DocumentoTipoEntity documentoTipoEntity = DocumentoTipoEntity.builder().id(1).build();
		CiudadEntity ciudadEntity = CiudadEntity.builder().id(1).nombre("CC").build();
		PersonaEntity personaEntity1 = PersonaEntity.builder().id(11).nombres("Jorge").apellidos("Anaya")
				.documentotipo(documentoTipoEntity).documentonumero("12312").edad(10).ciudadnacimiento(ciudadEntity)
				.idfoto("60d4c1fdaba981f736e01d7d").build();
		PersonaEntity personaEntity2 = PersonaEntity.builder().id(22).nombres("Jorge2").apellidos("Anaya2")
				.documentotipo(documentoTipoEntity).documentonumero("12412").edad(20).ciudadnacimiento(ciudadEntity)
				.idfoto("60d4c1fdaba981f736e01d7e").build();

		List<PersonaEntity> personaEntityList = new ArrayList<PersonaEntity>();
		personaEntityList.add(personaEntity1);
		personaEntityList.add(personaEntity2);

		List<String> idsStringList = new ArrayList<>();
		idsStringList.add("60d4c1fdaba981f736e01d7d");
		idsStringList.add("60d4c1fdaba981f736e01d7e");

		ArchivoDTO archivoDTO1 = ArchivoDTO.builder().id("60d4c1fdaba981f736e01d7d").data("Mi foto3").tipo(".jpg")
				.build();
		ArchivoDTO archivoDTO2 = ArchivoDTO.builder().id("60d4c1fdaba981f736e01d7e").data("Mi foto4").tipo(".jpg")
				.build();

		List<ArchivoDTO> archivoDTOList = new ArrayList<ArchivoDTO>();
		archivoDTOList.add(archivoDTO1);
		archivoDTOList.add(archivoDTO2);

		Mockito.when(personaRepository.findByEdadGreaterThanEqual(5)).thenReturn(personaEntityList);
		Mockito.when(personaRepository.findByDocumentotipoAndDocumentonumero(documentoTipoEntity, "12312"))
				.thenReturn(Optional.of(personaEntity1));
		
		Mockito.when(archivoClient.BuscarArchivo("60d4c1fdaba981f736e01d7d"))
				.thenReturn((ResponseEntity<ArchivoDTO>) ResponseEntity.ok(archivoDTO1));
		Mockito.when(archivoClient.ListaDeArchivosIds(idsStringList))
				.thenReturn((ResponseEntity<List<ArchivoDTO>>) ResponseEntity.ok(archivoDTOList));
	}

	@Test
	public void findByDocumentotipoAndDocumentonumero() {
//		Como buenas practicas debería estar en cada @ Test lo siguente: dado esto -- cuando esto -- entonces esto
		PersonaDTO personaDTO = personaServiceUse.findByDocumentotipoAndDocumentonumero(1, "12312");
		Assertions.assertThat(personaDTO.getNombres()).isEqualTo("Jorge");
	}

	@Test
	public void findByEdadGreaterThanEqual() {
//		Como buenas practicas debería estar en cada @ Test lo siguente: dado esto -- cuando esto -- entonces esto
		List<PersonaDTO> personaDTOList = personaServiceUse.findByEdadGreaterThanEqual(5);
		Assertions.assertThat(personaDTOList.size()).isEqualTo(2);
	}

}
