package estateapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import estateapp.model.entity.RentalProperty;
import estateapp.model.logic.RentalPropertySearchLogic;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String minRentFee = request.getParameter("min_money"); // 賃料下限
		String maxRentFee = request.getParameter("max_money"); // 賃料上限
		String includingManagementFee = request.getParameter("expense"); // 管理費込み
		String hasNoDeposit = request.getParameter("deposit"); // 敷金無し
		String hasNoKeyMoney = request.getParameter("key_money"); // 礼金なし
		String minAreaSquareMeter = request.getParameter("min_area"); // 面積下限
		String maxAreaSquareMeter = request.getParameter("max_area"); // 面積上限
		String isOneRoom= request.getParameter("layout_0"); // 間取り
		String is1K = request.getParameter("layout_1"); // 間取り
		String is1DK = request.getParameter("layout_2"); // 間取り
		String is1LDK = request.getParameter("layout_3"); // 間取り
		String is2K = request.getParameter("layout_4"); // 間取り
		String is2DK = request.getParameter("layout_5"); // 間取り
		String is2LDK = request.getParameter("layout_6"); // 間取り
		String is3K = request.getParameter("layout_7"); // 間取り
		String is3DK = request.getParameter("layout_8"); // 間取り
		String is3LDK = request.getParameter("layout_9"); // 間取り
		String is4K = request.getParameter("layout_10"); // 間取り
		String is4DK = request.getParameter("layout_11"); // 間取り
		String is4LDK = request.getParameter("layout_12"); // 間取り
		String is5K = request.getParameter("layout_13");
		String walkingTimeMin = request.getParameter("walk"); // 徒歩
		String ageYear = request.getParameter("age");
		String isSeparatedBathToilet = request.getParameter("preferences_0"); // バストイレ別
		String isUpperSecondFloor = request.getParameter("preferences_1"); // 2階以上
		String hasWasherSpace = request.getParameter("preferences_2"); // 室内洗濯機置き場
		String hasAircon = request.getParameter("preferences_3"); // エアコン
		String hasParking = request.getParameter("preferences_4"); // 駐車場有
		String hasAutoLock = request.getParameter("preferences_5"); // オートロック
		String hasReheat = request.getParameter("preferences_6"); // 追い炊き
		String canHavePet = request.getParameter("preferences_7"); // ペット相談可

		RentalPropertySearchLogic rpsl =
			new RentalPropertySearchLogic
				(minRentFee, maxRentFee, includingManagementFee, hasNoDeposit, hasNoKeyMoney,
				minAreaSquareMeter, maxAreaSquareMeter, isOneRoom, is1K, is1DK,
				is1LDK, is2K, is2DK, is2LDK, is3K,
				is3DK, is3LDK, is4K, is4DK, is4LDK,
				is5K, walkingTimeMin, ageYear, isSeparatedBathToilet, isUpperSecondFloor, hasWasherSpace,
				hasAircon, hasParking, hasAutoLock, hasReheat, canHavePet
				);
		List<RentalProperty> rpList = rpsl.search();

		request.setAttribute("rentalPropertyList", rpList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);

	}

}
