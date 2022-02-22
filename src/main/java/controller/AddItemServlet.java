package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListName;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String familyName = request.getParameter("store");
		String givenName = request.getParameter("item");
		System.out.println(familyName);
		System.out.println(givenName);
		if (familyName.isEmpty() || givenName.isEmpty() || familyName == null || givenName == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			ListName li = new ListName(familyName, givenName);
			ListNameHelper dao = new ListNameHelper();
			dao.insertName(li);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
