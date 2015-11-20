package com.cuong.futurenav.controller.model;

import java.util.Date;
import java.util.List;

import com.cuong.futurenav.model.SchoolDetailData;
import com.cuong.futurenav.util.DateUtil;

public class SchoolResponse {
	private Integer id;
	private String name;
	private String type;
	private String relegious;
	private String established;
	private boolean active;
	private Byte gradeFrom;
	private Byte gradeTo;
	private String website;
	private String gender;
	private String crestUrl;
	private String slogan;

	private String street;
	private String city;
	private String state;
	private String countrycode;
	private String zip;

	private Double longitude;
	private Double latitude;
	private String auCreatedDt;
	private String auUpdatedDt;
	private List<SchoolDetailData> listOfSchoolDetail;
	private String contactNumber;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRelegious() {
		return relegious;
	}
	public void setRelegious(String relegious) {
		this.relegious = relegious;
	}
	public String getEstablished() {
		return established;
	}
	public void setEstablished(Date established) {
		this.established = DateUtil.formatTimestampAsString(established);
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Byte getGradeFrom() {
		return gradeFrom;
	}
	public void setGradeFrom(Byte gradeFrom) {
		this.gradeFrom = gradeFrom;
	}
	public Byte getGradeTo() {
		return gradeTo;
	}
	public void setGradeTo(Byte gradeTo) {
		this.gradeTo = gradeTo;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCrestUrl() {
		return crestUrl;
	}
	public void setCrestUrl(String crestUrl) {
		this.crestUrl = crestUrl;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getAuCreatedDt() {
		return auCreatedDt;
	}
	public void setAuCreatedDt(Date auCreatedDt) {
		this.auCreatedDt = DateUtil.formatTimestampAsString(auCreatedDt);
	}
	public String getAuUpdatedDt() {
		return auUpdatedDt;
	}
	public void setAuUpdatedDt(Date auUpdatedDt) {
		this.auUpdatedDt = DateUtil.formatTimestampAsString(auUpdatedDt);
	}
	public List<SchoolDetailData> getListOfSchoolDetail() {
		return listOfSchoolDetail;
	}
	public void setListOfSchoolDetail(List<SchoolDetailData> listOfSchoolDetail) {
		this.listOfSchoolDetail = listOfSchoolDetail;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
