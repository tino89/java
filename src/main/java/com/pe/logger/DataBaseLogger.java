package com.pe.logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.pe.common.Constant;
import com.pe.common.Marked;
import com.pe.common.Message;
import com.pe.config.ConfigLogger;

public class DataBaseLogger implements GenericLogger {

	Connection connection = null;

	public DataBaseLogger() throws Exception {

		String database = ConfigLogger.getParams().get("database");

		String driver = ConfigLogger.getParams().get("driver");

		if (database == null || database.compareTo("") == 0) {
			database = Constant.DEFAULT_DATA_BASE;
		}

		if (driver == null || driver.compareTo("") == 0) {
			driver = Constant.DEFAULT_DRIVER;
		}
		Class.forName(driver);
		if (connection == null) {
			connection = DriverManager.getConnection(database);
		}

	}

	public void writeLog(Message msg) throws Exception {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(insert(msg.getText(), msg.getLevel()));
		connection.close();
	}

	@Override
	public void writeLog(List<Message> list) throws Exception {
		Statement stmt = connection.createStatement();
		for (Message msg : list) {
			stmt.executeUpdate(insert(msg.toString(), msg.getLevel()));
		}
	}

	private String insert(String msg, Marked marked) {
		return "INSERT INTO Log_Values  VALUES ('" + msg + "', '" + marked + "')";
	}

}
