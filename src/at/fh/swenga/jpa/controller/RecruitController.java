package at.fh.swenga.jpa.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.HistoryRepository;
import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.dao.RecruitRepository;
import at.fh.swenga.jpa.model.HistoryModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.RecruitModel;

@Controller
public class RecruitController {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	RecruitRepository recruitRepository;
	
	@Autowired
	HistoryRepository historyRepository;

	@RequestMapping(value = "/recruits", method = RequestMethod.GET)
	public String handleRecruits(Model model, Principal principal) {
		System.out.print("Hey");

		String name = principal.getName(); // get logged in username
		System.out.println(name);
		PlayerModel player = playerRepository.findByUsername(name);
		model.addAttribute("player", player);

		model.addAttribute("recruits", recruitRepository.findByPlayerUsername(name));

		return "recruits";

	}

	// COMMIT-COMMENT YOLO
	@RequestMapping(value = "/submitrecruits", method = RequestMethod.GET)
	@Transactional
	public String submitRecruits(Model model, Principal principal, @RequestParam int addUnit1,
			@RequestParam int addUnit2, @RequestParam int addUnit3, @RequestParam int addUnit4,
			@RequestParam int addUnit5) {
		String name = principal.getName();
		// String name = "user";
		PlayerModel player = playerRepository.findByUsername(name);
		List<RecruitModel> recruits = recruitRepository.findByPlayerUsername(name);

		boolean notEnoughRes = false;
		for (RecruitModel recruit : recruits) {
			System.out.println(recruit.getUnitID());
			switch (recruit.getUnitID()) {

			case 1:
				notEnoughRes = calcRessCosts(recruit, player, model, addUnit1);
				break;
			case 2:
				notEnoughRes = calcRessCosts(recruit, player, model, addUnit2);
				break;
			case 3:
				notEnoughRes = calcRessCosts(recruit, player, model, addUnit3);
				break;
			case 4:
				notEnoughRes = calcRessCosts(recruit, player, model, addUnit4);
				break;
			case 5:
				notEnoughRes = calcRessCosts(recruit, player, model, addUnit5);
				break;
			default:
				System.out.println("SMTH WENT WRONG  PLS DO NOT HACK US :((((");
				notEnoughRes = true;
				break;
			}
			if(notEnoughRes)break;
		}
		model.addAttribute("player", player);
		model.addAttribute("recruits", recruits);
		
		//history adden
	      String historyMsg = "You bought some recruits!";
	      player = addHistoryEntry(player,historyMsg,"recruits");
		
		recruitRepository.save(recruits);
		playerRepository.save(player);
		return "recruits";
	}

	public boolean calcRessCosts(RecruitModel recruit, PlayerModel player, Model model, int addUnit) {
		System.out.println(addUnit);
		if (recruit.getNeededGold() * addUnit <= player.getGold()
				&& recruit.getNeededStone() * addUnit <= player.getStone()
				&& recruit.getNeededFood() * addUnit <= player.getFood()
				&& recruit.getNeededWood() * addUnit <= player.getWood()) {
			System.out.println("GENUG RESS");
			// Units setzen
			int i = 0;
			int ressGold = 0;
			int ressWood = 0;
			int ressFood = 0;
			int ressStone = 0;
			i = recruit.getCount() + addUnit;
			recruit.setCount(i);
			// Rohstoffkosten berechnen
			ressFood = recruit.getNeededFood() * addUnit;
			ressGold = recruit.getNeededGold() * addUnit;
			ressStone = recruit.getNeededStone() * addUnit;
			ressWood = recruit.getNeededWood() * addUnit;

			player.setGold(player.getGold() - ressGold);
			player.setFood(player.getFood() - ressFood);
			player.setStone(player.getStone() - ressStone);
			player.setWood(player.getWood() - ressWood);
			model.addAttribute("errorRess", null);
			model.addAttribute("success", "units build");
			return false;

		} else {

			// FEHLER
			model.addAttribute("errorRess", "To less ressources to recruit desired Units");
			model.addAttribute("success", null);
			return true;
		}

	}
	
	@Transactional
	private PlayerModel addHistoryEntry (PlayerModel player, String message, String type){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df; 
        df = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");     // 31.01.2016 20:07
		
		HistoryModel history = new HistoryModel(); 
		history.setPlayer(player);
		history.setInfo(message);
		history.setType(type);
		history.setDate(now.format(df));
		//Date date
		player.addHistory(history);
		historyRepository.save(history);
		return player;
	}

}
