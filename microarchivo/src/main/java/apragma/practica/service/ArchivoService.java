package apragma.practica.service;

import java.util.List;

import apragma.practica.dto.ArchivoDTO;

public interface ArchivoService {

	ArchivoDTO findById(String id);

	void saveArchivo(ArchivoDTO nuevo);

	ArchivoDTO updateArchivo(ArchivoDTO nuevo);

	boolean deleteArchivoById(String id);

	List<ArchivoDTO> findAllArchivo();

	public boolean isArchivoExist(ArchivoDTO nuevo);
	
	List<ArchivoDTO> findByIdIn(List<String> ids);
	
}
