package apragma.practica;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import apragma.practica.entity.ArchivoEntity;
import apragma.practica.repository.ArchivoRepository;
import apragma.practica.serviceuse.ArchivoServiceUse;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ArchivoServiceMockTest {

	@InjectMocks
	private ArchivoServiceUse archivoServiceUse;

	@Mock
	private ArchivoRepository archivoRepository;

	@BeforeEach
	public void DatosBaseParaLosTest() {
		MockitoAnnotations.openMocks(this);
		ArchivoEntity archivoEntity1 = ArchivoEntity.builder().id("60d4c1fdaba981f736e01d7d").data("Mi fotoooo1")
				.tipo(".jpg").build();
		ArchivoEntity archivoEntity2 = ArchivoEntity.builder().id("60d4c1fdaba981f736e01d7e").data("Mi fotoooo2")
				.tipo(".jpg").build();
		List<ArchivoEntity> archivoEntityList = new ArrayList<>();
		archivoEntityList.add(archivoEntity1);
		archivoEntityList.add(archivoEntity2);
		List<String> IdsList = new ArrayList<>();
		IdsList.add("60d4c1fdaba981f736e01d7d");
		IdsList.add("60d4c1fdaba981f736e01d7e");
		Mockito.when(archivoRepository.findByIdIn(IdsList)).thenReturn(archivoEntityList);
	}

	@Test
	public void findByIdIn() {
		List<String> IdsList = new ArrayList<>();
		IdsList.add("60d4c1fdaba981f736e01d7d");
		IdsList.add("60d4c1fdaba981f736e01d7e");
		Assertions.assertThat(archivoServiceUse.findByIdIn(IdsList).size()).isEqualTo(2);
	}

}
