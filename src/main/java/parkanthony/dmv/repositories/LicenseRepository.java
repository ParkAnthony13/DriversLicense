package parkanthony.dmv.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import parkanthony.dmv.models.LicenseModel;

@Repository
public interface LicenseRepository extends CrudRepository<LicenseModel, Long> {
	List<LicenseModel> findAll();
}
