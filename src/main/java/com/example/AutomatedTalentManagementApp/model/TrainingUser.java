package com.example.AutomatedTalentManagementApp.model;

public class TrainingUser {
	private int empid;
	private String name;
	private String desig;
	private String lead;
	private String loc;
	private String platform;
	private String emailid;
	private String certid;
	private String certname;
	private String assignedby;
	private String certcompletiondate;
	
	public TrainingUser(int empid, String name, String desig, String lead, String loc, String platform, String emailid,
			String certid , String certname , String assignedby , String certcompletiondate) {
		super();
		this.empid = empid;
		this.name = name;
		this.desig = desig;
		this.lead = lead;
		this.loc = loc;
		this.platform = platform;
		this.emailid = emailid;
		this.certid = certid;
		this.setCertname(certname);
		this.setAssignedby(assignedby);
		this.certcompletiondate = certcompletiondate;
	}
	/**
	 * @return the empid
	 */
	public int getEmpid() {
		return empid;
	}
	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the desig
	 */
	public String getDesig() {
		return desig;
	}
	/**
	 * @param desig the desig to set
	 */
	public void setDesig(String desig) {
		this.desig = desig;
	}
	/**
	 * @return the lead
	 */
	public String getLead() {
		return lead;
	}
	/**
	 * @param lead the lead to set
	 */
	public void setLead(String lead) {
		this.lead = lead;
	}
	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}
	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	/**
	 * @return the certid
	 */
	public String getCertid() {
		return certid;
	}
	/**
	 * @param certid the certid to set
	 */
	public void setCertid(String certid) {
		this.certid = certid;
	}
	
	public String getCertname() {
		return certname;
	}
	public void setCertname(String certname) {
		this.certname = certname;
	}
	public String getAssignedby() {
		return assignedby;
	}
	public void setAssignedby(String assignedby) {
		this.assignedby = assignedby;
	}
	
	public String getCertcompletiondate() {
		return certcompletiondate;
	}
	/**
	 * @param certcompletiondate the certcompletiondate to set
	 */
	public void setCertcompletiondate(String certcompletiondate) {
		this.certcompletiondate = certcompletiondate;
	}

	
}
