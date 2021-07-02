package apragma.practica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import apragma.practica.entity.ArchivoEntity;

@Repository
public interface ArchivoRepository extends MongoRepository<ArchivoEntity, String> {

	List<ArchivoEntity> findByIdIn(List<String> ids);

}
