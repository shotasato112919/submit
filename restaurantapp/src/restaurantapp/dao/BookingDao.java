package restaurantapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDao extends BaseDao {
	String name;
	String date;
	String startTime;
	String endTime;
	String[] searchTables;
	int numOfPeople;

	List<String> searchSqlList;
	String insertSql;

	public BookingDao(String name, String date, String startTime, String endTime, int numOfPeople, String[] searchTables) {
		System.out.println("bookingDao");
		this.name = name;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.searchTables = searchTables;
		this.numOfPeople = numOfPeople;
		makeSearchSql();
		this.insertSql = makeInsertSql();
	}

	public boolean makeBooking() {
		System.out.println("BookingDao:makeBooking");
		if(this.insertSql == null)
			return false;

		try {
			if(open()) {
				PreparedStatement pStmt1 = conn.prepareStatement("use restaurantapp");
				pStmt1.executeQuery();
				PreparedStatement pStmt2 = conn.prepareStatement(this.insertSql);
				ResultSet rs = pStmt2.executeQuery();
			}
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		} finally {
			close();
		}
		return true;
	}

	public void makeSearchSql() {
		System.out.println("BookingDao:makeSearchSql");
		searchSqlList = new ArrayList<String>();
		for(String tabletaku : searchTables) {
			String sql = "SELECT * FROM " + "restaurantapp.booking_table "+
					"WHERE " + "(booking_tabletaku = " + tabletaku + " ) " +
					"AND " + "(booking_date = '" + date + "')" + " " +
					"AND " + "((end_time < '" + startTime + "') " +
						"OR " + "('" + endTime + "' > " + "start_time))";
			searchSqlList.add(sql);
		}

	}

	private int searchVacant() {
		int index = 0;
		try {
			if(open()) {

				for(String sql : searchSqlList) {

					PreparedStatement pStmt = conn.prepareStatement(sql);
					ResultSet rs = pStmt.executeQuery();

					if(!rs.next()) {
						return index;
					}
					index++;
				}
				return -1;
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}  finally {
			// DB切断
			close();
		}
	}

	public String makeInsertSql() {
		String sql;
		if(name.equals(""))
			name = "名無し";

		int index = searchVacant();

		if(index < 0)
			return null;


		sql = "INSERT INTO `booking_table`"
				+ "(`booking_id`, `booking_name`, `number_of_people`, `booking_tabletaku`, `booking_date`, `course_meal`, `start_time`, `end_time`)"
				+ "VALUES"
				+ "(NULL,"
				+ "'" + this.name + "', '"
				+ this.numOfPeople + "', '"
				+ this.searchTables[index] + "', '"
				+ this.date + "', '"
				+ 0 + "', '"
				+ this.startTime + "', '"
				+ this.endTime + "')";

		return sql;
	}
}
