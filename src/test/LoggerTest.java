package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import com.pe.JobLogger;
import com.pe.config.ConfigLogger;

public class LoggerTest {

	public ConfigLogger config;

	private final static String MESSAGE_LOG = "TEST";

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Before
	public void setConfig() {
		config = new ConfigLogger();

	}

	@Test
	// show all types of log (error, message, warning)
	public void CountTotalTypesLogtoShow() throws Exception {
		//
		config.setLogToConsole(true);
		// show 3 message types
		config.setLogError(true);
		config.setLogWarning(true);
		config.setLogMessage(true);
		JobLogger logger = new JobLogger(config);
		logger.saveLog(MESSAGE_LOG, true, true, true);
		assertEquals(3, logger.getList().size());
	}
	
	
	
	@Test
	// show all types of log (error, message, warning)
	public void OneTypesLogtoShow() throws Exception {
		//
		config.setLogToConsole(true);
		// show 1 message types
		config.setLogError(true);
		JobLogger logger = new JobLogger(config);
		logger.saveLog(MESSAGE_LOG, true, true, true);
		assertEquals(1, logger.getList().size());
	}


	@Test
	/*
	 * Verify if the initial configuration is well for JobLogger Class
	 */
	public void BadConfigurationException() throws Exception {

		boolean thrown = false;

		try {
			JobLogger logger = new JobLogger(config);
			logger.saveLog(MESSAGE_LOG, false, false, false);
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);

	}

	@Test
	/*
	 * Verify if the initial configuration is well for JobLogger Class
	 */
	public void NoDefineTypeLog() throws Exception {

		config.setLogToConsole(true);

		boolean thrown = false;

		try {
			JobLogger logger = new JobLogger(config);
			logger.saveLog(MESSAGE_LOG, false, false, false);
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);

	}

}
