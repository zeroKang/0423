package org.zerock.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;
import org.zerock.dao.AIADataSource;

import lombok.extern.log4j.Log4j;

@Log4j
public class ConnTest {
	
	
	
	
	
	

	@Test
	public void testOut() throws Exception {

		log.info("testOut");

		// DriverClass 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// JDBC Connection 연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "aia1";
		String pw = "aia1";

		for (int i = 0; i < 100; i++) {

			new Thread(() -> {
				try {

					System.out.println("COOUNT:");

					Connection con = DriverManager.getConnection(url, user, pw);

					System.out.println(con);
//					
//					PreparedStatement pstmt = con.prepareStatement("select sysdate from dual");
//					
//					ResultSet rs = pstmt.executeQuery();
//					
//					rs.next();
//					
//					System.out.println(rs.getString(1));
//					
//					//Thread.sleep(5000);
//					
//					//close
//					rs.close();
//					pstmt.close();
					con.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();

			Thread.sleep(500);

		} // end for

	}

	@Test
	public void testJDBC() throws Exception {
		// DriverClass 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// JDBC Connection 연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "aia1";
		String pw = "aia1";

		long start = System.currentTimeMillis();

		for (int i = 0; i < 1000; i++) {

			try (Connection con = DriverManager.getConnection(url, user, pw);
					PreparedStatement pstmt = con.prepareStatement("select sysdate from dual");
					ResultSet rs = pstmt.executeQuery();) {
				rs.next();
				log.info(rs.getString(1));
				log.info(con);
			}
		}

		long end = System.currentTimeMillis();

		log.info("TIME: " + (end - start));

	}

	@Test
	public void testHikari() throws Exception{


		long start = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {

			try (Connection con = AIADataSource.getConnection();
					PreparedStatement pstmt = con.prepareStatement("select sysdate from dual");
					ResultSet rs = pstmt.executeQuery();) {
				rs.next();
				log.info(rs.getString(1));
				log.info(con);
			}
		}

		long end = System.currentTimeMillis();

		log.info("TIME: " + (end - start));

	}
}
