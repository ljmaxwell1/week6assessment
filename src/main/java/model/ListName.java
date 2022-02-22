package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *${date}
 **/

@Entity
@Table(name="people")
public class ListName{
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="FAMILY")
	private String familyName;
	@Column(name="GIVEN")
	private String givenName;
	
	public ListName() {
		super();
	}
	
	public ListName(String familyName, String givenName) {
		super();
		this.familyName = familyName;
		this.givenName = givenName;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String returnNameDetails() {
		return this.familyName + ", " + this.givenName;
	}
	
}
