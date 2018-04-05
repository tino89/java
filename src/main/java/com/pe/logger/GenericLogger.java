package com.pe.logger;

import java.io.IOException;
import java.util.List;
import com.pe.common.Message;

public interface GenericLogger {

	public void writeLog(Message msg) throws Exception;
	
	public void writeLog(List<Message> msg) throws Exception;

}
