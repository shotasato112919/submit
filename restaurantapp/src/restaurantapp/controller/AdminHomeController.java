package restaurantapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurantapp.model.AdminUserEntity;
import restaurantapp.model.BookingEntity;
import restaurantapp.model.BookingListLogic;

/**
 * Servlet implementation class AdminHomeController
 */
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminHomeController:doGet");

		HttpSession session = request.getSession();
		AdminUserEntity adminUserEntity = (AdminUserEntity)session.getAttribute("adminUserEntity");

		if(adminUserEntity == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
			dispatcher.forward(request, response);
			return;
		}

		BookingListLogic bll = new BookingListLogic();
		List<BookingEntity> bookingEntityList =  bll.getBookingList();

		session.setAttribute("bookingEntityList", bookingEntityList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminHomeController:doPost");
	}
}
