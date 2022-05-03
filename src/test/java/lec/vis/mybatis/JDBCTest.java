package lec.vis.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Assert;
import org.junit.Test;
import lombok.extern.log4j.Log4j;


@Log4j
public class JDBCTest {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "spring";
		String password = "spring";

		try (Connection con = DriverManager.getConnection(url, username, password)) {
			System.out.println(con);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
		
}
}
