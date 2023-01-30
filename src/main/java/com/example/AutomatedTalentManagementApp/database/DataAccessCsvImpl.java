package com.example.AutomatedTalentManagementApp.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.AutomatedTalentManagementApp.model.CertificateDetails;
import com.example.AutomatedTalentManagementApp.model.TrainingUser;



@Repository("csvfileoperation")
public class DataAccessCsvImpl implements DataAccess {
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	//private static final String ASSOCIATE_CSV_FILE = "C:/Users/611130042/Documents/workspace-spring-tool-suite-4-4.7.0.RELEASE/ASM_Associate_Details.csv" ;
	//private static final String CERTIFICATE_CSV_FILE = "C:/Users/611130042/Documents/workspace-spring-tool-suite-4-4.7.0.RELEASE/Certification_catalogue.csv";
	
	private static final String ASSOCIATE_CSV_FILE = "C:/Users/prodi/development/workspace-spring-tool-suite-4-4.7.0.RELEASE/ASM_Associate_Details.csv" ;
	private static final String CERTIFICATE_CSV_FILE = "C:/Users/prodi/development/workspace-spring-tool-suite-4-4.7.0.RELEASE/Certification_catalogue.csv";

	
	@Override
	public List<TrainingUser> readcsvAssociateDetails() {
		// TODO Auto-generated method stub
		List<TrainingUser> truserlist = new ArrayList<TrainingUser>();
		List<List<String>> recordrow = new ArrayList<>();
		List<String> recordfield = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(ASSOCIATE_CSV_FILE))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        recordrow.add(Arrays.asList(values));
		    }
		    for ( int iterator = 0 ; iterator < recordrow.size(); iterator ++ ) {
		    	recordfield = recordrow.get(iterator);
		    	truserlist.add(new TrainingUser(Integer.parseInt(recordfield.get(0)),recordfield.get(1),recordfield.get(2),recordfield.get(3),recordfield.get(4),recordfield.get(5),recordfield.get(6),recordfield.get(7),recordfield.get(8),recordfield.get(9),recordfield.get(10)));
//		    	truserlist.add(new TrainingUser(Integer.parseInt(recordfield.get(0)),recordfield.get(1),recordfield.get(2),recordfield.get(3),recordfield.get(4),null,null,null));
		    }
		    return truserlist;
		}
		catch (IOException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	@Override
	public void writecsvAssociateDetails(List<TrainingUser> truserlist){
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(ASSOCIATE_CSV_FILE);
			int size = truserlist.size();
			int counter = 1;
			for (TrainingUser trusr : truserlist) {
				fileWriter.append(String.valueOf(trusr.getEmpid()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getDesig());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getLead());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getLoc());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getPlatform());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getEmailid());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getCertid());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getCertname());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getAssignedby());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trusr.getCertcompletiondate());
				counter = counter + 1 ; 
				if (counter <= size) {
				fileWriter.append(NEW_LINE_SEPARATOR);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fileWriter.flush();
                fileWriter.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	@Override
	public List<CertificateDetails> readcsvCertificateDetails() {
		// TODO Auto-generated method stub
		List<CertificateDetails> certlist = new ArrayList<CertificateDetails>();
		List<List<String>> recordrow = new ArrayList<>();
		List<String> recordfield = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(CERTIFICATE_CSV_FILE))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        recordrow.add(Arrays.asList(values));
		    }
		    for ( int iterator = 0 ; iterator < recordrow.size(); iterator ++ ) {
		    	recordfield = recordrow.get(iterator);
		    	certlist.add(new CertificateDetails(recordfield.get(0),recordfield.get(1),recordfield.get(8),recordfield.get(9),recordfield.get(12),recordfield.get(13),recordfield.get(14),recordfield.get(15)));
		    }
		    return certlist;
		}
		catch (IOException e) {
			e.printStackTrace();
			
		}
		return null;
	}

}
