package com.example.AutomatedTalentManagementApp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutomatedTalentManagementApp.model.CertificateDetails;
import com.example.AutomatedTalentManagementApp.service.UserService;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/certification")
public class CertificateInfoController {
	private final UserService userservice;
	
	@Autowired
	public CertificateInfoController(UserService userservice) {
		super();
		this.userservice = userservice;
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

}
