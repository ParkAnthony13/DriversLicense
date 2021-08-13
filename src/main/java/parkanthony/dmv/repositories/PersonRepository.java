package parkanthony.dmv.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import parkanthony.dmv.models.PersonModel;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, Long> {
	List<PersonModel> findAll();
}
