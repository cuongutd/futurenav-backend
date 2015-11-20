package com.cuong.futurenav.controller.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cuong.futurenav.util.DateUtil;

public class SchoolDetailResponse {
	private Integer id;
	private String year;
	private Integer studentCount;
	private BigDecimal avgClassSize;
	private Integer ratio;
	private BigDecimal avgSatScore;
	private BigDecimal avgActScore;
	private BigDecimal tuition;
	private String auCreatedDt;
	private String auUpdatedDt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = DateUtil.formatTimestampAsString(year);
	}
	public Integer getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}
	public BigDecimal getAvgClassSize() {
		return avgClassSize;
	}
	public void setAvgClassSize(BigDecimal avgClassSize) {
		this.avgClassSize = avgClassSize;
	}
	public Integer getRatio() {
		return ratio;
	}
	public void setRatio(Integer ratio) {
		this.ratio = ratio;
	}
	public BigDecimal getAvgSatScore() {
		return avgSatScore;
	}
	public void setAvgSatScore(BigDecimal avgSatScore) {
		this.avgSatScore = avgSatScore;
	}
	public BigDecimal getAvgActScore() {
		return avgActScore;
	}
	public void setAvgActScore(BigDecimal avgActScore) {
		this.avgActScore = avgActScore;
	}
	public BigDecimal getTuition() {
		return tuition;
	}
	public void setTuition(BigDecimal tuition) {
		this.tuition = tuition;
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
}
