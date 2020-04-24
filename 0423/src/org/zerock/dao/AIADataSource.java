package org.zerock.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class AIADataSource {

	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds;

	static {

		config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		config.setUsername("aia1");
		config.setPassword("aia1");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}

	private AIADataSource() {}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

}
