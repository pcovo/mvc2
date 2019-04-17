package br.com.ccee.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.ccee.CCEERuntimeException;

public final class ConnectionFactory {

	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	
	static {
		try {
			Class.forName(rb.getString("class.forName.oracle"));
		} catch (ClassNotFoundException classNotFoundException) {
			throw new CCEERuntimeException(classNotFoundException);
		}
	}
	
	private ConnectionFactory() {
		
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(rb.getString("driver.manager.oracle"),rb.getString("oracle.usr"),rb.getString("oracle.pwd"));
		} catch (SQLException sqlException) {
			throw new CCEERuntimeException(sqlException);
		}
	}
}