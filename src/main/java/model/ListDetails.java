package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *Feb 15, 2022
 **/
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String familyName;
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Children children;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListName> listOfItems;
	
	public ListDetails() {
		super();
	}

	public ListDetails(int id, String familyName, LocalDate tripDate, Children children, List<ListName> listOfItems) {
		super();
		this.id = id;
		this.familyName = familyName;
		this.tripDate = tripDate;
		this.children = children;
		this.listOfItems = listOfItems;
	}
	
	public ListDetails(String familyName, LocalDate tripDate, Children children, List<ListName> listOfItems) {
		super();
		this.familyName = familyName;
		this.tripDate = tripDate;
		this.children = children;
		this.listOfItems = listOfItems;
	}
	
	public ListDetails(String familyName, LocalDate tripDate, Children children) {
		super();
		this.familyName = familyName;
		this.tripDate = tripDate;
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return familyName;
	}

	public void setListName(String familyName) {
		this.familyName = familyName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public List<ListName> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<ListName> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", familyName=" + familyName + ", tripDate=" + tripDate + ", children=" + children
				+ ", listOfItems=" + listOfItems + "]";
	}
	
}
