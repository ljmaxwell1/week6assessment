import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ChildrenHelper;
import model.ListDetails;
import model.ListName;
import model.Children;

/**
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *Feb 15, 2022
 **/
public class ListDetailsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Children cameron = new Children("Cameron");
		//ShopperHelper sh = new ShopperHelper();
	//	sh.insertShopper(cameron);
		
		ListName shampoo = new ListName("Target", "Shampoo");
		ListName brush = new ListName("Target", "Brush");
		
		List<ListName> cameronsItems = new ArrayList<ListName>();
		cameronsItems.add(shampoo);
		cameronsItems.add(brush);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails cameronsList = new ListDetails("Cameron's List",	LocalDate.now(), cameron);
		ldh.insertNewListDetails(cameronsList);
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
		System.out.println(a.toString());
		}
	}
}
