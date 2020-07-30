package restaurantapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurantapp.model.AdminUserEntity;
import restaurantapp.model.LoginAdminLogic;
import restaurantapp.model.LoginEntity;

/**
 * Servlet implementation class LoginController
 */
public class LoginAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginAdminController:doGet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginAdminController:doPost");
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");

		LoginEntity loginEntity = new LoginEntity(userId, password);
		LoginAdminLogic loginAdminLogic = new LoginAdminLogic(loginEntity);
		AdminUserEntity adminUserEntity = loginAdminLogic.searchAdminUser();

		if(adminUserEntity == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginNG.jsp");
			dispatcher.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("adminUserEntity", adminUserEntity);

		response.sendRedirect("/restaurantapp/AdminHomeController");

	}

}
