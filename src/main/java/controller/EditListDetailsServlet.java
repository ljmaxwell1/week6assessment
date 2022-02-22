package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Children;
import model.ListDetails;
import model.ListName;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/EditListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		ListNameHelper lih = new ListNameHelper();
		ChildrenHelper sh = new ChildrenHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String childrenName = request.getParameter("childrenName");
		//find our add the new shopper
		Children newChildren = sh.findChildren(childrenName);
		LocalDate ld;
		try {
		ld = LocalDate.of(Integer.parseInt(year),
		Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
		ld = LocalDate.now();
		}
		try {
		//items are selected in list to add
		String[] selectedItems =
		request.getParameterValues("allItemsToAdd");
		List<ListName> selectedItemsInList = new ArrayList<ListName>();
		for (int i = 0; i < selectedItems.length; i++) {
		System.out .println(selectedItems[i]);
		ListName c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));                    //ListItem
		selectedItemsInList.add(c);
		}
		listToUpdate.setListOfItems(selectedItemsInList);
		} catch (NullPointerException ex) {
		// no items selected in list - set to an empty list
		List<ListName> selectedItemsInList = new ArrayList<ListName>();
		listToUpdate.setListOfItems(selectedItemsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setTripDate(ld);
		listToUpdate.setChildren(newChildren);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
	}

}
