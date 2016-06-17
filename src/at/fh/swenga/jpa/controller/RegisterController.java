package at.fh.swenga.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import at.fh.swenga.jpa.model.PlayerModel;

@Controller

public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration() {

		return "reg";
	}

	@RequestMapping(value = "/processRegistration", method = RequestMethod.GET)
	public String processRegistration(WebRequest request, PlayerModel model) {
		System.out.println("-------------------------------------------------------");
		try {
			// PlayerModel user = new PlayerModel();
			// model.addAttribute
			// Id soll generiert werden
			// erstellen eines neuen DB eintrages mit Namen,Email, Password
			System.out.println("-------------------------------------------------------");
//			System.out.println(username+email+password);
			return "regSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "regFail";
		}

	}

}