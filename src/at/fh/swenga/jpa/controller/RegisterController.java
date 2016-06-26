package at.fh.swenga.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.BuildingRepository;
import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.dao.PlayerRoleRepository;
import at.fh.swenga.jpa.dao.RecruitRepository;
import at.fh.swenga.jpa.model.BuildingModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.PlayerRole;
import at.fh.swenga.jpa.model.RecruitModel;

@Controller
public class RegisterController {

	@Autowired
	RecruitRepository recruitRepository;

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	PlayerRoleRepository playerRoleRepository;
	
	@Autowired
	BuildingRepository buildingRepository;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration() {
		return "reg";
	}
	//COMMIT  KOMMI  WOOOOOHOHOOOO
	@RequestMapping(value = "/regProcess")
	public String registrationProcess(Model model, @RequestParam String username, @RequestParam String email,
			@RequestParam String password) {
		username = username.trim();
		email = email.trim();
		List<RecruitModel> units = setUnits();
		
		// initialisieren des Admin accounts und der kaufbaren Gebäude Username: Admin password: admin
		if (playerRepository.findByUsername("admin") == null) {

			PlayerModel admin = new PlayerModel();
			List<RecruitModel> adminList = setUnits();
			admin.setUsername("admin");
			admin.setEmail("economia@support.at");
			admin.setPassword("admin");
			System.out.println("SETTING UP ADMIN");
			for (RecruitModel unit : adminList) {
				unit.setPlayer(admin);
			}
			PlayerRole adminRole = new PlayerRole(admin,"ROLE_ADMIN");
			
			admin.setWood(100000);
			admin.setFood(100000);
			admin.setStone(100000);
			admin.setGold(100000);
			
			//gebäude hinzufügen mithilfe von zufallsgenerator
			DataFactory df = new DataFactory();

			BuildingModel building1 = new BuildingModel("Barack", "images/buildings/building1.png", 10 , 5, 0, 0, 2, 0, 0, 0);			
			building1.setPlayer(admin);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
			admin.addBuilding(building1);
		
			BuildingModel building2 = new BuildingModel("Snipa", "images/buildings/building2.png",  20 , 50, 10, 0, 0, 2, 0, 0);	
			building2.setPlayer(admin);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
			admin.addBuilding(building2);
			
			BuildingModel building3 = new BuildingModel("Pr0house", "images/buildings/building3.png",  400 , 500, 0, 0, 0, 0, 20, 0);			
			building3.setPlayer(admin);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
			admin.addBuilding(building3);
			
			BuildingModel building4 = new BuildingModel("HorseHouse", "images/buildings/building4.png",  1000 , 500, 100, 0, 2, 3, 0, 0);	
			building4.setPlayer(admin);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
			admin.addBuilding(building4);
			
			BuildingModel building5 = new BuildingModel("Castle", "images/buildings/building5.png",  10000 , 800, 300, 0, 2, 2, 2, 0);	
			building5.setPlayer(admin);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
			admin.addBuilding(building5);
			
			BuildingModel building6 = new BuildingModel("Rrolf Tower", "images/buildings/building7.png",  30000 , 800, 300, 100, 10, 10, 10, 1);	
			building6.setPlayer(admin);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
			admin.addBuilding(building6);
			
			BuildingModel building7 = new BuildingModel("Schn. Castle", "images/buildings/building6.png",  20000 , 10000, 0, 1000, 2, 0, 0, 2);	
			building7.setPlayer(admin);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
			admin.addBuilding(building7);
			
			BuildingModel building8 = new BuildingModel("Hasen. Castle", "images/buildings/building8.png",  100000 , 50000, 0, 5000, 0, 2, 0, 3);	
			building8.setPlayer(admin);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
			admin.addBuilding(building8);
			
			
			playerRepository.save(admin);
			recruitRepository.save(adminList);
			playerRoleRepository.save(adminRole);
			
			buildingRepository.save(building1);  
			buildingRepository.save(building2); 
			buildingRepository.save(building3); 
			buildingRepository.save(building4); 
			buildingRepository.save(building5); 
			buildingRepository.save(building6); 
			buildingRepository.save(building7); 
			buildingRepository.save(building8); 

		
		}

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
		} else if (username == "admin") {
			model.addAttribute("errorMessage",
					"Your username \"admin\" is invalid. There already exists an Admin with that username. Nice try tho :^)");
			return "regFail";
		}
		
