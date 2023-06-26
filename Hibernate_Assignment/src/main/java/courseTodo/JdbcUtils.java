package courseTodo;

import java.sql.DriverManager;
import java.sql.Connection;

public class JdbcUtils {
	
	public static Connection buildConnection() throws Exception {
		
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String URL = "jdbc:mysql://localhost:3306/navimumbai?useSSL=false";
        String Username = "tejas";
        String Password = "tejasm";
        Connection dbConnection =DriverManager.getConnection(URL, Username, Password);
        return dbConnection;

}

	
}
