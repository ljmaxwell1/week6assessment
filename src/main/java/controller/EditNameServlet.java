package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListName;

/**
 * Servlet implementation class EditNameServlet
 */
@WebServlet("/EditNameServlet")
public class EditNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNameServlet() {
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
		ListNameHelper dao = new ListNameHelper();
		
		String store = request.getParameter("store");
		String item = request.getParameter("item");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		ListName itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setGivenName(item);
		itemToUpdate.setFamilyName(store);
				
		dao.updateName(itemToUpdate);

		getServletContext().getRequestDispatcher("/ViewAllItemsServlet").forward(request, response);

	}

}
