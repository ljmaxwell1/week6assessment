package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *Feb 15, 2022
 **/
// package and import statements
@Entity
@Table(name="children")
public class Children {
	@Id
	@GeneratedValue
	private int id;
	private String childrenName;
	public Children() {
	super();
	// TODO Auto-generated constructor stub
	}
	public Children(int id, String childrenName) {
	super();
	this.id = id;
	this.childrenName = childrenName;
	}
	public Children(String childrenName) {
	super();
	this.childrenName = childrenName;
	}
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getChildrenName() {
	return childrenName;
	}
	public void setChildrenName(String childrenName) {
	this.childrenName = childrenName;
	}
	@Override
	public String toString() {
	return "Children [id=" + id + ", childrenName=" +
			childrenName + "]";
	}
	
}

