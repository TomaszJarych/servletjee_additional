package pl.coderslab.filterDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pl.coderslab.filter.entities.FilterInfo;

public class FilterInfoDao {
	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "coderslab";
	private static final String INSERT_DATA = "INSERT INTO servletJDBC.filter_info (browser_info,date_time,parameters,execution_time) VALUES(?,?,?,?)";

public void insertFilter (FilterInfo filterinfo){
	try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)){
		PreparedStatement preparedStatement = conn.prepareStatement(INSERT_DATA);
		preparedStatement.setString(1, filterinfo.getBrowserInfo());
		preparedStatement.setDate(2, filterinfo.getDateTime());
		preparedStatement.setString(3, filterinfo.getParameters());
		preparedStatement.setLong(4, filterinfo.getExecutionTime());
		preparedStatement.execute();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}