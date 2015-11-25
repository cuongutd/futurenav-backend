package com.cuong.futurenav.controller.model;

import java.util.Date;
import java.util.List;

import com.cuong.futurenav.util.DateUtil;

public class StudentProfileResponse {
	private Integer id;
	private String nameFirst;
	private String nameLast;
	private String nameMiddle;
	private String nameDisplay;
	private String email;
	private String city;
	private String country;
	private String bornYear;
	private String birthDate;
	private String auCreatedDt;
	private String auUpdatedDt;
	private Integer auCreatedBy;
	private Integer auUpdatedBy;
	private String networkUserId;
	private String networkGroup;
	private String photoUrl;
	private List<FavSchoolResponse> listOfFavSchool;

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
		this.bornYear = DateUtil.formatTimestampAsString(bornYear);
	}

	public String getBornYear() {
		return this.bornYear;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = DateUtil.formatTimestampAsString(birthDate);
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setAuCreatedDt(Date auCreatedDt) {
		this.auCreatedDt = DateUtil.formatTimestampAsString(auCreatedDt);
	}

	public String getAuCreatedDt() {
		return this.auCreatedDt;
	}

	public void setAuUpdatedDt(Date auUpdatedDt) {
		this.auUpdatedDt = DateUtil.formatTimestampAsString(auUpdatedDt);
	}

	public String getAuUpdatedDt() {
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

	public void setListOfFavSchool(List<FavSchoolResponse> listOfFavSchool) {
		this.listOfFavSchool = listOfFavSchool;
	}

	public List<FavSchoolResponse> getListOfFavSchool() {
		return this.listOfFavSchool;
	}

	public String getNetworkUserId() {
		return networkUserId;
	}

	public void setNetworkUserId(String networkuserid) {
		this.networkUserId = networkuserid;
	}

	public String getNetworkGroup() {
		return networkGroup;
	}

	public void setNetworkGroup(String networkgroup) {
		this.networkGroup = networkgroup;
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
        sb.append(networkUserId);
        sb.append("|");
        sb.append(networkGroup);
        sb.append("|");
        sb.append(photoUrl);
		return sb.toString();
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getNameDisplay() {
		return nameDisplay;
	}

	public void setNameDisplay(String nameDisplay) {
		this.nameDisplay = nameDisplay;
	}

}
