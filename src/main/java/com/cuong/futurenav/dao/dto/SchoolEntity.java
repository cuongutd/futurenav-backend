/*
 * Created on 24 Nov 2015 ( Time 13:51:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.cuong.futurenav.dao.dto;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "school"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="school", catalog="dev2" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="SchoolEntity.countAll", query="SELECT COUNT(x) FROM SchoolEntity x" )
} )
public class SchoolEntity implements Serializable {

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

    @Column(name="type", length=200)
    private String     type         ;

    @Column(name="grades", length=100)
    private String     grades       ;

    @Column(name="city", length=100)
    private String     city         ;

    @Column(name="state", length=100)
    private String     state        ;

    @Column(name="latitude")
    private Double     latitude     ;

    @Column(name="longitude")
    private Double     longitude    ;

    @Column(name="wikipageid", length=20)
    private String     wikipageid   ;

    @Column(name="wikirevisionid", length=20)
    private String     wikirevisionid ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="au_created_dt", nullable=false, updatable=false, insertable=false)
    private Date       auCreatedDt  ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="au_updated_dt", nullable=false, updatable=false, insertable=false)
    private Date       auUpdatedDt  ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //@OneToMany(mappedBy="school", targetEntity=FavSchoolEntity.class, fetch = FetchType.EAGER)
    //private List<FavSchoolEntity> listOfFavSchool;

    @OneToMany(mappedBy="school", targetEntity=SchoolPropertiesEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<SchoolPropertiesEntity> listOfSchoolProperties;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public SchoolEntity() {
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

    //--- DATABASE MAPPING : type ( VARCHAR ) 
    public void setType( String type ) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    //--- DATABASE MAPPING : grades ( VARCHAR ) 
    public void setGrades( String grades ) {
        this.grades = grades;
    }
    public String getGrades() {
        return this.grades;
    }

    //--- DATABASE MAPPING : city ( VARCHAR ) 
    public void setCity( String city ) {
        this.city = city;
    }
    public String getCity() {
        return this.city;
    }

    //--- DATABASE MAPPING : state ( VARCHAR ) 
    public void setState( String state ) {
        this.state = state;
    }
    public String getState() {
        return this.state;
    }

    //--- DATABASE MAPPING : latitude ( DOUBLE ) 
    public void setLatitude( Double latitude ) {
        this.latitude = latitude;
    }
    public Double getLatitude() {
        return this.latitude;
    }

    //--- DATABASE MAPPING : longitude ( DOUBLE ) 
    public void setLongitude( Double longitude ) {
        this.longitude = longitude;
    }
    public Double getLongitude() {
        return this.longitude;
    }

    //--- DATABASE MAPPING : wikipageid ( VARCHAR ) 
    public void setWikipageid( String wikipageid ) {
        this.wikipageid = wikipageid;
    }
    public String getWikipageid() {
        return this.wikipageid;
    }

    //--- DATABASE MAPPING : wikirevisionid ( VARCHAR ) 
    public void setWikirevisionid( String wikirevisionid ) {
        this.wikirevisionid = wikirevisionid;
    }
    public String getWikirevisionid() {
        return this.wikirevisionid;
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
//    public void setListOfFavSchool( List<FavSchoolEntity> listOfFavSchool ) {
//        this.listOfFavSchool = listOfFavSchool;
//    }
//    public List<FavSchoolEntity> getListOfFavSchool() {
//        return this.listOfFavSchool;
//    }

    public void setListOfSchoolProperties( List<SchoolPropertiesEntity> listOfSchoolProperties ) {
        this.listOfSchoolProperties = listOfSchoolProperties;
    }
    public List<SchoolPropertiesEntity> getListOfSchoolProperties() {
        return this.listOfSchoolProperties;
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
        sb.append(type);
        sb.append("|");
        sb.append(grades);
        sb.append("|");
        sb.append(city);
        sb.append("|");
        sb.append(state);
        sb.append("|");
        sb.append(latitude);
        sb.append("|");
        sb.append(longitude);
        sb.append("|");
        sb.append(wikipageid);
        sb.append("|");
        sb.append(wikirevisionid);
        sb.append("|");
        sb.append(auCreatedDt);
        sb.append("|");
        sb.append(auUpdatedDt);
        return sb.toString(); 
    } 

}
