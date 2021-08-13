package parkanthony.dmv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.dmv.models.PersonModel;
import parkanthony.dmv.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	public List<PersonModel> allItems() {
		return personRepository.findAll();
	}
	public PersonModel createItem(PersonModel b) {
		return personRepository.save(b);
	}
	public PersonModel findItem(Long id) {
		Optional<PersonModel> optionalItem = personRepository.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else {
			return null;
		}
	}
}