		// überprüfen ob der Username schon vorhanden ist
		if (playerRepository.findByUsername(username) == null) {
			PlayerModel player = new PlayerModel();
			model.addAttribute("username", username);
			model.addAttribute("email", email);
			List<RecruitModel> playerList = setUnits();
			player.setUsername(username);
			player.setEmail(email);
			player.setPassword(password);
			
			PlayerRole playerRole = new PlayerRole(player,"ROLE_USER");
			// for (RecruitModel unit : playerList) {
			// unit.setPlayer(player);
			// if(unit.getUnitID()==2){
			// unit.setCount(5);
			// }
			// }
	
			System.out.println("SETTING UP Player");
			
			System.out.println(player.toString());
			playerRepository.save(player);
			playerRoleRepository.save(playerRole);
			recruitRepository.save(playerList);// speichern in die db
			return "regSuccess";
		} else {
			System.out.println("failed");
			model.addAttribute("errorMessage", "The username is already taken.");
			return "regFail";
		}

	}

	public List<RecruitModel> setUnits() {

		List<RecruitModel> units = new ArrayList<RecruitModel>();
		// footman unit
		RecruitModel footman = new RecruitModel();
		footman.setUnitID(1);
		footman.setName("Footman");
		footman.setIcon("images/units/footman.png");
		footman.setSize("width:31px;height:45px;");
		footman.setAttackPower(3);
		footman.setDeffPower(1);
		footman.setAccuracy(90);
		footman.setCount(0);
		footman.setNeededGold(50);
		footman.setNeededFood(1);
		footman.setNeededStone(200);
		footman.setNeededWood(100);
		footman.setNeededBuilding("");
		// archer unit
		RecruitModel archer = new RecruitModel();
		archer.setUnitID(2);
		archer.setName("Archer");
		archer.setIcon("images/units/archer.png");
		archer.setSize("width:41px;height:42px;");
		archer.setAttackPower(1);
		archer.setDeffPower(3);
		archer.setAccuracy(80);
		archer.setCount(0);
		archer.setNeededGold(50);
		archer.setNeededFood(1);
		archer.setNeededStone(100);
		archer.setNeededWood(200);
		archer.setNeededBuilding("");
		// 2-Handed
		RecruitModel twoHanded = new RecruitModel();
		twoHanded.setUnitID(3);
		twoHanded.setName("2-Handed");
		twoHanded.setIcon("images/units/2-handed.png");
		twoHanded.setSize("width:22px;height:93px;");
		twoHanded.setAttackPower(15);
		twoHanded.setDeffPower(5);
		twoHanded.setAccuracy(75);
		twoHanded.setCount(0);
		twoHanded.setNeededGold(250);
		twoHanded.setNeededFood(2);
		twoHanded.setNeededStone(1000);
		twoHanded.setNeededWood(500);
		twoHanded.setNeededBuilding("");
		// Knights
		RecruitModel knight = new RecruitModel();
		knight.setUnitID(4);
		knight.setName("Knight");
		knight.setIcon("images/units/knight.png");
		knight.setSize("width:40px;height:45px;");
		knight.setAttackPower(15);
		knight.setDeffPower(15);
		knight.setAccuracy(60);
		knight.setCount(0);
		knight.setNeededGold(400);
		knight.setNeededFood(4);
		knight.setNeededStone(1000);
		knight.setNeededWood(1000);
		knight.setNeededBuilding("");
		// Long-bow Archer
		RecruitModel longbowArcher = new RecruitModel();
		longbowArcher.setUnitID(5);
		longbowArcher.setName("Longbow Archer");
		longbowArcher.setIcon("images/units/longbow-archer.png");
		longbowArcher.setSize("width:53px;height:54px;");
		longbowArcher.setAttackPower(5);
		longbowArcher.setDeffPower(15);
		longbowArcher.setAccuracy(95);
		longbowArcher.setCount(0);
		longbowArcher.setNeededGold(250);
		longbowArcher.setNeededFood(2);
		longbowArcher.setNeededStone(500);
		longbowArcher.setNeededWood(1000);
		longbowArcher.setNeededBuilding("");

		units.add(footman);
		units.add(archer);
		units.add(twoHanded);
		units.add(knight);
		units.add(longbowArcher);
		return units;

	}

}