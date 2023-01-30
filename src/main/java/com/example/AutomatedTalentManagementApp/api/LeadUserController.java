package com.example.AutomatedTalentManagementApp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutomatedTalentManagementApp.model.TrainingUser;
import com.example.AutomatedTalentManagementApp.service.UserService;



@RestController
@RequestMapping("/api/leaduser")
public class LeadUserController {
	

	private final UserService userservice;
	
	@Autowired
	public LeadUserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}
	
	
	@GetMapping("/getuserbyid")
	public TrainingUser getUserByID(@RequestParam(value = "empid" ,defaultValue="312956") String empid) {
		TrainingUser trusr = userservice.findByID(Integer.parseInt(empid));
//		if (trusr.getLead() == "Lead Name at Login") {}
		return trusr;
	}
	

	@GetMapping ("/getuserbyname")
	public List<TrainingUser> getUserByName(@RequestParam(value = "name",defaultValue="Prodipto Ranjan Baksi")String name) {
		List<TrainingUser> trusrlist = userservice.findByName(name);
//		if (trusr.getLead() == "Lead Name at Login") {}
		return trusrlist;
	}
	
	@GetMapping("/getuserbylead")
	public List<TrainingUser> getAllUsersByLead(@RequestParam(value="lead",defaultValue="Raghuraman Balaraman") String lead) {
//		if (lead == "Lead Name at Login") {}
		List <TrainingUser> truserlist = userservice.findByPpl(lead);
		return truserlist;
	}
	
	@GetMapping("/getuserbyplatform")
	public List<TrainingUser> getAllUserByPlatform (@RequestParam(value="platform",defaultValue="IIP") String platform) {
//		if (platform == "platform of the lead at logon") {}
		List <TrainingUser> truserlist = userservice.findByPlatform(platform);
		return truserlist;
	}

	
	

}
