package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.ListName;

/**
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *Feb 1, 2022
 **/

public class ListNameHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");

public void insertName(ListName li) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();em.persist(li);
	em.getTransaction().commit();
	em.close();
}	

public List<ListName>showAllNames() {
	EntityManager em = emfactory.createEntityManager();
	List<ListName>allItems = em.createQuery("SELECT i FROM ListName i").getResultList();
	return allItems;
}

public void deleteName(ListName toDelete) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListName> typedQuery = em.createQuery("select li from ListName li where li.familyName = :familyName and li.givenName = :givenName",ListName.class);
	//Substitute parameter with actual data from the toDelete item
	typedQuery.setParameter("familyName", toDelete.getFamilyName());
	typedQuery.setParameter("givenName", toDelete.getGivenName());
	//we only want one result
	typedQuery.setMaxResults(1);
	//get the result and save it into a new list item
	ListName result = typedQuery.getSingleResult();
	//remove it
	em.remove(result);
	em.getTransaction().commit();
	em.close();
}

public ListName searchForItemById(int idToEdit) {
	// TODO Auto-generated method stub
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	ListName found = em.find(ListName.class, idToEdit);
	em.close();
	return found;
}

public void updateName(ListName toEdit) {
	// TODO Auto-generated method stub
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();
}

public List<ListName> searchForFamilyName(String familyName) {
	// TODO Auto-generated method stub
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListName> typedQuery = em.createQuery("select li from ListName li where li.familyName = :selectedStore", ListName.class);
	typedQuery.setParameter("selectedStore", familyName);
	List<ListName> foundItems = typedQuery.getResultList();
	em.close();
	return foundItems;
}

public List<ListName> searchForGivenName(String givenName) {
	// TODO Auto-generated method stub
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListName> typedQuery = em.createQuery("select li from ListName li where li.givenName = :selectedItem", ListName.class);
	typedQuery.setParameter("selectedItem", givenName);
	List<ListName> foundItems = typedQuery.getResultList();
	em.close();
	return foundItems;
}
public void cleanUp(){
	emfactory.close();
}
}