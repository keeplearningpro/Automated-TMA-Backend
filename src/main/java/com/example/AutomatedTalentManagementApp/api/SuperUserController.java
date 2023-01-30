package com.example.AutomatedTalentManagementApp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutomatedTalentManagementApp.model.CertificateDetails;
import com.example.AutomatedTalentManagementApp.model.TrainingUser;
import com.example.AutomatedTalentManagementApp.service.UserService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/superuser")
@Validated
public class SuperUserController {
	
	private final UserService userservice;
	
	@Autowired
	public SuperUserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}
	
	@GetMapping("/getallusers")
	public List<TrainingUser> getAllUsers() {
		List<TrainingUser> trusrlist = userservice.findAllUsers();
		return trusrlist;
	}
	
	@GetMapping("/getuserbyid")
	public TrainingUser getUserByID(@RequestParam(value = "empid" ,defaultValue="312956") String empid) {
		TrainingUser trusr = userservice.findByID(Integer.parseInt(empid));
		return trusr;
	}
	

//	@GetMapping ("/getuserbyname")
//	public TrainingUser getUserByName(@RequestParam(value = "name",defaultValue="Prodipto Ranjan Baksi")String name) {
//		TrainingUser trusr = userservice.findByName(name);
//		return trusr;
//	}
	
	@GetMapping ("/getuserbyname")
	public List<TrainingUser> getUserByName(@RequestParam(value = "name",defaultValue="Prodipto Ranjan Baksi")String name) {
		List<TrainingUser> trusrlist = userservice.findByName(name);
		return trusrlist;
	}
	
	@GetMapping("/getuserbydesignation")
	public List<TrainingUser> getAllUsersByDesignation(@RequestParam(value="desig",defaultValue="C2") String desig) {
		List<TrainingUser> trusrlist = userservice.findByDesignation(desig);
		return trusrlist;
	}
	
	@GetMapping("/getuserbylead")
	public List<TrainingUser> getAllUsersByLead(@RequestParam(value="lead",defaultValue="Raghuraman Balaraman") String lead) {
		List <TrainingUser> truserlist = userservice.findByPpl(lead);
		return truserlist;
	}
	
	@GetMapping("/getuserbylocation")
	public List<TrainingUser> getAllUsersByLocation (@RequestParam(value="loc",defaultValue="Onsite") String loc) {
		List <TrainingUser> truserlist = userservice.findByLocation(loc);
		return truserlist;
	}
	
	@GetMapping("/getuserbyplatform")
	public List<TrainingUser> getAllUserByPlatform (@RequestParam(value="platform",defaultValue="IIP") String platform) {
		List <TrainingUser> truserlist = userservice.findByPlatform(platform);
		return truserlist;
	}
	
	@GetMapping("/getcertificatebyid")
	public CertificateDetails getCertByID(@RequestParam(value = "certid" ,defaultValue="14532") String certid) {
		CertificateDetails certificate = userservice.findByCertID(certid);
		return certificate;
	}
	
	@GetMapping("/getcertificatebyname")
	public List<CertificateDetails> getCertByName(@RequestParam(value = "certname" ,defaultValue="Certified Hyperledger Fabric Developer (CHFD)") String certname) {
		List<CertificateDetails> certificatelist = userservice.findByCertName(certname);
		return certificatelist;
	}
	
	@PutMapping("/updateassociate/{empid}")
	public ResponseEntity<?> updateAssociate(@PathVariable("empid") String empid , @RequestBody TrainingUser traininguser) {
		TrainingUser targetuser = userservice.findByID(Integer.parseInt(empid));
		if (targetuser == null) {
			return new ResponseEntity<TrainingUser>(HttpStatus.NOT_FOUND);
		}
		else {
		targetuser.setEmpid(Integer.parseInt(empid));
		targetuser.setName(targetuser.getName());
		targetuser.setDesig(traininguser.getDesig());
		targetuser.setLead(traininguser.getLead());
		targetuser.setLoc(traininguser.getLoc());
		targetuser.setPlatform(traininguser.getPlatform());
		targetuser.setEmailid(targetuser.getEmailid());
		targetuser.setCertid(traininguser.getCertid());
		targetuser.setCertname(traininguser.getCertname());
		targetuser.setAssignedby(traininguser.getAssignedby());
		targetuser.setCertcompletiondate(traininguser.getCertcompletiondate());
		userservice.updateUser(Integer.parseInt(empid),targetuser);
		//System.out.print(val);
		return new ResponseEntity<TrainingUser>(targetuser, HttpStatus.OK);
		}
	}
	
	@PostMapping("/addassociate")
	public ResponseEntity<?> addNewAssociate (@RequestBody TrainingUser traininguser) {
		if (userservice.isUserExist(traininguser)) {
			return new ResponseEntity<TrainingUser>(HttpStatus.CONFLICT);
		}
		userservice.saveUser(traininguser);
		return new ResponseEntity<TrainingUser>(traininguser, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteassociate/{empid}")
	public ResponseEntity<?> deleteAssociate(@PathVariable("empid") String empid) { 
		TrainingUser targetuser = userservice.findByID(Integer.parseInt(empid));
		if (targetuser == null) {
			return new ResponseEntity<TrainingUser>(HttpStatus.NOT_FOUND);
		}
		else {
			userservice.deleteUserById(Integer.parseInt(empid));
			return new ResponseEntity<TrainingUser>(HttpStatus.NO_CONTENT); 
		}
	}
	
	
}
