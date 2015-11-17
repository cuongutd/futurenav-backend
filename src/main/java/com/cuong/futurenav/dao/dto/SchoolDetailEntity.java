/*
 * Created on 14 Nov 2015 ( Time 15:23:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.cuong.futurenav.dao.dto;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "school_detail"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="school_detail", catalog="dev" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="SchoolDetailEntity.countAll", query="SELECT COUNT(x) FROM SchoolDetailEntity x" )
} )
public class SchoolDetailEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.DATE)
    @Column(name="year", nullable=false)
    private Date       year         ;

    @Column(name="student_count")
    private Integer    studentCount ;

    @Column(name="avg_class_size")
    private BigDecimal avgClassSize ;

    @Column(name="ratio")
    private Integer    ratio        ;

    @Column(name="avg_sat_score")
    private BigDecimal avgSatScore  ;

    @Column(name="avg_act_score")
    private BigDecimal avgActScore  ;

    @Column(name="tuition")
    private BigDecimal tuition      ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="au_created_dt", nullable=false, updatable=false, insertable=false)
    private Date       auCreatedDt  ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="au_updated_dt", nullable=false, updatable=false, insertable=false)
    private Date       auUpdatedDt  ;

	// "schoolId" (column "school_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="school_id", referencedColumnName="id")
    private SchoolEntity school      ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public SchoolDetailEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : year ( YEAR ) 
    public void setYear( Date year ) {
        this.year = year;
    }
    public Date getYear() {
        return this.year;
    }

    //--- DATABASE MAPPING : student_count ( INT ) 
    public void setStudentCount( Integer studentCount ) {
        this.studentCount = studentCount;
    }
    public Integer getStudentCount() {
        return this.studentCount;
    }

    //--- DATABASE MAPPING : avg_class_size ( DECIMAL ) 
    public void setAvgClassSize( BigDecimal avgClassSize ) {
        this.avgClassSize = avgClassSize;
    }
    public BigDecimal getAvgClassSize() {
        return this.avgClassSize;
    }

    //--- DATABASE MAPPING : ratio ( INT ) 
    public void setRatio( Integer ratio ) {
        this.ratio = ratio;
    }
    public Integer getRatio() {
        return this.ratio;
    }

    //--- DATABASE MAPPING : avg_sat_score ( DECIMAL ) 
    public void setAvgSatScore( BigDecimal avgSatScore ) {
        this.avgSatScore = avgSatScore;
    }
    public BigDecimal getAvgSatScore() {
        return this.avgSatScore;
    }

    //--- DATABASE MAPPING : avg_act_score ( DECIMAL ) 
    public void setAvgActScore( BigDecimal avgActScore ) {
        this.avgActScore = avgActScore;
    }
    public BigDecimal getAvgActScore() {
        return this.avgActScore;
    }

    //--- DATABASE MAPPING : tuition ( DECIMAL ) 
    public void setTuition( BigDecimal tuition ) {
        this.tuition = tuition;
    }
    public BigDecimal getTuition() {
        return this.tuition;
    }

    //--- DATABASE MAPPING : au_created_dt ( DATETIME ) 
    public void setAuCreatedDt( Date auCreatedDt ) {
        this.auCreatedDt = auCreatedDt;
    }
    public Date getAuCreatedDt() {
        return this.auCreatedDt;
    }

    //--- DATABASE MAPPING : au_updated_dt ( DATETIME ) 
    public void setAuUpdatedDt( Date auUpdatedDt ) {
        this.auUpdatedDt = auUpdatedDt;
    }
    public Date getAuUpdatedDt() {
        return this.auUpdatedDt;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setSchool( SchoolEntity school ) {
        this.school = school;
    }
    public SchoolEntity getSchool() {
        return this.school;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(year);
        sb.append("|");
        sb.append(studentCount);
        sb.append("|");
        sb.append(avgClassSize);
        sb.append("|");
        sb.append(ratio);
        sb.append("|");
        sb.append(avgSatScore);
        sb.append("|");
        sb.append(avgActScore);
        sb.append("|");
        sb.append(tuition);
        sb.append("|");
        sb.append(auCreatedDt);
        sb.append("|");
        sb.append(auUpdatedDt);
        return sb.toString(); 
    } 

}
