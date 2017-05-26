package fr.aumjaud.antoine.services.file.requesthandler;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.aumjaud.antoine.services.common.security.NoAccessException;
import fr.aumjaud.antoine.services.common.security.WrongRequestException;
import spark.Request;
import spark.Response;

public class FileResource2 {
	private static final Logger logger = LoggerFactory.getLogger(FileResource.class);

	private Properties properties;

	/**
	 * Set config 
	 * @param properties the config to set
	 */
	public void setConfig(Properties properties) {
		this.properties = properties;
		//fileService.setConfig(properties);
	}

	/**
	 * Search for something in a file
	 */
	public String search(Request request, Response response) {
		return null;
	}
}
