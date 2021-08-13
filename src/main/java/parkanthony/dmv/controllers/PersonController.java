package parkanthony.dmv.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import parkanthony.dmv.models.PersonModel;
import parkanthony.dmv.services.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	@RequestMapping("/")
	public String index() {
		return "redirect:/persons/new";
	}
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") PersonModel person,Model model) {
		List<PersonModel> persons = personService.allItems();
		model.addAttribute("persons",persons);
		return "/dmv/new.jsp";
	}
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") PersonModel person, BindingResult result) {
		if (result.hasErrors()) {
			return "/persons/new.jsp";
		} else {
			personService.createItem(person);
			return "redirect:/persons/new";
		}
	}
	@RequestMapping("/licenses/new")
	public String newLicense(Model model) {
		List<PersonModel> persons = personService.allItems();
		model.addAttribute("persons",persons);
		return "/dmv/newLicense.jsp";
	}
	@RequestMapping("/persons/{id}")
	public String displayPersonAndLicense(Model model,@PathVariable("id")Long id) {
		PersonModel onTheGridPerson = personService.findItem(id);
		model.addAttribute("person",onTheGridPerson);
		return "/dmv/show.jsp";
	}
	
}
