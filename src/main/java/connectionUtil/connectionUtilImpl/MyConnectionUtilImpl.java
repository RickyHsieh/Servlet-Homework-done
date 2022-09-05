package connectionUtil.connectionUtilImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import connectionUtil.MyConnectionUtil;

public class MyConnectionUtilImpl implements MyConnectionUtil {
	
	private String URL = "jdbc:oracle:thin:@//61.216.84.220:1534/XE";
	private String Username = "DEMO";
	private String pwd = "123456";

	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(URL, Username, pwd);
		return conn;
	}

	@Override
	public void free(Connection conn) throws SQLException {
		if (conn!=null) {
			if (!conn.isClosed()) {
				conn.close();
			}
		}
	}

}
