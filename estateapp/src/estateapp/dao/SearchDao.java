package estateapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estateapp.model.entity.RentalProperty;
import estateapp.model.logic.RentalPropertySearchLogic;

public class SearchDao {

	public List<RentalProperty> search(RentalPropertySearchLogic rpsl) {
		Connection conn = null;
		List<RentalProperty> rpList = new ArrayList<RentalProperty>();

		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost/", "root", "sato1129");

			String sql = "select * from estateapp.rental_property where ";

			// 賃貸料
			// フラグでの区別はデータ取得後に行う
			sql += "(rent_fee_yen between " + rpsl.getMinRentFeeYen() + " and " + rpsl.getMaxRentFeeYen() + ") and ";

			// 面積
			sql += "(area_squaremeter between " + rpsl.getMinAreaSquareMeter() + " and " + rpsl.getMaxAreaSquareMeter() + ") and ";

			// 間取り
			if(rpsl.getLayoutSearchList().size() != 0) {
				sql += "(layout in (";
				int i = 0;
				for(int layout : rpsl.getLayoutSearchList()) {
					sql += layout ;
					i++;
					if( i < rpsl.getLayoutSearchList().size() )
						sql +=  ", ";
				}
				sql += ")) and ";
			}

			// 徒歩
			sql += "(walk_min between 0 and " + rpsl.getWalkingTimeMin() + ") and ";

			// 築年数
			sql += "(age_year between 0 and " + rpsl.getAgeYear() + ")";

			// バストイレ別
			if(rpsl.isSeparatedBathToilet())
				sql += " and (is_separated_bath_toilet = true )";

			// 2階以上
			if(rpsl.isUpperSecondFloor())
				sql += " and (floor >= 2)";

			// 洗濯機置き場
			if(rpsl.isHasWasherSpace())
				sql += " and (has_washer_space = true)";

			// エアコン有
			if(rpsl.isHasAircon())
				sql += " and (has_aircon = true)";

			// 駐車場有
			if(rpsl.isHasParking())
				sql += " and (has_aircon = true)";

			// オートロック
			if(rpsl.isHasAutoLock())
				sql += " and (has_autolock = true)";

			// 追い炊き
			if(rpsl.isHasReheat())
				sql += " and (has_reheat_bath = true)";

			// ペット可
			if(rpsl.isCanHavePet())
				sql += " and (can_Have_Pet = true)";


			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				RentalProperty rp = new RentalProperty();
				rp.setEstateId(rs.getInt("estate_id"));
				rp.setEstateName( rs.getString("estate_name") );
				rp.setBuilding_floors( rs.getInt("building_floors") );
				rp.setFloor( rs.getInt("floor") );
				rp.setRentFeeYen(rs.getInt("rent_fee_yen"));
				rp.setManagementFeeYen( rs.getInt("manegement_fee_yen") );
				rp.setDepositYen( rs.getInt("deposit_yen") );
				rp.setKeyMoneyYen(rs.getInt("key_money_yen"));
				rp.setExMoney1Yen(rs.getInt("ex_money1_yen"));
				rp.setExMoney2Yen(rs.getInt("ex_money2_yen"));
				rp.setNearStation(rs.getString("near_station"));
				rp.setWalkTimeMin(rs.getInt("walk_min"));
				rp.setAddress(rs.getString("address"));
				rp.setAgeYear(rs.getInt("age_year"));

				String layout;
				switch(rs.getInt("layout")) {
				case 0:
					layout = "ワンルーム";
					break;
				case 1:
					layout = "1K";
					break;
				case 2:
					layout = "1DK";
					break;
				case 3:
					layout = "1LDK";
					break;
				case 4:
					layout = "2K";
					break;
				case 5:
					layout = "2DK";
					break;
				case 6:
					layout = "2LDK";
					break;
				case 7:
					layout = "3K";
					break;
				case 8:
					layout = "3DK";
					break;
				case 9:
					layout = "3LDK";
					break;
				case 10:
					layout = "4K";
					break;
				case 11:
					layout = "4DK";
					break;
				case 12:
					layout = "4LDK";
					break;
				case 13:
					layout = "5K";
					break;
				default:
					layout = "ワンルーム";
					break;
				}
				rp.setLayout(layout);
				rp.setAreaSqureMeter(rs.getInt("area_squaremeter"));
				rp.setSeparatedBathToilet(rs.getBoolean("is_separated_bath_toilet"));
				rp.setHasReheatBath(rs.getBoolean("has_reheat_bath"));
				rp.setHasBathDryer(rs.getBoolean("has_bath_dryer"));
				rp.setHasAircon(rs.getBoolean("has_aircon"));
				rp.setHasCarParking(rs.getBoolean("has_car_parking"));
				rp.setHasAutolock(rs.getBoolean("has_autolock"));
				rp.setCanHavePet(rs.getBoolean("can_Have_Pet"));

				rpList.add(rp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// DB切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return rpList;
	}
}
