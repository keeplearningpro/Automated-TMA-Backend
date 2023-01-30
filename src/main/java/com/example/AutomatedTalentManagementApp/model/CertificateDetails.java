package com.example.AutomatedTalentManagementApp.model;

public class CertificateDetails {
	
	private String certid;
	private String certname;
	private String status;
	private String certtype;
	private String vendor;
	private String examid;
	private String examname;
	private String paymode;
	
	
	public CertificateDetails(String certid, String certname, String status, String certtype, String vendor,
			String examid, String examname, String paymode) {
		super();
		this.certid = certid;
		this.certname = certname;
		this.status = status;
		this.certtype = certtype;
		this.vendor = vendor;
		this.examid = examid;
		this.examname = examname;
		this.paymode = paymode;
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
	/**
	 * @return the certname
	 */
	public String getCertname() {
		return certname;
	}
	/**
	 * @param certname the certname to set
	 */
	public void setCertname(String certname) {
		this.certname = certname;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the certtype
	 */
	public String getCerttype() {
		return certtype;
	}
	/**
	 * @param certtype the certtype to set
	 */
	public void setCerttype(String certtype) {
		this.certtype = certtype;
	}
	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}
	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	/**
	 * @return the examid
	 */
	public String getExamid() {
		return examid;
	}
	/**
	 * @param examid the examid to set
	 */
	public void setExamid(String examid) {
		this.examid = examid;
	}
	/**
	 * @return the examname
	 */
	public String getExamname() {
		return examname;
	}
	/**
	 * @param examname the examname to set
	 */
	public void setExamname(String examname) {
		this.examname = examname;
	}
	/**
	 * @return the paymode
	 */
	public String getPaymode() {
		return paymode;
	}
	/**
	 * @param paymode the paymode to set
	 */
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	
	

}
