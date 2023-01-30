package com.example.AutomatedTalentManagementApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutomatedTalentManagementApp.model.TrainingUser;
import com.example.AutomatedTalentManagementApp.service.UserService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/associateuser")
@Validated
public class AssociateUserController {
	
	private UserService userservice;

	@Autowired
	public AssociateUserController(UserService userservice) {
		super();
		this.userservice = userservice;
		
	}
	
	
	public String LoggedInUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			String username=((UserDetails)principal).getUsername();
			return username;
		} else {
			String username = principal.toString();
			return username;
		}
	}
	
	
    @GetMapping("/getuserbyid")
	//@RequestMapping(value = "/getuserbyid", method = RequestMethod.GET)
	public TrainingUser getUserByID(@RequestParam(value = "empid" ,defaultValue="312956") String empid) {
    	String currentuser = this.LoggedInUser();
    	if (currentuser.equalsIgnoreCase(empid)) {
    		TrainingUser trusr = userservice.findByID(Integer.parseInt(empid));
    		System.out.println("Training User Created");
    		 return trusr;
    	} else {
    		System.out.println("Failed to create training user");
    		return null;
    	}

	}
	

//	@GetMapping("/getuserbyname")
//	public List<TrainingUser> getUserByName(@RequestParam(value = "name",defaultValue="Prodipto Ranjan Baksi")String name) {
//		List<TrainingUser> trusrlist = userservice.findByName(name);
////		if (trusr.getName() == "Name at Login") {}
//		return trusrlist;
//	}
	
	@PutMapping("/updatecertification/{empid}")
	//@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	//@RequestMapping(method = RequestMethod.PUT , path = "/updatecertification/{empid}")
	public ResponseEntity<?> updateExistingUser(@PathVariable("empid") String empid , @RequestBody TrainingUser traininguser) {
		TrainingUser targetuser = userservice.findByID(Integer.parseInt(empid));
		String currentuser = this.LoggedInUser();
		if (targetuser == null) {
			return new ResponseEntity<TrainingUser>(HttpStatus.NOT_FOUND);
		}
		else if (currentuser.equalsIgnoreCase(empid)){
		targetuser.setEmpid(Integer.parseInt(empid));
		targetuser.setName(targetuser.getName());
		targetuser.setDesig(targetuser.getDesig());
		targetuser.setLead(targetuser.getLead());
		targetuser.setLoc(targetuser.getLoc());
		targetuser.setPlatform(targetuser.getPlatform());
		targetuser.setEmailid(targetuser.getEmailid());
		targetuser.setCertid(traininguser.getCertid());
		targetuser.setCertname(traininguser.getCertname());
		targetuser.setAssignedby(traininguser.getAssignedby());
		targetuser.setCertcompletiondate(traininguser.getCertcompletiondate());
		userservice.updateUser(Integer.parseInt(empid),targetuser);
		//System.out.print(val);
		return new ResponseEntity<TrainingUser>(targetuser, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<TrainingUser>(HttpStatus.UNAUTHORIZED);
		}
	}

}
