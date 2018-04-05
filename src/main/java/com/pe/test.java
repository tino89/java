package com.pe;

import java.util.HashMap;
import java.util.Map;

import com.pe.common.Marked;
import com.pe.config.ConfigLogger;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ConfigLogger config = new ConfigLogger();

		config.setLogError(true);
		config.setLogMessage(true);
		config.setLogWarning(true);

		config.setLogToConsole(true);
		config.setLogToFile(true);
		config.setLogToDatabase(true);

		Map<String, String> map = new HashMap<String, String>();

		map.put("file", "output/tinochagua.txt");
		map.put("database", "jdbc:sqlite:output/test.db");
		ConfigLogger.setParams(map);

		JobLogger a = new JobLogger(config);

		a.saveLog("tino chagua callupe", false, true, true);

		a.saveLog("prueba", Marked.ERROR);
		
		a.saveLog("prueba", Marked.MESSAGE);
		
	}

}
