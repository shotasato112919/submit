package restaurantapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurantapp.model.BookingLogic;

/**
 * Servlet implementation class ResultController
 */
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ResultController:doPost");

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String dateTime = request.getParameter("date");

		HttpSession session = request.getSession();
		session.setAttribute("formName", name);
		session.setAttribute("formDateTime", dateTime);

		BookingLogic bl = new BookingLogic(name, dateTime);

		session.setAttribute("bookingName", bl.getName());
		session.setAttribute("bookingDate", bl.getDate());
		session.setAttribute("bookingTime", bl.getStartTime());
		session.setAttribute("bookingNum", (Integer)bl.getNumOfPeople());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/bookingConfirm.jsp");
		dispatcher.forward(request, response);
	}

}
