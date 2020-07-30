package restaurantapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurantapp.model.SearchVacantLogic;
import restaurantapp.model.VacantData;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		System.out.println("SearchController:doPost");
		request.setCharacterEncoding("UTF-8");
		String requestTime = request.getParameter("time");
		String requestNumberOfPeople = request.getParameter("numofpeople");

		SearchVacantLogic svl = new SearchVacantLogic( Integer.parseInt(requestNumberOfPeople), requestTime );
		VacantData vde = svl.searchData();

		if(vde != null) {
			HttpSession session = request.getSession();
			session.setAttribute("vacantDataEntity", vde);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/result.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
