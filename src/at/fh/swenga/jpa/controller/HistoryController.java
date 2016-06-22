package at.fh.swenga.jpa.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import at.fh.swenga.jpa.dao.HistoryRepository;
import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.model.HistoryModel;
import at.fh.swenga.jpa.model.PlayerModel;

@Controller
@Transactional
public class HistoryController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	@Transactional
	  public String handleHistory(Model model, Principal principal ) {
		 
		
	      String name = principal.getName(); //get logged in username
	      PlayerModel player = playerRepository.findByUsername(name);
	      model.addAttribute("player", player);
	      
		  List<HistoryModel> newHistory = historyRepository.findByPlayerUsername(name);
	      model.addAttribute("historys", newHistory);
	      
	     
		return "history";
	}
	
	

}


