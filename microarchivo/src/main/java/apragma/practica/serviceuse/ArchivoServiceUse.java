package apragma.practica.serviceuse;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;

import apragma.practica.entity.ArchivoEntity;
import apragma.practica.exception.ErrorException;
import apragma.practica.dto.ArchivoDTO;
import apragma.practica.repository.ArchivoRepository;
import apragma.practica.service.*;

@Service
public class ArchivoServiceUse implements ArchivoService {

	@Autowired
	ArchivoRepository archivoRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly = true)
	public ArchivoDTO findById(String id) {
		// TODO Auto-generated method stub
		Optional<ArchivoEntity> archivoEntity = archivoRepository.findById(id);
		if (archivoEntity.isPresent()) {
			return modelMapper.map(archivoEntity.get(), ArchivoDTO.class);
		} else {
			throw new ErrorException(HttpStatus.NOT_FOUND, "No existe el archivo");
		}
	}

	@Override
	@Transactional
	public void saveArchivo(ArchivoDTO nuevo) {
		// TODO Auto-generated method stub
		if (archivoRepository.existsById(nuevo.getId())) {
			throw new ErrorException(HttpStatus.CONFLICT, "Ya existe el archivo");
		} else {
			archivoRepository.save(modelMapper.map(nuevo, ArchivoEntity.class));
		}
	}

	@Override
	@Transactional
	public ArchivoDTO updateArchivo(ArchivoDTO nuevo) {
		// TODO Auto-generated method stub
		if (archivoRepository.existsById(nuevo.getId())) {
			archivoRepository.save(modelMapper.map(nuevo, ArchivoEntity.class));
			return nuevo;
		} else {
			throw new ErrorException(HttpStatus.NOT_FOUND, "No existe el archivo");
		}
	}

	@Override
	@Transactional
	public boolean deleteArchivoById(String id) {
		// TODO Auto-generated method stub
		if (archivoRepository.existsById(id)) {
			archivoRepository.deleteById(id);
			return true;
		} else {
			throw new ErrorException(HttpStatus.NOT_FOUND, "No existe el archivo");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArchivoDTO> findAllArchivo() {
		// TODO Auto-generated method stub
		List<ArchivoDTO> archivosDTOList = null;
		List<ArchivoEntity> archivosEntityList = archivoRepository.findAll();
		if (archivosEntityList.isEmpty()) {
			throw new ErrorException(HttpStatus.NO_CONTENT, "No existen archivos");
		} else {
			archivosDTOList = modelMapper.map(archivosEntityList, new TypeToken<List<ArchivoDTO>>() {
			}.getType());
		}
		return archivosDTOList;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isArchivoExist(ArchivoDTO nuevo) {
		// TODO Auto-generated method stub
		return archivoRepository.existsById(nuevo.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArchivoDTO> findByIdIn(List<String> ids) {
		// TODO Auto-generated method stub
		List<ArchivoDTO> archivosDTOList = null;
		List<ArchivoEntity> archivosEntityList = archivoRepository.findByIdIn(ids);
		if (archivosEntityList.isEmpty()) {
			throw new ErrorException(HttpStatus.NO_CONTENT, "No existen archivos");
		} else {
			archivosDTOList = modelMapper.map(archivosEntityList, new TypeToken<List<ArchivoDTO>>() {
			}.getType());
		}
		return archivosDTOList;
	}

}
