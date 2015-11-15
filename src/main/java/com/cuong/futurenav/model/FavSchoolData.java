package com.cuong.futurenav.model;

import java.util.Date;

public class FavSchoolData {

	private Integer id;
	private String affiliateType;
	private String note;
	private Date auCreatedDt;
	private Date auUpdatedDt;
	private Integer auCreatedBy;
	private Integer auUpdatedBy;
	private SchoolData school;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setAffiliateType(String affiliateType) {
		this.affiliateType = affiliateType;
	}

	public String getAffiliateType() {
		return this.affiliateType;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return this.note;
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
		sb.append(affiliateType);
		sb.append("|");
		sb.append(note);
		sb.append("|");
		sb.append(auCreatedDt);
		sb.append("|");
		sb.append(auUpdatedDt);
		sb.append("|");
		sb.append(auCreatedBy);
		sb.append("|");
		sb.append(auUpdatedBy);
		return sb.toString();
	}

}
