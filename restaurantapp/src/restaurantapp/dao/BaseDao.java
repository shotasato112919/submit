package restaurantapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	/* JDBCドライバ名 */
	private static final String JDBC_DRIVER_NAME = "org.mariadb.jdbc.Driver";
	// DBの接続先URL
	private static final String CONNECTION_URL = "jdbc:mariadb://localhost/";
	// DB接続時のユーザーID
	private static final String CONNECTION_USER = "root";
	// DB接続時のパスワード
	private static final String CONNECTION_PASSWORD = "sato1129";
	// DBへの接続
	protected Connection conn = null;

	// DBへ接続する
	protected boolean open()  {
		System.out.println("BaseDao:open");
		boolean result = false;
		try {
			Class.forName(JDBC_DRIVER_NAME);
	        conn = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
	        conn.setAutoCommit(true);
	        result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	// DBへの接続を終了する
	protected boolean close() {
		System.out.println("BaseDao:close");
		boolean result = false;
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
			result = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
