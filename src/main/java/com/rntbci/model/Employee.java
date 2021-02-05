package com.rntbci.model;

public class Employee {
	private Integer eid;
	private String ename;
	private String designation;
	public Employee() {

	}
	public Employee(Integer eid, String ename, String designation) {

		this.eid = eid;
		this.ename = ename;
		this.designation = designation;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", designation=" + designation + "]";
	}


}
