package parkanthony.dmv.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import parkanthony.dmv.models.LicenseModel;
import parkanthony.dmv.models.PersonModel;
import parkanthony.dmv.services.LicenseService;
import parkanthony.dmv.services.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	
	
	public LicenseController(LicenseService licenseService,PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}

	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String addLicense (@RequestParam("person")Long person,
			@RequestParam("state") String state,
			@RequestParam("expirationDate") String date) throws ParseException {
		PersonModel one = personService.findItem(person);
		LicenseModel newLicense = new LicenseModel();
		System.out.println(date);
		Date exp = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		newLicense.setPerson(one);
		newLicense.setExpirationDate(exp);
		newLicense.setState(state);
		String numb = String.format("%06d", LicenseService.newLicenseNumber());
		newLicense.setNumber(numb);
		licenseService.createItem(newLicense);
		return "redirect:/persons/"+person;
	}
}
