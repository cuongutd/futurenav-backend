package com.cuong.futurenav.model;

import java.util.Date;
import java.util.List;

import com.cuong.futurenav.model.FavSchoolData;

public class StudentProfileData {

	private Integer id;
	private String nameFirst;
	private String nameLast;
	private String nameMiddle;
	private String nameDisplay;
	private String email;
	private String city;
	private String country;
	private Date bornYear;
	private Date birthDate;
	private Date auCreatedDt;
	private Date auUpdatedDt;
	private Integer auCreatedBy;
	private Integer auUpdatedBy;
	private String networkuserid;
	private String networkgroup;
	private String photoUrl;

	private List<FavSchoolData> listOfFavSchool;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameFirst() {
		return this.nameFirst;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getNameLast() {
		return this.nameLast;
	}

	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}

	public String getNameMiddle() {
		return this.nameMiddle;
	}

	public void setNameDisplay(String nameDisplay) {
		this.nameDisplay = nameDisplay;
	}

	public String getNameDisplay() {
		return this.nameDisplay;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setBornYear(Date bornYear) {
		this.bornYear = bornYear;
	}

	public Date getBornYear() {
		return this.bornYear;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setAuCreatedDt(Date auCreatedDt) {
		this.auCreatedDt = auCreatedDt;
	}

	public Date getAuCreatedDt() {
		return this.auCreatedDt;
	}

	public void setAuUpdatedDt(Date auUpdatedDt) {
		this.auUpdatedDt = auUpdatedDt;
	}

	public Date getAuUpdatedDt() {
		return this.auUpdatedDt;
	}

	public void setAuCreatedBy(Integer auCreatedBy) {
		this.auCreatedBy = auCreatedBy;
	}

	public Integer getAuCreatedBy() {
		return this.auCreatedBy;
	}

	public void setAuUpdatedBy(Integer auUpdatedBy) {
		this.auUpdatedBy = auUpdatedBy;
	}

	public Integer getAuUpdatedBy() {
		return this.auUpdatedBy;
	}

	public void setNetworkuserid(String networkuserid) {
		this.networkuserid = networkuserid;
	}

	public String getNetworkuserid() {
		return this.networkuserid;
	}

	public void setNetworkgroup(String networkgroup) {
		this.networkgroup = networkgroup;
	}

	public String getNetworkgroup() {
		return this.networkgroup;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setListOfFavSchool(List<FavSchoolData> listOfFavSchool) {
		this.listOfFavSchool = listOfFavSchool;
	}

	public List<FavSchoolData> getListOfFavSchool() {
		return this.listOfFavSchool;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(nameFirst);
		sb.append("|");
		sb.append(nameLast);
		sb.append("|");
		sb.append(nameMiddle);
		sb.append("|");
		sb.append(nameDisplay);
		sb.append("|");
		sb.append(email);
		sb.append("|");
		sb.append(city);
		sb.append("|");
		sb.append(country);
		sb.append("|");
		sb.append(bornYear);
		sb.append("|");
		sb.append(birthDate);
		sb.append("|");
		sb.append(auCreatedDt);
		sb.append("|");
		sb.append(auUpdatedDt);
		sb.append("|");
		sb.append(auCreatedBy);
		sb.append("|");
		sb.append(auUpdatedBy);
		sb.append("|");
		sb.append(networkuserid);
		sb.append("|");
		sb.append(networkgroup);
		sb.append("|");
		sb.append(photoUrl);
		return sb.toString();
	}
}
