package com.example.AutomatedTalentManagementApp.database;

import java.util.List;

import com.example.AutomatedTalentManagementApp.model.CertificateDetails;
import com.example.AutomatedTalentManagementApp.model.TrainingUser;



public interface DataAccess {
	List<TrainingUser> readcsvAssociateDetails() ;
	List<CertificateDetails> readcsvCertificateDetails();
	
	void writecsvAssociateDetails(List<TrainingUser> truserlist);
	

}
