package com.cuong.futurenav.model;

import java.util.Date;
import com.cuong.futurenav.model.SchoolData;

public class SchoolPropertiesData {
	private Integer id;
	private String name;
	private String value;
	private Date auCreatedDt;
	private Date auUpdatedDt;
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

	// --- DATABASE MAPPING : au_created_dt ( DATETIME )
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

	public void setSchool(SchoolData school) {
		this.school = school;
	}

	public SchoolData getSchool() {
		return this.school;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(name);
		sb.append("|");
		sb.append(value);
		sb.append("|");
		sb.append(auCreatedDt);
		sb.append("|");
		sb.append(auUpdatedDt);
		return sb.toString();
	}

}
