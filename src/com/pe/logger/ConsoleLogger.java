package com.pe.logger;

import java.io.IOException;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import com.pe.common.CustomFormatter;
import com.pe.common.Message;

public class ConsoleLogger implements GenericLogger {

	private static Logger logger = Logger.getLogger("console");;
	private ConsoleHandler handler;

	public ConsoleLogger() {
		this.handler = new ConsoleHandler();
		logger.setUseParentHandlers(false);
		CustomFormatter formatter = new CustomFormatter();
		this.handler.setFormatter(formatter);
		logger.addHandler(this.handler);
	}

	public void writeLog(Message msg) {
		logger.log(Level.INFO, msg.toString());
		this.handler.close();
	}

	@Override
	public void writeLog(List<Message> list) throws IOException {
		String str = "";
		for (Message msg : list) {
			str = str + msg.toString();
		}
		if (!StringUtils.isEmpty(str)) {
			str = StringUtils.substring(str, 0, str.length() - 1);
			logger.log(Level.INFO, str);
		}
	}

}
