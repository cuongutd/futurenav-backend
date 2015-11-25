/*
 * Created on 24 Nov 2015 ( Time 13:51:42 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.cuong.futurenav.dao.dto;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "school_properties"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="school_properties", catalog="dev2" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="SchoolPropertiesEntity.countAll", query="SELECT COUNT(x) FROM SchoolPropertiesEntity x" )
} )
public class SchoolPropertiesEntity implements Serializable {

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
    @Column(name="name", nullable=false, length=200)
    private String     name         ;

    @Column(name="value", nullable=false, length=4000)
    private String     value        ;

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
    public SchoolPropertiesEntity() {
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
    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : value ( VARCHAR ) 
    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
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