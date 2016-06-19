package at.fh.swenga.jpa.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.model.ActionModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.ResourceModel;

@Controller
public class RegisterController {

	@Autowired
	PlayerRepository playerRepository;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration() {
		System.out.println("register controller1");
		return "reg";
	}

	@RequestMapping(value = "/regProcess")
	public String registrationProcess(Model model, @RequestParam String username, @RequestParam String email,
			@RequestParam String password) {
		System.out.println("HELP");

		model.addAttribute("username", username);
		model.addAttribute("email", email);
		model.addAttribute("password", password);

		// Validation eher schlecht als recht
		if (username.isEmpty() || email.isEmpty() || password.isEmpty() == true) {
			model.addAttribute("errorMessage", "Please fill up all fields");

			return "regFail";
		} else if (password.length() + 1 < 6 || password.length() + 1 > 30 || username.length() > 20
				|| email.length() > 70) {
			model.addAttribute("errorMessage", "Please uses a correct length for yor input");
			return "regFail";
		} else if (email.contains("@") == false) {
			model.addAttribute("errorMessage", "Please enter a valid email address");
			return "regFail";
		} else if (username.matches("^[a-zA-Z0-9]+$") == false) {
			model.addAttribute("errorMessage", "Please dont use special characters in your username");
			return "regFail";
		}
		
		// überprüfen ob der Username schon vorhanden ist
		PlayerModel player = new PlayerModel();
		
		player.setUsername(username);
		player.setEmail(email);
		player.setPassword(password);
		
		ResourceModel resourses = new ResourceModel();
		resourses.setPlayer(player);
		resourses.setFood(100);
		resourses.setGold(4);
		resourses.setStone(645);
		resourses.setWood(57);
		resourses.setMilitaryUnits(44);
		
		player.setResources(resourses);
		
		
		ActionModel action = new ActionModel();
		action.setId(0);
		action.setTicksLeft(5);
		action.setType('b');
		action.setTypePropertyName("Tower1");
		player.addAction(action);
		

		System.out.println(player.toString());

			
		if (playerRepository.findByUsername(username) == null) {
	
			playerRepository.save(player); //speichern in die db
			return "regSuccess";
		} else {
			System.out.println("failed");
			model.addAttribute("errorMessage", "The username is already taken.");
			return "regFail";
		}

	}

}