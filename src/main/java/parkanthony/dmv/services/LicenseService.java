package parkanthony.dmv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.dmv.models.LicenseModel;
import parkanthony.dmv.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	private static Long licenseNumber = (long) 0;
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	public List<LicenseModel> allItems(){
		return licenseRepository.findAll();
	}
	public LicenseModel createItem(LicenseModel b) {
		return licenseRepository.save(b);
	}
	public LicenseModel findItem(Long id) {
		Optional<LicenseModel> optionalItem = licenseRepository.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else {
			return null;
		}
	}
	public static Long newLicenseNumber() {
		LicenseService.setLicenseNumber(LicenseService.getLicenseNumber()+(long) 1);
		return LicenseService.getLicenseNumber();
	}
	public static Long getLicenseNumber() {
		return licenseNumber;
	}
	public static void setLicenseNumber(Long licenseNumber) {
		LicenseService.licenseNumber = licenseNumber;
	}
	
	
}
