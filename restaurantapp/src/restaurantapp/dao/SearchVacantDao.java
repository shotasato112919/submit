package restaurantapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchVacantDao extends BaseDao{

	private String[] searchTablesArray; // 検索するテーブル卓のリスト
	private LocalDateTime searchLdt;
	private int searchPeriodDays;
	private Map<LocalDateTime, List<String>> searchTableTakuSql;

	public SearchVacantDao(String[] sta, LocalDateTime sldt, int searchPeriodDays) {
		this.searchTablesArray = sta;
		this.searchLdt = sldt;
		this.searchPeriodDays = searchPeriodDays;
		this.searchTableTakuSql = makeSqls();
	}

	public Map<LocalDateTime, Integer> countVacant() {
		System.out.println("SearchVacantDao:countVacant");
		Map<LocalDateTime, Integer> vacantDateNum = new TreeMap<LocalDateTime, Integer>();
		try {
			if(open()) {
				for(Map.Entry<LocalDateTime, List<String>> entry : this.searchTableTakuSql.entrySet()) {
					vacantDateNum.put(entry.getKey(), 0);
					for(String sql : entry.getValue()) {
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rs = pStmt.executeQuery();

						if(rs.next()) {
							int i = vacantDateNum.get(entry.getKey());
							vacantDateNum.replace(entry.getKey(), ++i);
						}
					}
				}
			} else {
				vacantDateNum = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return  null;
		}  finally {
			// DB切断
			close();
		}
		return vacantDateNum;
	}

	private Map<LocalDateTime, List<String>> makeSqls() {
		System.out.println("SearchVacant:makeSqls");
		LocalDateTime startLdt = getCopyOfSearchLdt();
		LocalDateTime endLdt = getEndTimeOfSearchLdt();

		Map<LocalDateTime, List<String>> TableTakuSql = new TreeMap<LocalDateTime, List<String>>();

		// 検索するテーブル卓をチェック
		for(int i = 0; i < searchPeriodDays; i++) {
			LocalDateTime start = startLdt.plusDays(i);
			LocalDateTime end = endLdt.plusDays(i);
			TableTakuSql.put(start, new ArrayList<String>());
			for(String tabletaku : searchTablesArray) {

				String sql = "SELECT * FROM " + "restaurantapp.booking_table "+
						"WHERE " + "(booking_tabletaku = " + tabletaku + " ) " +
						"AND " + "(booking_date = " + getDateInSql(start) + ")" + " " +
						"AND " + "((end_time < " + getTimeInSql(start) + ") " +
							"OR " + "(" + getTimeInSql(end) + " >= " + "start_time))";
				TableTakuSql.get(start).add(sql);
			}
		}
		return TableTakuSql;
	}


	private LocalDateTime getCopyOfSearchLdt() {
		return LocalDateTime.of(searchLdt.getYear(), searchLdt.getMonthValue(), searchLdt.getDayOfMonth(), searchLdt.getHour(), searchLdt.getMinute(), searchLdt.getSecond());
	}

	private LocalDateTime getEndTimeOfSearchLdt() {
		// TO DO
		LocalDateTime endtimeLdt = searchLdt.plusHours(2);
		//return LocalDateTime.of(searchLdt.getYear(), searchLdt.getMonthValue(), searchLdt.getDayOfMonth(), searchLdt.getHour() + 2, searchLdt.getMinute(), searchLdt.getSecond());
		return endtimeLdt;
	}

	private String getDateInSql(LocalDateTime ldt) {
		return "'" + ldt.getYear() + "-" + ldt.getMonthValue() + "-" + ldt.getDayOfMonth() + "'";
	}

	private String getTimeInSql(LocalDateTime ldt) {
		return "'" + ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond() + "'";
	}


	public void daoTest() throws ClassNotFoundException, SQLException {
		try {
			open();
			String sql = "Select * from test.test_table where id = 2";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {

				java.sql.Date sqlDate  = rs.getDate("date");
				java.sql.Time sqlTime =  rs.getTime("time");

				java.sql.Timestamp sqlTStamp = rs.getTimestamp("datetime");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String str = sdf.format(sqlTStamp);

				System.out.println(sqlDate);
				System.out.println(sqlTime);
				System.out.println(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}  finally {
			// DB切断
			close();

		}
	}
}
