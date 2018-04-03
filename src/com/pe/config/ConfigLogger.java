package com.pe.config;

import java.util.HashMap;
import java.util.Map;

public class ConfigLogger {

	private boolean logMessage;
	private boolean logWarning;
	private boolean logError;
	private boolean logToDatabase;
	private boolean logToFile;
	private boolean logToConsole;

	private static Map<String, String> params = new HashMap<String, String>();

	public ConfigLogger(boolean logMessage, boolean logWarning, boolean logError, boolean logToDatabase,
			boolean logToFile, boolean logToConsole) {
		super();
		this.logMessage = logMessage;
		this.logWarning = logWarning;
		this.logError = logError;
		this.logToDatabase = logToDatabase;
		this.logToFile = logToFile;
		this.logToConsole = logToConsole;
	}

	public ConfigLogger() {
	};

	/**
	 * @return the logToConsole
	 */
	public boolean isLogToConsole() {
		return logToConsole;
	}

	/**
	 * @param logToConsole
	 *            the logToConsole to set
	 */
	public void setLogToConsole(boolean logToConsole) {
		this.logToConsole = logToConsole;
	}

	/**
	 * @return the logMessage
	 */
	public boolean isLogMessage() {
		return logMessage;
	}

	/**
	 * @param logMessage
	 *            the logMessage to set
	 */
	public void setLogMessage(boolean logMessage) {
		this.logMessage = logMessage;
	}

	/**
	 * @return the logWarning
	 */
	public boolean isLogWarning() {
		return logWarning;
	}

	/**
	 * @param logWarning
	 *            the logWarning to set
	 */
	public void setLogWarning(boolean logWarning) {
		this.logWarning = logWarning;
	}

	/**
	 * @return the logError
	 */
	public boolean isLogError() {
		return logError;
	}

	/**
	 * @param logError
	 *            the logError to set
	 */
	public void setLogError(boolean logError) {
		this.logError = logError;
	}

	/**
	 * @return the logToDatabase
	 */
	public boolean isLogToDatabase() {
		return logToDatabase;
	}

	/**
	 * @param logToDatabase
	 *            the logToDatabase to set
	 */
	public void setLogToDatabase(boolean logToDatabase) {
		this.logToDatabase = logToDatabase;
	}

	/**
	 * @return the logToFile
	 */
	public boolean isLogToFile() {
		return logToFile;
	}

	/**
	 * @param logToFile
	 *            the logToFile to set
	 */
	public void setLogToFile(boolean logToFile) {
		this.logToFile = logToFile;
	}

	public static Map<String, String> getParams() {
		return params;
	}

	public static void setParams(Map<String, String> params) {
		ConfigLogger.params = params;
	}

}
