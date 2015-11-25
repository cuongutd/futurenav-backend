package com.cuong.futurenav.controller.model;

import java.util.Date;

import com.cuong.futurenav.model.SchoolData;
import com.cuong.futurenav.util.DateUtil;

public class SchoolPropResponse {
	private Integer id;
	private String name;
	private String value;
	private String auCreatedDt;
	private String auUpdatedDt;
	private SchoolData school;

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

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
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

	public void setSchool(SchoolData school) {
		this.school = school;
	}

	public SchoolData getSchool() {
		return this.school;
	}
}
