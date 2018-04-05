package com.pe;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import com.pe.common.Marked;
import com.pe.common.Message;
import com.pe.config.ConfigLogger;
import com.pe.logger.ConsoleLogger;
import com.pe.logger.DataBaseLogger;
import com.pe.logger.FileLogger;
import com.pe.logger.GenericLogger;

/**
 * @author tino
 *
 */

public class JobLogger {

	private ConfigLogger config;
	private List<Message> list;
	GenericLogger log;
	GenericLogger file;
	GenericLogger db;

	/**
	 * @param config
	 * @throws Exception
	 */
	public JobLogger(ConfigLogger config) throws Exception {
		this.config = config;
		this.validateConfig();
		this.log = new ConsoleLogger();
		this.file = new FileLogger();
		this.db = new DataBaseLogger();

	}

	/**
	 * @param messageText
	 * @param message
	 * @param warning
	 * @param error
	 * @throws Exception
	 *             Description: write log depending which type of log these are
	 *             (message, warning, error)
	 */
	public void saveLog(String messageText, boolean message, boolean warning, boolean error) throws Exception {

		if ((!config.isLogError() && !config.isLogMessage() && !config.isLogWarning())
				|| (!message && !warning && !error)) {
			throw new Exception("Error or Warning or Message must be specified");
		}

		if (StringUtils.isEmpty(messageText)) {
			throw new Exception("Message is empty");
		}

		list = new ArrayList<Message>();

		if (message && config.isLogMessage()) {
			Message msg = new Message();
			msg.setLevel(Marked.MESSAGE);
			msg.setText(messageText);
			list.add(msg);
		}

		if (warning && config.isLogWarning()) {
			Message wag = new Message();
			wag.setLevel(Marked.WARNING);
			wag.setText(messageText);
			list.add(wag);
		}

		if (error && config.isLogError()) {
			Message err = new Message();
			err.setLevel(Marked.ERROR);
			err.setText(messageText);
			list.add(err);
		}

		if (config.isLogToConsole()) {
			this.log.writeLog(list);
		}

		if (config.isLogToFile()) {
			this.file.writeLog(list);
		}

		if (config.isLogToDatabase()) {
			this.db.writeLog(list);
		}

	}

	/**
	 * @param msg
	 * @param marked
	 * @throws Exception
	 */
	public void saveLog(String msg, Marked marked) throws Exception {

		list = new ArrayList<Message>();
		list.add(new Message(marked, msg));

		switch (marked) {
		case ERROR:
			config.setLogError(true);
			saveLog(msg, false, false, true);
			break;
		case WARNING:
			config.setLogWarning(true);
			saveLog(msg, false, true, false);
			break;
		case MESSAGE:
			config.setLogMessage(true);
			saveLog(msg, true, false, false);
			break;
		}

	}

	private void validateConfig() throws Exception {
		if (!config.isLogToConsole() && !config.isLogToFile() && !config.isLogToDatabase()) {
			throw new Exception("Invalid configuration");
		}

	}

	/**
	 * @return the list
	 */
	public List<Message> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Message> list) {
		this.list = list;
	}

}
