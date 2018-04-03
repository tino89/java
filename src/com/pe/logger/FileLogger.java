package com.pe.logger;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.pe.common.Constant;
import com.pe.common.CustomFormatter;
import com.pe.common.Message;
import com.pe.config.ConfigLogger;

public class FileLogger implements GenericLogger {

	private static Logger logger = Logger.getLogger("file");

	public FileLogger() throws IOException {

		String path = ConfigLogger.getParams().get("file");

		if (path == null || path.compareTo("") == 0) {
			path = Constant.DEFAULT_PATH;
		}

		File logFile = new File(path);
		if (!logFile.exists()) {
			logFile.createNewFile();
		}

		FileHandler fh = new FileHandler(path, true);
		CustomFormatter formatter = new CustomFormatter();
		fh.setFormatter(formatter);
		logger.addHandler(fh);
		logger.setUseParentHandlers(false);
	}

	public void writeLog(Message msg) throws IOException {
		logger.log(Level.INFO, msg.toString());
	}

	@Override
	public void writeLog(List<Message> list) throws IOException {
		String str = "";
		for (Message msg : list) {
			str = str + msg.toString();
		}

		if (!StringUtils.isEmpty(str)) {
			str = StringUtils.substring(str, 0, str.length()-1);
			logger.log(Level.INFO, str);
		}

	}

}
