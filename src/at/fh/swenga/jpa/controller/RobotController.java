package at.fh.swenga.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.CompanyRepository;
import at.fh.swenga.jpa.dao.RobotRepository;
import at.fh.swenga.jpa.model.CompanyModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.RobotModel;

@Controller
public class RobotController {

	@Autowired
	RobotRepository robotRepository;

	@Autowired
	CompanyRepository companyRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String handleLogin() {
	    return "login";
	  }


	@RequestMapping(value = { "/", "list" })
	public String index(Model model) {
		List<RobotModel> robots = robotRepository.findAll();
		model.addAttribute("robots", robots);
		model.addAttribute("type", "findAll");
		return "index";
	}

	@RequestMapping(value = { "/getPage" })
	public String getPage(Pageable page, Model model) {
		Page<RobotModel> robots = robotRepository.findAll(page);
		model.addAttribute("robotsPage", robots);
		model.addAttribute("robots", robots.getContent());
		model.addAttribute("type", "findAll");
		return "index";
	}

	@RequestMapping(value = { "/find" })
	public String find(Model model, @RequestParam String searchString, @ModelAttribute("type") String type) {
		List<RobotModel> robots = null;
		int count = 0;

		switch (type) {
		case "findAll":
			robots = robotRepository.findAll();
			count = robots.size();
			break;

		case "findByFirstName":
			robots = robotRepository.findByFirstName(searchString);
			break;

		case "findByLastName":
			robots = robotRepository.findByLastName(searchString);
			break;

		case "findByAnything":
			robots = robotRepository.findByAnything(searchString);
			break;

		case "findByFirstNameEndsWith":
			robots = robotRepository.findByFirstNameEndsWith(searchString);
			break;	
			
		case "findByLastNameEndsWith":
			robots = robotRepository.findByLastNameEndsWith(searchString);
			break;	
			
		case "findByOrderByLastNameAsc":
			robots = robotRepository.findByOrderByLastNameAsc();
			break;	
			
		case "findTop10ByOrderByFirstNameAsc":
			robots = robotRepository.findTop10ByOrderByFirstNameAsc();
			break;
			
		case "findTop10ByOrderByLastNameAsc":
			robots = robotRepository.findTop10ByOrderByLastNameAsc();
			break;
			
		case "findByOrderByFirstNameAsc":
			robots = robotRepository.findByOrderByFirstNameAsc();
			break;
			
		case "findBySomething":
			robots = robotRepository.findBySomething(searchString);
			break;
			
	

		default:
			robots = robotRepository.findAll();
		}

		model.addAttribute("robots", robots);
		model.addAttribute("count", count);
		return "index";
	}

	@RequestMapping(value = { "/findById" })
	public String findById(@RequestParam("id") RobotModel e, Model model) {
		List<RobotModel> robots = new ArrayList<>();
		robots.add(e);
		model.addAttribute("robots", robots);
		return "index";
	}

	@RequestMapping("/fill")
	@Transactional
	public String fillData(Model model) {

		DataFactory df = new DataFactory();
		CompanyModel company = null;

		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0) {
				String companyName = df.getBusinessName();
				company = companyRepository.findFirstByName(companyName);

				if (company == null) {
					company = new CompanyModel(companyName);
				}
			}

			RobotModel re = new RobotModel(df.getFirstName(), df.getLastName(), df.getCity(), df.getBirthDate());
			re.setCompany(company);
			robotRepository.save(re);
		}

		return "forward:list";
	}

	@RequestMapping("/delete")
	public String deleteData(Model model, @RequestParam int id) {
		robotRepository.delete(id);

		return "forward:list";
	}

	// @ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "showError";

	}
}
