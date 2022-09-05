package connectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public interface MyConnectionUtil {
	
	Connection getConnection() throws SQLException, ClassNotFoundException;
	
	void free(Connection conn) throws SQLException;
}
