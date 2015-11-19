package com.cuong.futurenav.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Cuong on 11/13/2015.
 */
public class SchoolData {
	private Integer id;
	private String name;
	private String type;
	private String relegious;
	private Date established;
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
	private Date auCreatedDt;
	private Date auUpdatedDt;
	private List<SchoolDetailData> listOfSchoolDetail;
	
	
	public SchoolData() {
	}

	public SchoolData(String name, String type, Date established, boolean active, Date auCreatedDt, Date auUpdatedDt) {
		this.name = name;
		this.type = type;
		this.established = established;
		this.active = active;
		this.auCreatedDt = auCreatedDt;
		this.auUpdatedDt = auUpdatedDt;
	}

	public SchoolData(String name, String type, String relegious, Date established, boolean active, Byte gradeFrom,
			Byte gradeTo, String website, String gender, String crestUrl, String slogan, String street, String city,
			String state, String country, String zip, Double longitude, Double latitude, Date auCreatedDt,
			Date auUpdatedDt) {
		this.name = name;
		this.type = type;
		this.relegious = relegious;
		this.established = established;
		this.active = active;
		this.gradeFrom = gradeFrom;
		this.gradeTo = gradeTo;
		this.website = website;
		this.gender = gender;
		this.crestUrl = crestUrl;
		this.slogan = slogan;
		this.street = street;
		this.city = city;
		this.state = state;
		this.countrycode = country;
		this.zip = zip;
		this.longitude = longitude;
		this.latitude = latitude;
		this.auCreatedDt = auCreatedDt;
		this.auUpdatedDt = auUpdatedDt;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRelegious() {
		return this.relegious;
	}

	public void setRelegious(String relegious) {
		this.relegious = relegious;
	}

	public Date getEstablished() {
		return this.established;
	}

	public void setEstablished(Date established) {
		this.established = established;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Byte getGradeFrom() {
		return this.gradeFrom;
	}

	public void setGradeFrom(Byte gradeFrom) {
		this.gradeFrom = gradeFrom;
	}

	public Byte getGradeTo() {
		return this.gradeTo;
	}

	public void setGradeTo(Byte gradeTo) {
		this.gradeTo = gradeTo;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCrestUrl() {
		return this.crestUrl;
	}

	public void setCrestUrl(String crestUrl) {
		this.crestUrl = crestUrl;
	}

	public String getSlogan() {
		return this.slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Date getAuCreatedDt() {
		return this.auCreatedDt;
	}

	public void setAuCreatedDt(Date auCreatedDt) {
		this.auCreatedDt = auCreatedDt;
	}

	public Date getAuUpdatedDt() {
		return this.auUpdatedDt;
	}

	public void setAuUpdatedDt(Date auUpdatedDt) {
		this.auUpdatedDt = auUpdatedDt;
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

	public List<SchoolDetailData> getListOfSchoolDetail() {
		return listOfSchoolDetail;
	}

	public void setListOfSchoolDetail(List<SchoolDetailData> listOfSchoolDetail) {
		this.listOfSchoolDetail = listOfSchoolDetail;
	}
}