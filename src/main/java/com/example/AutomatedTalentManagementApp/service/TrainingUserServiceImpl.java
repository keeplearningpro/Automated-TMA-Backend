package com.example.AutomatedTalentManagementApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.AutomatedTalentManagementApp.database.DataAccess;
import com.example.AutomatedTalentManagementApp.model.CertificateDetails;
import com.example.AutomatedTalentManagementApp.model.TrainingUser;



@Service
public class TrainingUserServiceImpl implements UserService {
	
//	static List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
	private final DataAccess dao;
	
    @Autowired
	public TrainingUserServiceImpl(@Qualifier("csvfileoperation") DataAccess dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<TrainingUser> findAllUsers() {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		truserlist = dao.readcsvAssociateDetails();
		return truserlist;
	}

	@Override
	public TrainingUser findByID(int empid) {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		truserlist = dao.readcsvAssociateDetails();
		for (TrainingUser trusr : truserlist ) {
			if (trusr.getEmpid() == empid) {
				return trusr;
			}
		}
		return null;
	}

//	@Override
//	public TrainingUser findByName(String name) {
//		// TODO Auto-generated method stub
//		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
//		truserlist = dao.readcsvAssociateDetails();
//		for (TrainingUser trusr : truserlist ) {
//			if (trusr.getName().equalsIgnoreCase(name)) {
//				return trusr;
//			}
//		}
//		return null;
//	}

	@Override
	public List<TrainingUser> findByName(String name) {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		truserlist = dao.readcsvAssociateDetails();
		List<TrainingUser> usernamematchlist = new ArrayList<TrainingUser>();
		for (TrainingUser trusr : truserlist ) {
			if (trusr.getName().toLowerCase().contains(name.toLowerCase())) {
				usernamematchlist.add(trusr);
			}
		}
		return usernamematchlist;
	}
	
	
	@Override
	public List<TrainingUser> findByDesignation(String desig) {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		truserlist = dao.readcsvAssociateDetails();
		List<TrainingUser> desiguserlist = new ArrayList<TrainingUser>();
		for (TrainingUser trusr : truserlist ) {
			if (trusr.getDesig().equalsIgnoreCase(desig)) {
				desiguserlist.add(trusr);
			}
		}
		return desiguserlist;
	}

	@Override
	public List<TrainingUser> findByPpl(String lead) {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		truserlist = dao.readcsvAssociateDetails();
		List<TrainingUser> userlistforlead = new ArrayList<TrainingUser>();
		for (TrainingUser trusr : truserlist) {
			if (trusr.getLead().equalsIgnoreCase(lead)) {
				userlistforlead.add(trusr);
			}
		}
		return userlistforlead;
	}

	@Override
	public List<TrainingUser> findByLocation(String loc) {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		truserlist = dao.readcsvAssociateDetails();
		List<TrainingUser> locuserlist = new ArrayList<TrainingUser>();
		for (TrainingUser trusr : truserlist ) {
			if (trusr.getLoc().equalsIgnoreCase(loc)) {
			locuserlist.add(trusr);
			}
		}
		return locuserlist;
	}

	@Override
	public List<TrainingUser> findByPlatform(String platform) {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		truserlist = dao.readcsvAssociateDetails();
		List<TrainingUser> pltusrlist = new ArrayList<TrainingUser>();
		for (TrainingUser trusr : truserlist) {
			if (trusr.getPlatform().equalsIgnoreCase(platform)) {
			pltusrlist.add(trusr);
			}
		}
		return pltusrlist;
	}

	@Override
	public void deleteUserById(int empid) {
		// TODO Auto-generated method stub
		List<TrainingUser> oldlist = new ArrayList<TrainingUser>();
		oldlist = dao.readcsvAssociateDetails();
		List<TrainingUser> newlist = new ArrayList<TrainingUser>();
		for (TrainingUser trusr:oldlist) {
			if (trusr.getEmpid() != empid) {
				newlist.add(trusr);
			}
		}
		dao.writecsvAssociateDetails(newlist);
	}

	@Override
	public boolean isUserExist(TrainingUser trusr) {
		// TODO Auto-generated method stub
		
		return findByID(trusr.getEmpid())!= null;
	}

	@Override
	public void saveUser(TrainingUser trusr) {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		truserlist = dao.readcsvAssociateDetails();
		truserlist.add(trusr);
		dao.writecsvAssociateDetails(truserlist);

	}

	@Override
	public void updateUser(int empid, TrainingUser targetuser) {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		truserlist = dao.readcsvAssociateDetails();
		int index = 0;
		for (TrainingUser trusr : truserlist ) {
			if (trusr.getEmpid() == empid) {
				index = truserlist.indexOf(trusr);
			}
		}
		truserlist.set(index, targetuser);
		dao.writecsvAssociateDetails(truserlist);
	}

	@Override
	public CertificateDetails findByCertID(String certid) {
		// TODO Auto-generated method stub
		List<CertificateDetails> certlist = new ArrayList<CertificateDetails>();
		certlist = dao.readcsvCertificateDetails();
		for (CertificateDetails crtusr : certlist ) {
			if (crtusr.getCertid().equalsIgnoreCase(certid)) {
				return crtusr;
			}
		}
		return null;
	}

	@Override
	public List<CertificateDetails> findByCertName(String certname) {
	// TODO Auto-generated method stub
	List<CertificateDetails> certlist = new ArrayList<CertificateDetails>();
	certlist = dao.readcsvCertificateDetails();
	List<CertificateDetails> certnamematchlist = new ArrayList<CertificateDetails>();
	for (CertificateDetails crtusr : certlist ) {
		if (crtusr.getCertname().toLowerCase().contains(certname.toLowerCase())) {
			certnamematchlist.add(crtusr);
		}
	}
	return certnamematchlist;
}
//	public CertificateDetails findByCertName(String certname) {
//		// TODO Auto-generated method stub
//		List<CertificateDetails> certlist = new ArrayList<CertificateDetails>();
//		certlist = dao.readcsvCertificateDetails();
//		for (CertificateDetails crtusr : certlist ) {
//			if (crtusr.getCertname().equalsIgnoreCase(certname)) {
//				return crtusr;
//			}
//		}
//		return null;
//	}
	

}
