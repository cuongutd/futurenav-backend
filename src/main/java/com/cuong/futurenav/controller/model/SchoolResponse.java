package com.cuong.futurenav.controller.model;

import java.util.List;

public class SchoolResponse {
	private Integer id;
	private String name;
	private String type;
	private String relegious;
	private Byte gradeFrom;
	private Byte gradeTo;
	private String gender;
	private String city;
	private String state;
	private Double longitude;
	private Double latitude;
	private List<SchoolDetailResponse> listOfSchoolDetail;
	
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public List<SchoolDetailResponse> getListOfSchoolDetail() {
		return listOfSchoolDetail;
	}
	public void setListOfSchoolDetail(List<SchoolDetailResponse> listOfSchoolDetail) {
		this.listOfSchoolDetail = listOfSchoolDetail;
	}
	
	
}
