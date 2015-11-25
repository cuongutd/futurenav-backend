package com.cuong.futurenav.controller.model;

import java.util.Date;
import java.util.List;

import com.cuong.futurenav.util.DateUtil;

public class SchoolResponse {
	private Integer id;
	private String name;
	private String type;
	private String grades;
	private String city;
	private String state;
	private Double latitude;
	private Double longitude;
	private String wikipageid;
	private String wikirevisionid;
	private String auCreatedDt;
	private String auUpdatedDt;

	private List<SchoolPropResponse> listOfSchoolProperties;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public String getGrades() {
		return this.grades;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setWikipageid(String wikipageid) {
		this.wikipageid = wikipageid;
	}

	public String getWikipageid() {
		return this.wikipageid;
	}

	public void setWikirevisionid(String wikirevisionid) {
		this.wikirevisionid = wikirevisionid;
	}

	public String getWikirevisionid() {
		return this.wikirevisionid;
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

	public void setListOfSchoolProperties(List<SchoolPropResponse> listOfSchoolProperties) {
		this.listOfSchoolProperties = listOfSchoolProperties;
	}

	public List<SchoolPropResponse> getListOfSchoolProperties() {
		return this.listOfSchoolProperties;
	}

}
