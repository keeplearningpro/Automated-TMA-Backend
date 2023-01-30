package com.example.AutomatedTalentManagementApp.service;

import java.util.List;

import com.example.AutomatedTalentManagementApp.model.CertificateDetails;
import com.example.AutomatedTalentManagementApp.model.TrainingUser;



public interface UserService {
	
	//List of Services Available
	List<TrainingUser> findAllUsers();
	
	TrainingUser findByID(int empid);
	
	List<TrainingUser> findByName(String name);
	
	List<TrainingUser> findByDesignation(String desig);
	
	List<TrainingUser> findByPpl (String lead);
	
	List<TrainingUser> findByLocation(String loc);
	
	List <TrainingUser> findByPlatform(String platform);
		
	void deleteUserById(int empid);
	
	boolean isUserExist(TrainingUser trusr);
	
	void saveUser(TrainingUser trusr);
	
	void updateUser (int empid , TrainingUser trusr);
		
	CertificateDetails findByCertID(String certid);
	List<CertificateDetails> findByCertName(String certname); 
		

}
