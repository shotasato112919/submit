package restaurantapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import restaurantapp.model.AdminUserEntity;
import restaurantapp.model.LoginEntity;

public class AdminUserDao extends BaseDao{
	public AdminUserDao() {

	}

	public AdminUserEntity searchAdminUser(LoginEntity login) {
		System.out.println("AdminUserDao:searchAdminUser");
		AdminUserEntity adminUserEntity = null;
		try {
			open();
			if(conn == null)
				return null;

			String sql = "SELECT * FROM restaurantapp.admin_table "
					+ "WHERE ( user_id = '"+  login.getUserId() + "') "
					+ "AND ( password = '" + login.getPassword() + "')";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				adminUserEntity = new AdminUserEntity(rs.getString("user_id"),null);
				return adminUserEntity;
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
}
