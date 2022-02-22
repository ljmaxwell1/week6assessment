package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Children;
/*

/**
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *Feb 15, 2022
 **/
//package and import statements
public class ChildrenHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
public void insertChildren(Children s) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(s);
	em.getTransaction().commit();
	em.close();
}
public List<Children> showAllChildrens() {
	EntityManager em = emfactory.createEntityManager();
	List<Children> allChildrens = em.createQuery("SELECT s FROM Children s").getResultList();
	return allChildrens;
}
public Children findChildren(String nameToLookUp) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<Children> typedQuery = em.createQuery("select sh from Children sh where sh.childrenName = :selectedName",Children.class);
	typedQuery.setParameter("selectedName", nameToLookUp);
	typedQuery.setMaxResults(1);
	Children foundChildren;
	try {
		foundChildren = typedQuery.getSingleResult();
	} catch (NoResultException ex) {
		foundChildren = new Children(nameToLookUp);
	}
	em.close();
	return foundChildren;
}
}
