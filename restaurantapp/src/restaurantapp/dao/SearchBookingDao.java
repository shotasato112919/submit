package restaurantapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import restaurantapp.model.BookingEntity;



public class SearchBookingDao extends BaseDao {

	public SearchBookingDao() {

	}

	public List<BookingEntity> getBookingEntityList(LocalDateTime currentldt) {
		System.out.println("SearchBookingDao:getBookingEntityList");
		List<BookingEntity> bookingEntityList = null;

		try {
			if(open()) {
				String sql = makeSql(currentldt);
				PreparedStatement pStmt = conn.prepareStatement(sql);
				ResultSet rs = pStmt.executeQuery();

				bookingEntityList = new ArrayList<BookingEntity>();
				while(rs.next()) {
					int bookingId = rs.getInt("booking_id");
					String bookingName = rs.getString("booking_name");
					int numberOfPeople = rs.getInt("number_of_people");
					int bookingTableTaku = rs.getInt("booking_tabletaku");

					java.sql.Timestamp bookingDateStamp = rs.getTimestamp("booking_date");
					LocalDateTime bookingDate = bookingDateStamp.toLocalDateTime();

					int courseMeal = rs.getInt("course_meal");

					java.sql.Timestamp startTimeStamp = rs.getTimestamp("start_time");
					LocalDateTime startTime = startTimeStamp.toLocalDateTime();

					java.sql.Timestamp endTimeStamp = rs.getTimestamp("end_time");
					LocalDateTime endTime = endTimeStamp.toLocalDateTime();


					BookingEntity be = new BookingEntity(
							bookingId,
							bookingName,
							numberOfPeople,
							bookingTableTaku,
							bookingDate,
							courseMeal,
							startTime,
							endTime
							);
					bookingEntityList.add(be);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return bookingEntityList;
	}

	private String makeSql(LocalDateTime currentldt) {
		System.out.println("SearchBookingDao:makeSql");

		String datetime = currentldt.getYear() + "-"
					+ currentldt.getMonthValue() + "-"
					+ currentldt.getDayOfMonth();

		String sql = "SELECT * FROM restaurantapp.booking_table "
				+ "WHERE booking_date >= '" + datetime + "' "
				+ "ORDER BY booking_date ASC, start_time ASC";

		return sql;
	}
}
