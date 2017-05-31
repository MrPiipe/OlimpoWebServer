package co.edu.eafit.dis.olimpo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eafit.dis.olimpo.entity.LoginInformation;
import co.edu.eafit.dis.olimpo.repository.LoginRepository;

@RestController
public class LoginController {
	
	@Autowired
	private LoginRepository loginRepo;
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public LoginInformation saveArtist(@RequestBody LoginInformation login) {
		return loginRepo.insert(login);
	}
}
