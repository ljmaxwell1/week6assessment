import java.util.List;

import controller.ChildrenHelper;
import model.Children;

/**
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *Feb 15, 2022
 **/
public class ChildrenTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Children bill = new Children("Bill");
		Children jim = new Children("Jim");
		ChildrenHelper sh = new ChildrenHelper();
		sh.insertChildren(bill);
		sh.insertChildren(jim);
		List<Children> allChildrens = sh.showAllChildrens();
		for(Children a: allChildrens) {
		System.out.println(a.toString());
		}
	}

}

